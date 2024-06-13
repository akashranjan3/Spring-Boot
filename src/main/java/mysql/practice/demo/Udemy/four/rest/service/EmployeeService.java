package mysql.practice.demo.Udemy.four.rest.service;

import mysql.practice.demo.Udemy.four.rest.entity.Employee2;
import mysql.practice.demo.Udemy.second.hybernateJpa.entity.Students;

import java.util.List;

public interface EmployeeService {
    List<Employee2> findAll();

    Employee2 findById(int id);

    Employee2 save(Employee2 employee2);

    void delete(int id);
}
