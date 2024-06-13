package mysql.practice.demo.Udemy.five.jpa.rest.service;

import mysql.practice.demo.Udemy.five.jpa.rest.entity.Employee3;

import java.util.List;
import java.util.Optional;

public interface EmployeeService2 {
    List<Employee3> findAll();

    Optional<Employee3> findById(int id);

    Employee3 save(Employee3 Employee3);

    void delete(int id);
}
