package mysql.practice.demo.Udemy.nine.security.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/ShowMyLoginPage")
    public String showMyLoginPage(){
        return "plain-login";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-deneid";
    }
}
