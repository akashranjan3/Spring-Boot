package mysql.practice.demo.Udemy.second.hybernateJpa;


import mysql.practice.demo.Udemy.second.hybernateJpa.dao.StudentsDAO;
import mysql.practice.demo.Udemy.second.hybernateJpa.entity.Students;
import mysql.practice.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    private StudentsDAO studentsDAO;


    @GetMapping("/studentsave")
    public void saveStudent() {
        Students students = new Students("vijay", "ji ", "ji@gmail.com");
        studentsDAO.save(students);
    }

    @GetMapping("/studentget")
    public String getStudent() {
        return studentsDAO.findById(1).toString();
    }


    @GetMapping("/studentall")
    public List<Students> allStudent() {
        return studentsDAO.findAll();
    }

    @GetMapping("/student_all_orderby")
    public List<Students> allStudentOrderBy() {
        return studentsDAO.findAllOrderBy();
    }

    @GetMapping("/student_by_lastname")
    public List<Students> findByLastName() {
        return studentsDAO.findByLastName("kohli");
    }

 @GetMapping("/update")
    public Students upadte() {
        Students students = studentsDAO.findById(2);
        students.setLastName("sita");
        studentsDAO.upadate(students);

        return  studentsDAO.findById(2);
    }

 @GetMapping("/delete")
    public int delete() {
        Students students = studentsDAO.findById(3);
//        students.setLastName("sita");
        studentsDAO.delete(students);

        return  1;
    }

    @GetMapping("/delete_by_lastname")
    public int deleteByLastName() {
       return studentsDAO.deleteAllByLastName("raah");
    }


}
