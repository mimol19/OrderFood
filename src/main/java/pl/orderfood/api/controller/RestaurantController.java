package pl.orderfood.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.orderfood.api.dto.AddressDTO;
import pl.orderfood.api.dto.MealDTO;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.api.dto.mapper.AddressMapper;
import pl.orderfood.api.dto.mapper.MealMapper;
import pl.orderfood.api.dto.mapper.RestaurantMapper;
import pl.orderfood.business.AddressService;
import pl.orderfood.business.MealService;
import pl.orderfood.business.RestaurantService;
import pl.orderfood.domain.Address;
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
    private final RestaurantService restaurantService;
    private final MealService mealService;
    private final AddressService addressService;
    private final RestaurantMapper restaurantMapper;
    private final AddressMapper addressMapper;
    private final MealMapper mealMapper;
    private final UserRepository userRepository;


    @GetMapping(value = "/restaurant")
    public String RestaurantPage(Model model, Principal principal) {
        String username = principal.getName();
        UserEntity user = userRepository.findByUsername(username);
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
            @Valid @ModelAttribute("restaurantDTO") RestaurantDTO restaurantDTO, @ModelAttribute("mealDTO") MealDTO mealDTO,
            BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "error";
        }

        String username = principal.getName();
        Restaurant restaurant = restaurantMapper.map(restaurantDTO);
        restaurantService.saveRestaurant(restaurant, username);

        return "redirect:/existing_restaurant";
    }

    @GetMapping(value ="/existing_restaurant")
    public String listMeals(Model model, Principal principal) {
        MealDTO mealDTO = new MealDTO();
        model.addAttribute("mealDTO", mealDTO);
        AddressDTO addressDTO = new AddressDTO();
        model.addAttribute("addressDTO", addressDTO);

        String username = principal.getName();
        List<MealDTO> mealList = getRestaurantMeals(username);
        model.addAttribute("mealList", mealList);

        return "existing_restaurant";
    }


    @PostMapping(value = "/add_meal")
    public String createMeal(
            @Valid @ModelAttribute("mealDTO") MealDTO mealDTO, @ModelAttribute("photo") MultipartFile photo,
            BindingResult result, Principal principal) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }

        String base64Photo = convertToBase64(photo);
        mealDTO.setMealPhoto(base64Photo);

        String username = principal.getName();
        Meal meal = mealMapper.mapFromDTO(mealDTO);

        mealService.saveMeal(meal, username);
        return "redirect:/existing_restaurant";
    }

    @PostMapping(value = "add_delivery_street")
    public String addDeliveryStreet(
           @Valid @ModelAttribute("addressDTO") AddressDTO addressDTO,
            BindingResult result, Principal principal) throws IOException {
        if (result.hasErrors()) {
            return "error";
        }

        String username = principal.getName();
        addressDTO.setNumber(0);
        Address address = addressMapper.mapFromDTO(addressDTO);

        addressService.saveAddress(address, username);
        return "redirect:/existing_restaurant";
    }

    private static String convertToBase64(MultipartFile photo) throws IOException {
        byte[] bytes = photo.getBytes();
        String s = Base64.getEncoder().encodeToString(bytes);
        return s;
    }

    private List<MealDTO> getRestaurantMeals(String username) {
        return mealService.getRestaurantMeals(username).stream()
                .map(mealMapper::mapToDTO)
                .toList();
    }

}
