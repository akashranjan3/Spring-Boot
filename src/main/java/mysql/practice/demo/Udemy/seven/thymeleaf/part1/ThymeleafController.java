package mysql.practice.demo.Udemy.seven.thymeleaf.part1;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Controller

public class ThymeleafController {
    @GetMapping("/thymeleaf/page")
    public String myTime(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        List<String> names = Arrays.asList("Ram", "homal", "Raja", "tan");
        theModel.addAttribute("theDate", new java.util.Date());
        theModel.addAttribute("names", names);
        return "helloworld";
    }
}
