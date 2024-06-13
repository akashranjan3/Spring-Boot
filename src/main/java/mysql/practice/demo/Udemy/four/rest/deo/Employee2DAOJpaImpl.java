package mysql.practice.demo.Udemy.four.rest.deo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import mysql.practice.demo.Udemy.four.rest.entity.Employee2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Employee2DAOJpaImpl implements Employee2DAO {

    private EntityManager entityManager;

    @Autowired
    public Employee2DAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee2> findAll() {
        TypedQuery<Employee2> theQuery = entityManager.createQuery("from Employee2", Employee2.class);
        List<Employee2> employees2 = theQuery.getResultList();
        return employees2;
    }

    @Override
    public Employee2 findById(int id) {
        return entityManager.find(Employee2.class, id);
    }

    @Override
    public Employee2 save(Employee2 employee2) {
        Employee2 employee21 = entityManager.merge(employee2);
        return employee21;

    }

    @Override
    public void delete(int id) {
        Employee2 theEmployee = entityManager.find(Employee2.class, id);
        entityManager.remove(theEmployee);
    }
}
