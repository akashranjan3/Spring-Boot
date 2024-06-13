package mysql.practice.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentRepo student;

    @RequestMapping("/students")
    public List<Student> allStudent(){
        return (List<Student>) student.findAll();
    }

    @RequestMapping("/students/{id}")
    public Optional<Student> studentById(@PathVariable("id") int id){
        Optional<Student> student1 = student.findById(id);
        if(student1.isPresent()){

            return student.findById(id);
        }else{
            return Optional.of(new Student(200, "akash temp"));
        }
    }

    @PostMapping("/students")
    public void saveStudent(@RequestBody Student stu){
       student.save(stu);
    }


    @PutMapping("/students")
    public void updateStudent(@RequestBody Student stu){
       student.save(stu);
    }

    @DeleteMapping("/students")
    public void deleteStudent(@RequestBody Student stu){
       student.delete(stu);
    }
}
