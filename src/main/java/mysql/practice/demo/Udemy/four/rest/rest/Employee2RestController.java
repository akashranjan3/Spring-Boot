package mysql.practice.demo.Udemy.four.rest.rest;

import mysql.practice.demo.Udemy.four.rest.deo.Employee2DAO;
import mysql.practice.demo.Udemy.four.rest.entity.Employee2;
import mysql.practice.demo.Udemy.four.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class Employee2RestController {
    //    private Employee2DAO employee2DAO;
    private EmployeeService employeeService;


    @Autowired
    public Employee2RestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;

    }

    @GetMapping("/employees2")
    public List<Employee2> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees2/{empId}")
    public Employee2 getEmployee(@PathVariable int empId) {
        Employee2 employee2 = employeeService.findById(empId);
        if (employee2 == null) {
            throw new RuntimeException("Employee Id not found ");
        }
        return employee2;
    }

    @PostMapping("/employees2")
    public Employee2 saveEmployee(@RequestBody Employee2 employee2) {
        employee2.setId(0);
        Employee2 employeeSave = employeeService.save(employee2);
        return employeeSave;
    }

    @PutMapping("/employees2")
    public Employee2 updateEmployee(@RequestBody Employee2 employee2) {
        Employee2 employeeSave = employeeService.save(employee2);
        return employeeSave;
    }

    @DeleteMapping("/employees2/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        Employee2 employee2 = employeeService.findById(empId);

        if (employee2 == null) {
            throw new RuntimeException("This employee does not exist in our database ");
        }
        employeeService.delete(empId);
        return "Employee deleted with id : "+empId;
    }


}
