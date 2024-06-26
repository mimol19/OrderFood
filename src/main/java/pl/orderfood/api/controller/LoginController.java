package pl.orderfood.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class LoginController {

    public static final String LOGIN = "/login";
    @GetMapping(value = LOGIN)
    public String loginPage(){
        return "login";
    }

}
