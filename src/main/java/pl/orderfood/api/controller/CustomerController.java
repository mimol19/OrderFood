package pl.orderfood.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.orderfood.api.dto.*;
import pl.orderfood.api.dto.mapper.*;
import pl.orderfood.business.MealService;
import pl.orderfood.business.OrderService;
import pl.orderfood.business.RestaurantService;
import pl.orderfood.domain.Address;
import pl.orderfood.domain.Customer;
import pl.orderfood.domain.Order;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
public class CustomerController {
    static final String RESTAURANT = "/customer";
    private final RestaurantMapper restaurantMapper;
    private final RestaurantService restaurantService;
    private final MealService mealService;
    private final OrderService orderService;
    private final MealMapper mealMapper;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final AddressMapper addressMapper;

    @GetMapping("/street")
    public String showStreetForm(Model model) {
        AddressDTO addressDTO = new AddressDTO();
        model.addAttribute(addressDTO);

        return "street";
    }

    @GetMapping("/find_restaurant")
    public String findRestaurants(@ModelAttribute("addressDTO") AddressDTO addressDTO,
                                  Model model,
                                  Principal principal) {
        System.out.println("ffffffffffffffffffffffffffffffffffffffffssssssssssssssssssssssssssssssss");
        System.out.println(addressDTO);
        Address address = addressMapper.mapFromDTO(addressDTO);

        List<RestaurantDTO> restaurantList = getRestaurantByAddress(address);

        model.addAttribute("restaurantList", restaurantList);
        return "restaurants_result";
    }

    @PostMapping("/select_restaurant/{restaurantId}")
    public String selectRestaurant(@PathVariable Integer restaurantId, Model model) {
        List<MealDTO> mealList = getMealsByRestaurant(restaurantId);
        for (MealDTO meal : mealList) {
            System.out.println(meal);
        }
        model.addAttribute("mealList", mealList);
        model.addAttribute("restaurantId", restaurantId);

        OrderDTO orderDTO = new OrderDTO();


        model.addAttribute("orderDTO", orderDTO);

        return "menu";
    }

    @PostMapping("create_order")
    public String addItem(@ModelAttribute("orderDTO") OrderDTO orderDTO,
                          @ModelAttribute("customerDTO") CustomerDTO customerDTO,
                          @RequestParam("restaurantId") String restaurantId
    ) {
        System.out.println("ordeeeeeeeeeeerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
        System.out.println("Order Details:");
        System.out.println(orderDTO);
        for (ItemDTO item : orderDTO.getItemList()) {
            System.out.println(item);
        }


        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(Integer.valueOf(restaurantId));
        orderDTO.setRestaurant(restaurantDTO);

        Order order = orderMapper.mapFromDTO(orderDTO);

//        Customer customer = customerMapper.mapFromDTO(customerDTO);

        orderService.saveOrderAndCustomer(order);
        return "home";
    }
    private List<MealDTO> getMealsByRestaurant(Integer id) {
        return mealService.getMealsByRestaurant(id).stream()
                .map(mealMapper::mapToDTO).toList();
    }


    private List<RestaurantDTO> getRestaurantByAddress(Address address) {
        return restaurantService.getRestaurantByAddress(address).stream()
                .map(restaurantMapper::mapToDTO).toList();
    }


}
