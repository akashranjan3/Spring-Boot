package mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.service;

import jakarta.transaction.Transactional;
import mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.dao.EmployeeRepositoryThyme;
import mysql.practice.demo.Udemy.eight.thmeleafPusCrud.rest.entity.EmployeeThyme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceThymeImp implements EmployeeServiceThyme {

    private EmployeeRepositoryThyme employeeRepository;

    @Autowired
    public EmployeeServiceThymeImp(EmployeeRepositoryThyme theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;

    }

    @Override
    public List<EmployeeThyme> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Optional<EmployeeThyme> findById(int id) {
        Optional<EmployeeThyme> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            return employeeRepository.findById(id);
        } else {
            throw new RuntimeException("Could not find this employee");
        }
    }

    @Transactional
    @Override
    public EmployeeThyme save(EmployeeThyme Employee3) {
        return employeeRepository.save(Employee3);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
