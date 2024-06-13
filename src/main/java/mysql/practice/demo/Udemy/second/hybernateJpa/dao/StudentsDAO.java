package mysql.practice.demo.Udemy.second.hybernateJpa.dao;

import mysql.practice.demo.Udemy.second.hybernateJpa.entity.Students;

import java.util.List;

public interface StudentsDAO {

    void  save(Students theStudent);

    Students findById(Integer id);

    List<Students> findAll();

    List<Students> findAllOrderBy();
    List<Students> findByLastName( String name);

    void upadate(Students students);

    void delete(Students students);
    int deleteAllByLastName(String lastname);
}
