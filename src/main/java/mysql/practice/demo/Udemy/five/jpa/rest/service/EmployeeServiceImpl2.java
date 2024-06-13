package mysql.practice.demo.Udemy.five.jpa.rest.service;

import jakarta.transaction.Transactional;
import mysql.practice.demo.Udemy.five.jpa.rest.dao.EmployeeRepository3;
import mysql.practice.demo.Udemy.five.jpa.rest.entity.Employee3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl2 implements EmployeeService2 {

    private EmployeeRepository3 employeeRepository;

    @Autowired
    public EmployeeServiceImpl2(EmployeeRepository3 theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;

    }

    @Override
    public List<Employee3> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee3> findById(int id) {
        Optional<Employee3> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            return employeeRepository.findById(id);
        } else {
            throw new RuntimeException("Could not find this employee");
        }
    }

    @Transactional
    @Override
    public Employee3 save(Employee3 Employee3) {
        return employeeRepository.save(Employee3);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
