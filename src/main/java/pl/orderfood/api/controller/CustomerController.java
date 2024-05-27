package pl.orderfood.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.api.dto.mapper.RestaurantMapper;
import pl.orderfood.business.MakeOrderService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomerController {
    static final String RESTAURANT = "/customer";
    private final MakeOrderService makeOrderService;
    private final RestaurantMapper restaurantMapper;

//    @GetMapping("/street")
//    public String showStreetForm(Model model) {
//        model.addAttribute("streetName", "");
//        return "street";
//    }

//    @PostMapping("/street")
//    public String processStreetForm(String streetName, Model model) {
//        model.addAttribute("streetName", streetName);
//        System.out.println("ffffffffffffffffffffffffffffffffffffffffssssssssssssssssssssssssssssssss");
//
//        List<RestaurantDTO> restaurantList = getRestaurants(streetName);
//        System.out.println(streetName);
//        return "restaurants_result";
//    }
//
//    @GetMapping("/restaurants_result")
//    public String showResults() {
//        return "restaurants_result";
//    }

//    private List<RestaurantDTO> getRestaurants(String streetName) {
//        return makeOrderService.getRestaurants(streetName).stream()
//                .map(restaurantMapper::mapToDTO)
//                .toList();
//    }
}
