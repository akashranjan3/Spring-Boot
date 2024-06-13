package mysql.practice.demo.student;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/name")
    public  String MyName(){
        return "Akash";
    }


    @RequestMapping("/ranjan")
    public  String MyNameRanjan(){
        return "ranjan bhai";
    }

    @RequestMapping("/ranjan2")
    public  String MyNameRanjan2(){
        return "ranjan2";
    }





}
