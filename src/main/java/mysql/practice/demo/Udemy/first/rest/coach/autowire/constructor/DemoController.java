package mysql.practice.demo.Udemy.first.rest.coach.autowire.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public  DemoController(@Qualifier("footballCoach") Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/workout")
    public  String dailyWorkout(){
        return  myCoach.getDailyWorkout();
    }





}
