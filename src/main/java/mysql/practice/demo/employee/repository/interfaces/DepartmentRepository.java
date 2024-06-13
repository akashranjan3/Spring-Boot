package mysql.practice.demo.employee.repository.interfaces;

import mysql.practice.demo.employee.table.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
