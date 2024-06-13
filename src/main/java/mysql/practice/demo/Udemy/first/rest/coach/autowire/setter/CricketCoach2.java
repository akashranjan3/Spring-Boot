package mysql.practice.demo.Udemy.first.rest.coach.autowire.setter;


import org.springframework.stereotype.Component;

@Component
public class CricketCoach2 implements Coach2 {
    @Override
    public String getDailyWorkout2() {
        return "Practice Fast bowling for 15 mint daily! setter ";
    }
}
