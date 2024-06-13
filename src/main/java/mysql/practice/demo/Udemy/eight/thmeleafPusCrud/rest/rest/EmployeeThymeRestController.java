package mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.rest;

import mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.entity.EmployeeThyme;
import mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.service.EmployeeServiceThyme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeThymeRestController {
    private EmployeeServiceThyme employeeService;


    @Autowired
    public EmployeeThymeRestController(EmployeeServiceThyme theEmployeeService) {
        employeeService = theEmployeeService;

    }

    @GetMapping("/thymeleaf/employee/services/employees")
    public String findAll( Model theModel) {
        List<EmployeeThyme> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees", theEmployees);
        return "employee/list-employees";
    }
 @GetMapping("/thymeleaf/employee/services/showFormForAdd")
    public String showFormForAdd( Model theModel) {
        EmployeeThyme employeeThyme = new EmployeeThyme();
        theModel.addAttribute("EmployeeThyme", employeeThyme);
        return "employee/employee-form";
    }
@GetMapping("/thymeleaf/employee/services/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        Optional<EmployeeThyme> employeeThyme  = employeeService.findById(theId);
        model.addAttribute("EmployeeThyme", employeeThyme);
        return "employee/employee-form";
    }

    @GetMapping("/thymeleaf/employee/services/employees/{empId}")
    public Optional<EmployeeThyme> getEmployee(@PathVariable int empId) {
        Optional<EmployeeThyme> EmployeeThyme = employeeService.findById(empId);
        if (EmployeeThyme == null) {
            throw new RuntimeException("Employee Id not found ");
        }
        return EmployeeThyme;
    }

    @PostMapping("/thymeleaf/employee/services/employees/save")
    public String saveEmployee(@ModelAttribute("EmployeeThyme") EmployeeThyme employeeThyme) {

        employeeService.save(employeeThyme);
        return "redirect:/thymeleaf/employee/services/employees";
    }

    @PutMapping("/thymeleaf/employee/services/employees")
    public EmployeeThyme updateEmployee(@RequestBody EmployeeThyme EmployeeThyme) {
        EmployeeThyme employeeSave = employeeService.save(EmployeeThyme);
        return employeeSave;
    }

    @GetMapping("/thymeleaf/employee/services/delete")
    public String deleteEmployee(@RequestParam("employeeId") int empId) {
        Optional<EmployeeThyme> EmployeeThyme = employeeService.findById(empId);


        employeeService.delete(empId);
        return "redirect:/thymeleaf/employee/services/employees";
    }


}
