package mysql.practice.demo.Udemy.third.exceptionHandling.entity;

public class Student2 {
    private  String firstName;
    private  String lastName;

    public Student2() {
    }

    public Student2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}
