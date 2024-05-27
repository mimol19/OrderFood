package pl.orderfood.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MenuServiceController {
    public static final String CREATE_MEAL = "/menu";

//    @PostMapping(value = CREATE_MEAL)
//    public String createMeal(Model model) {
//        model.addAttribute(model);
//        return "menu";
//
//    }

}
