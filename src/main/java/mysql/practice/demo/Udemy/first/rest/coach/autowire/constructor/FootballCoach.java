package mysql.practice.demo.Udemy.first.rest.coach.autowire.constructor;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
// if we dont want qualifier we can mark one component as primary
//@Qualifier has higher piority than @Primary
public class FootballCoach implements Coach {

    @PostConstruct
    public  void myPostConstruct(){
        System.out.println("my post constructor : "+ getClass().getSimpleName());
    }
    @PreDestroy
    public  void myPreDestroy(){
        System.out.println("my PreDestroy : "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice Football everyday";
    }
}
