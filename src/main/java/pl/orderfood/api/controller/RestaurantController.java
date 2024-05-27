package pl.orderfood.api.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.api.dto.mapper.MealMapper;
import pl.orderfood.api.dto.mapper.RestaurantMapper;
import pl.orderfood.business.MealService;
import pl.orderfood.business.RestaurantService;
import pl.orderfood.domain.Meal;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.database.entity.RestaurantEntity;
import pl.orderfood.infrastructure.security.UserEntity;
import pl.orderfood.infrastructure.security.UserRepository;

import java.io.IOException;
import java.security.Principal;
import java.util.Base64;
import java.util.List;


@RequiredArgsConstructor
@Controller
public class RestaurantController {
    static final String RESTAURANT = "/restaurant";
    static final String EXISTING_RESTAURANT = "/existing_restaurant";
    private final RestaurantService restaurantService;
    private final MealService mealService;
    private final RestaurantMapper restaurantMapper;
    private final MealMapper mealMapper;
    private final UserRepository userRepository;


    @GetMapping(value = RESTAURANT)
    public String RestaurantPage(Model model, Principal principal) {
        String username = principal.getName();
        UserEntity user = userRepository.findByUserName(username);
        RestaurantEntity existing = user.getRestaurant();

        if (existing != null) {
            return "redirect:/existing_restaurant";
        }
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        model.addAttribute("restaurantDTO", restaurantDTO);
        return "restaurant";
    }

    @PostMapping(value = "/add_restaurant")
    public String createRestaurant(
            @ModelAttribute("restaurantDTO") RestaurantDTO restaurantDTO, @ModelAttribute("mealDTO") MealDTO mealDTO,
            BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "error";
        }

        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        String username = principal.getName();
        Restaurant restaurant = restaurantMapper.map(restaurantDTO);
        restaurantService.saveRestaurant(restaurant, username);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        return "existing_restaurant";
    }
    @GetMapping(value = EXISTING_RESTAURANT)
    public String listMeals(Model model, Principal principal) {
        System.out.println("getmapping existingrestaurant");
        MealDTO mealDTO = new MealDTO();
        model.addAttribute("mealDTO", mealDTO);

        String username = principal.getName();
        List<MealDTO> mealList = getRestaurantMeals(username);
        model.addAttribute("mealList", mealList);

        return "existing_restaurant";
    }


    @PostMapping(value = "/add_meal")
    public String createMeal(
            @ModelAttribute("mealDTO") MealDTO mealDTO, @ModelAttribute("mealPhoto") MultipartFile photo,
            BindingResult result, Principal principal) throws IOException {
        if (result.hasErrors()) {
//            List<MealDTO> mealList = getRestaurantMeals();
//            model.addAttribute("mealList", mealList);
            return "existing_restaurant";
        }

        // do przepisania ładniej
        byte[] bytes = photo.getBytes();
        String s = Base64.getEncoder().encodeToString(bytes);
        mealDTO.setMealPhoto(s);

        String username = principal.getName();
        System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
        Meal meal = mealMapper.mapFromDTO(mealDTO);

        mealService.saveMeal(meal,username);
        return  "redirect:/existing_restaurant";
    }

    private List<MealDTO> getRestaurantMeals(String username) {
        return mealService.getRestaurantMeals(username).stream()
                .map(mealMapper::mapToDTO)
                .toList();
    }


}
