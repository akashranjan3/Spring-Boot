package mysql.practice.demo.employee;


import mysql.practice.demo.employee.repository.interfaces.DepartmentRepository;
import mysql.practice.demo.employee.repository.interfaces.EmployeeRepository;
import mysql.practice.demo.employee.table.Department;
import mysql.practice.demo.employee.table.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerURL {

    @Autowired
    EmployeeRepository employeeRepository ;

    @Autowired
    DepartmentRepository departmentRepository;


    @GetMapping("/employee")
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    @GetMapping("/department")
    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

    @GetMapping("/department/{dept}/employee")
    public List<Employee> getDepartmentEmployee(@PathVariable("dept") int dept){

        Optional<Department> department = departmentRepository.findById(dept);

        return employeeRepository.findByDepartment(department);

//        return departmentRepository.findAll();
    }


}
