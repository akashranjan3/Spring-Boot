package mysql.practice.demo.Udemy.third.exceptionHandling;

import jakarta.annotation.PostConstruct;
import mysql.practice.demo.Udemy.third.exceptionHandling.entity.Student2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Student2RestController {

    private  List<Student2> theStudent;

    @PostConstruct
    public  void loadData(){
        theStudent = new ArrayList<>();
        theStudent.add(new Student2("vine-edt", "hut"));
        theStudent.add(new Student2("nam", "menu"));
        theStudent.add(new Student2("lal", "nag"));
    }


    @GetMapping("/students2")
    public List<Student2> getStudents(){

        return  theStudent;
    }

    @GetMapping("/students2/{studentId}")
    public Student2 getStudentsById(@PathVariable int studentId){

        if(studentId>=theStudent.size()){
            throw  new StudentNotFoundException("STudent not found - "+ studentId);
        }
        return  theStudent.get(studentId);
    }



}
