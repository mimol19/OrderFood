package pl.orderfood.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.orderfood.api.dto.AddressDTO;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.OrderDTO;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.api.dto.mapper.OrderMapper;
import pl.orderfood.business.OrderService;
import pl.orderfood.domain.Order;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/restaurant_orders")
    public String showRestaurantOrders(Model model, Principal principal) {
        String username = principal.getName();
        List<OrderDTO> orderList = getRestaurantOrders(username);
        System.out.println(orderList.getFirst().getItemList().getFirst().getMeal().getName());
        model.addAttribute("orderList", orderList);

        return "restaurant_orders";
    }

    private List<OrderDTO> getRestaurantOrders(String username) {
        return orderService.getRestaurantOrders(username).stream()
                .map(orderMapper::mapToDTO)
                .toList();
    }

    @PostMapping("/complete_order/{orderId}")
    public String completeOrder(@PathVariable Integer orderId) {
        orderService.completeOrder(orderId);

        return "redirect:/restaurant_orders";
    }

    @PostMapping("/create_order")
    public String addItem(@Valid @ModelAttribute("orderDTO") OrderDTO orderDTO,
                          @RequestParam("restaurantId") String restaurantId,
                          BindingResult result,
                          Model model
    ) {
        if (result.hasErrors()) {
            return "error";
        }

        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(Integer.valueOf(restaurantId));
        orderDTO.setRestaurant(restaurantDTO);

        removeEmptyItems(orderDTO);

        Order order = orderMapper.mapFromDTO(orderDTO);

        Order savedOrder = orderService.saveOrderAndCustomer(order);

        model.addAttribute("orderId", savedOrder.getOrderId());

        return "redirect:/create_order?orderId=" + savedOrder.getOrderId();
    }

    @GetMapping("/create_order")
    public String showOrder(@RequestParam("orderId") Integer orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        OrderDTO orderDTO = orderMapper.mapToDTO(order);
        calculateAmount(orderDTO);

        model.addAttribute("orderDTO", orderDTO);
        return "payment";
    }
    private void calculateAmount(OrderDTO orderDTO) {
        BigDecimal sum = orderDTO.getItemList().stream()
                .map(item -> BigDecimal.valueOf(item.getQuantity()).multiply(item.getMeal().getPrice()))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        orderDTO.setAmount(sum);
    }

    private void removeEmptyItems(OrderDTO orderDTO) {
        orderDTO.getItemList().removeIf(itemDTO -> itemDTO.getQuantity()==0);
    }

}
