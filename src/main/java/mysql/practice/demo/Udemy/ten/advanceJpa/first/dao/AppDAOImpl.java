package mysql.practice.demo.Udemy.ten.advanceJpa.first.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.Course;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.Instructor;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.InstructorDetail;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.StudentUdemy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {

        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);


    }

    @Override
    @Transactional
    public void deleteById(int id) {

        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();
        for (Course c : courses) {
            c.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void DeleteByInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);// breaking the by directional relation in case we dont want to delete Instructor
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCourseByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id =: data", Course.class
        );
        query.setParameter("data", id);
        List<Course> courses = query.getResultList();
        return courses;
    }

    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        " join fetch i.courses " +
                        " join fetch i.instructorDetail " +
                        " where i.id = :data", Instructor.class
        );
        query.setParameter("data", id);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {

        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseByID(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        System.out.println(course);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
       TypedQuery<Course> typedQuery = entityManager.createQuery(
"select c from Course c " +
        "join fetch c.reviewList " +
        "where c.id = :data", Course.class
       );
       typedQuery.setParameter("data", id);
       Course course =  typedQuery.getSingleResult();
       return  course;

    }

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> typedQuery = entityManager.createQuery(
                "select c from Course c " +
                        "join fetch c.students " +
                        "where c.id = :data", Course.class
        );
        typedQuery.setParameter("data", id);
        Course course =  typedQuery.getSingleResult();
        return  course;

    }

    @Override
    public StudentUdemy findStudentAndCourseByStudentId(int id) {
        TypedQuery<StudentUdemy> typedQuery = entityManager.createQuery(
                "select c from StudentUdemy c " +
                        "join fetch c.courses " +
                        "where c.id = :data", StudentUdemy.class
        );
        typedQuery.setParameter("data", id);
        StudentUdemy studentUdemy =  typedQuery.getSingleResult();
        return studentUdemy;
    }

    @Override
    @Transactional
    public void deleteCourseWithoutStudent(int id) {
        //its same as delete course
        Course course = entityManager.find(Course.class, id);
        System.out.println(course);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void deleteStudentWithoutCourse(int id) {

        StudentUdemy studentUdemy = entityManager.find(StudentUdemy.class, id);
        entityManager.remove(studentUdemy);
    }
}
