package mysql.practice.demo.Udemy.second.hybernateJpa.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import mysql.practice.demo.Udemy.second.hybernateJpa.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentsDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Students theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Students findById(Integer id) {
        return entityManager.find(Students.class, id);
    }

    @Override
    public List<Students> findAll() {
        TypedQuery<Students> theQuery = entityManager.createQuery("FROM Students", Students.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Students> findAllOrderBy() {
        TypedQuery<Students> theQuery = entityManager.createQuery("FROM Students order by lastName", Students.class);
        return theQuery.getResultList();

    }

    @Override
    public List<Students> findByLastName(String name) {
        TypedQuery<Students> theQuery = entityManager.createQuery("FROM Students where lastName=:theName", Students.class);
        theQuery.setParameter("theName",name);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void upadate(Students students) {
entityManager.merge(students);
    }

    @Override
    @Transactional
    public void delete(Students students) {
        entityManager.remove(students);
    }

    @Override
    @Transactional
    public int deleteAllByLastName(String name) {
        entityManager.createQuery("Delete FROM Students where lastName=:theName")
                .setParameter("theName",name)
                .executeUpdate();
        return 1;

    }


}
