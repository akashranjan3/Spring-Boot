package mysql.practice.demo.Udemy.four.rest.service;

import jakarta.transaction.Transactional;
import mysql.practice.demo.Udemy.four.rest.deo.Employee2DAO;
import mysql.practice.demo.Udemy.four.rest.entity.Employee2;
import mysql.practice.demo.Udemy.second.hybernateJpa.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Employee2DAO employee2DAO;

    @Autowired
    public EmployeeServiceImpl(Employee2DAO theEmployee2DAO) {
        employee2DAO = theEmployee2DAO;

    }

    @Override
    public List<Employee2> findAll() {
        return employee2DAO.findAll();
    }

    @Override
    public Employee2 findById(int id) {
        return employee2DAO.findById(id);
    }

    @Transactional
    @Override
    public Employee2 save(Employee2 employee2) {
        return employee2DAO.save(employee2);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employee2DAO.delete(id);
    }
}
