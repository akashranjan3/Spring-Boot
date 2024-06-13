package mysql.practice.demo.Udemy.eleven.aop.first.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Before("execution(public void addAccount())")
    public  void beforeAccountAdvice(){
        System.out.println("_____ Executing @ before advice on add account lol");
    }
}
