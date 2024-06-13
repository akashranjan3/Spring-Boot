package mysql.practice.demo.Udemy.five.jpa.rest.rest;

import mysql.practice.demo.Udemy.five.jpa.rest.entity.Employee3;
import mysql.practice.demo.Udemy.five.jpa.rest.service.EmployeeService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/udemy/employee/services")
public class Employee3RestController {
    private EmployeeService2 employeeService;


    @Autowired
    public Employee3RestController(EmployeeService2 theEmployeeService) {
        employeeService = theEmployeeService;

    }

    @GetMapping("/employees")
    public List<Employee3> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{empId}")
    public Optional<Employee3> getEmployee(@PathVariable int empId) {
        Optional<Employee3> Employee3 = employeeService.findById(empId);
        if (Employee3 == null) {
            throw new RuntimeException("Employee Id not found ");
        }
        return Employee3;
    }

    @PostMapping("/employees")
    public Employee3 saveEmployee(@RequestBody Employee3 Employee3) {
        Employee3.setId(0);
        Employee3 employeeSave = employeeService.save(Employee3);
        return employeeSave;
    }

    @PutMapping("/employees")
    public Employee3 updateEmployee(@RequestBody Employee3 Employee3) {
        Employee3 employeeSave = employeeService.save(Employee3);
        return employeeSave;
    }

    @DeleteMapping("/employees/{empId}")
    public String deleteEmployee(@PathVariable int empId) {
        Optional<Employee3> Employee3 = employeeService.findById(empId);

        if (Employee3 == null) {
            throw new RuntimeException("This employee does not exist in our database ");
        }
        employeeService.delete(empId);
        return "Employee deleted with id : "+empId;
    }


}
