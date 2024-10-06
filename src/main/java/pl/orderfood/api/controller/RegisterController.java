package pl.orderfood.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.orderfood.api.dto.RestaurantDTO;
import pl.orderfood.domain.Restaurant;
import pl.orderfood.infrastructure.security.OrderFoodUserDetailsService;
import pl.orderfood.infrastructure.security.RoleEntity;
import pl.orderfood.infrastructure.security.UserEntity;

@Controller
@AllArgsConstructor
public class RegisterController {
    public static final String REGISTER = "/register";

    private OrderFoodUserDetailsService userDetailsService;

    @RequestMapping(value = REGISTER,method = RequestMethod.GET)
    public String registerPage(Model model){
        UserEntity user = new UserEntity();
        model.addAttribute("userEntity", user);
        return "register";
    }


    @PostMapping(value = "/sign_in")
    public String createAccount(
            @ModelAttribute("userEntity") UserEntity user, BindingResult result, @RequestParam("role") String role) {
        if(result.hasErrors()){
            return "error";
        }

        userDetailsService.saveUser(user,role);
        return "home";
    }
}
