package mysql.practice.demo.Udemy.first.rest.coach.autowire.constructor;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy // bean will be created when they are requested, if it is unused bean will not be created
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // for singleton implementation
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // a new bean is injected everytime
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice Fast bowling for 15 mint...... ";
    }
}
