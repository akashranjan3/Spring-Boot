package mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.dao;

import mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.entity.EmployeeThyme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepositoryThyme extends JpaRepository<EmployeeThyme, Integer> {
    public List<EmployeeThyme> findAllByOrderByLastNameAsc();
}
