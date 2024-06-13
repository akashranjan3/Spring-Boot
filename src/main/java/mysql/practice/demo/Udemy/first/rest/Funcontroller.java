package mysql.practice.demo.Udemy.first.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Funcontroller {

    @Value("${my.name}")
    private   String  myName;

    @Value("${my.village}")
    private  String  myVillage;

    @GetMapping("/saymyname")
    public  String sayMyName(){
        return  "Hi, Akash Ranjan Verma, How are you";
    }
    @GetMapping("/saymorning")
    public  String saymorning(){
        return  "Hi, Akash Ranjan Verma, Good morning";
    }

    @GetMapping("/saynight")
    public  String saynight(){
        return  "Hi, Akash Ranjan Verma, Good night";
    }

    @GetMapping("/info")
    public String info() {
        return "Hi, "+myName+", you live in "+ myVillage;
    }

}
