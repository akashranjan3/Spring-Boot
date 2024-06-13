package mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.service;

import mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.entity.EmployeeThyme;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceThyme {
    List<EmployeeThyme> findAll();

    Optional<EmployeeThyme> findById(int id);

    EmployeeThyme save(EmployeeThyme Employee3);

    void delete(int id);
}
