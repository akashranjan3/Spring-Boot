package mysql.practice.demo.Udemy.nine.security.first.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
    @GetMapping("/")
    public String showHomeSecurity(){
        return "home";
    }
}