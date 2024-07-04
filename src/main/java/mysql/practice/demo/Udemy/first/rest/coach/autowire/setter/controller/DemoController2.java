package mysql.practice.demo.Udemy.first.rest.coach.autowire.setter.controller;

import mysql.practice.demo.Udemy.first.rest.coach.autowire.setter.Coach2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController2 {

    private Coach2 myCoach2;

    @Autowired
    public  void  setCoach2(Coach2 theCoach2){
        myCoach2 = theCoach2;
    }

    @GetMapping("/workoutsetter")
    public  String dailyWorkout2(){
        return  myCoach2.getDailyWorkout2();
    }

}
