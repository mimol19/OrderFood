package pl.orderfood.api.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.RestaurantDTO;
//import pl.orderfood.api.dto.mapper.MealMapper;
//import pl.orderfood.api.dto.mapper.RestaurantMapper;
import pl.orderfood.api.dto.What;
import pl.orderfood.business.MealService;
import pl.orderfood.business.RestaurantService;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Restaurant;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class RestaurantController {
    static final String RESTAURANT = "/restaurant";
    static final String EXISTING_RESTAURANT = "/existing_restaurant";
//    private final RestaurantService restaurantService;
//    private final MealService mealService;
//    private final RestaurantMapper restaurantMapper;
//    private final MealMapper mealMapper;


    @GetMapping(value = RESTAURANT)
    public String RestaurantPage() {
        return "restaurant";
    }

    @PostMapping(value ="/restaurant")
    public String createRestaurant(
            @ModelAttribute What what) {
        System.out.println(what);
        return "existing_restaurant";
    }
//
//
//    @PostMapping(value = RESTAURANT)
//    public String createRestaurant(
//            @ModelAttribute("restaurantDTO") RestaurantDTO restaurantDTO, BindingResult result) {
//        if(result.hasErrors()){
//            return "error";
//        }
//        Restaurant restaurant = restaurantMapper.map(restaurantDTO);
//        restaurantService.saveRestaurant(restaurant);
//        return "existing_restaurant";
//    }

//    @GetMapping(value = EXISTING_RESTAURANT)
//    public  String listMeals(Model model){
//        List<MealDTO> mealList = getMeals();
//        model.addAttribute("mealList", mealList);
//        return "existing_restaurant";
//    }

//    @PostMapping(value = EXISTING_RESTAURANT)
//    public String createMeal(
//            @ModelAttribute("mealDTO")MealDTO mealDTO, BindingResult result) {
//        if(result.hasErrors()){
//            return "error";
//        }
//        Meal meal = mealMapper.mapFromDTO(mealDTO);
//        mealService.saveMeal(meal);
//        return "existing_restaurant";
//    }

//    private List<MealDTO> getMeals() {
//        return mealService.getRestaurantMeals().stream()
//                .map(mealMapper::mapToDTO)
//                .toList();
//    }


}
