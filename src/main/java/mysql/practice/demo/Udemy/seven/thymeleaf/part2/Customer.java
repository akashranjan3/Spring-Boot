package mysql.practice.demo.Udemy.seven.thymeleaf.part2;


import jakarta.validation.constraints.*;
import mysql.practice.demo.Udemy.seven.thymeleaf.part2.validation.CourseCode;

public class Customer {

    @NotNull(message = "Is required")
    private String firstName;

    @NotNull(message = "Is required")
    @Size(message = "Is Required ", min = 10)
    private String lastName;

    @NotNull(message = "Is required")
    @Min(value = 0, message = "must be greater than 0 lol....")
    @Max(value = 10, message = "must be less than 10 lol....")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars/digit")
    private String postalCode;

    @CourseCode
    private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }


    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }
}

