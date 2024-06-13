package mysql.practice.demo.Udemy.seven.thymeleaf.part2.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class couseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private  String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix  = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        if(theCode==null)
            return false;
        return theCode.startsWith(coursePrefix);
    }
}
