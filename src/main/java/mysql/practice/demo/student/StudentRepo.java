package mysql.practice.demo.student;


import mysql.practice.demo.student.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
