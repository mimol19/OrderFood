package pl.orderfood.api.controller;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class HomeController {
    public static final String HOME = "/";

    @RequestMapping(value = HOME,method = RequestMethod.GET)
    public String homePage(){
        return "home";
    }



}
