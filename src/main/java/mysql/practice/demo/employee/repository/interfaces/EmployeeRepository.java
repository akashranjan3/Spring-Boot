package mysql.practice.demo.employee.repository.interfaces;

import mysql.practice.demo.employee.table.Department;
import mysql.practice.demo.employee.table.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {


    List<Employee> findByDepartment(Optional<Department> department);
}
