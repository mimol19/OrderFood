package pl.orderfood.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import pl.orderfood.api.dto.AddressDTO;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.OrderDTO;
import pl.orderfood.api.dto.mapper.OrderMapper;
import pl.orderfood.business.OrderService;

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


}
