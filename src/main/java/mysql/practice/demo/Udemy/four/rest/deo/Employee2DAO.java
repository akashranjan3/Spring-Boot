package mysql.practice.demo.Udemy.four.rest.deo;

import mysql.practice.demo.Udemy.four.rest.entity.Employee2;

import java.util.List;

public interface Employee2DAO {
    List<Employee2> findAll();

    Employee2 findById(int id);

    Employee2 save(Employee2 employee2);

    void delete(int id);

}
