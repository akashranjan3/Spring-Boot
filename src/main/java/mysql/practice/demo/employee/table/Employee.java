package mysql.practice.demo.employee.table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

@Entity
public class Employee {

    @Id
    private  int id ;
    private  String name;
    private  int salary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private  Department department;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartmentId(int departmentId) {
        this.department = department;
    }

    public Employee() {
    }

    public Employee(int id, String name, int salary, int departmentId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
