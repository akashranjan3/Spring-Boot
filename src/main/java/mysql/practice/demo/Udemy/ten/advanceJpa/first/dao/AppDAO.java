package mysql.practice.demo.Udemy.ten.advanceJpa.first.dao;

import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.Course;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.Instructor;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.InstructorDetail;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.StudentUdemy;

import java.util.List;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(int id );
    void deleteById(int id);

    InstructorDetail findInstructorDetailsById(int id );

    void DeleteByInstructorDetailById(int id);
    List<Course> findCourseByInstructorId(int id);
   Instructor findInstructorByIdJoinFetch(int id);
   void updateInstructor(Instructor instructor);
   void updateCourse(Course course);

   Course findCourseByID(int id);

   void deleteCourseById(int id);

   void save(Course course);
   Course findCourseAndReviewByCourseId(int id);
   Course findCourseAndStudentByCourseId(int id);

   StudentUdemy findStudentAndCourseByStudentId(int id);
   void deleteCourseWithoutStudent(int id);
   void deleteStudentWithoutCourse(int id);
}
