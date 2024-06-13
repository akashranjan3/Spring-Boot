package mysql.practice.demo.Udemy.ten.advanceJpa.first.controller;

import mysql.practice.demo.Udemy.ten.advanceJpa.first.dao.AppDAO;
import mysql.practice.demo.Udemy.ten.advanceJpa.first.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/big")
public class Big {

    @Autowired
    private AppDAO appDAO;

    public Big(AppDAO appDAO) {
        this.appDAO = appDAO;
    }

    @GetMapping("/create")
    public String createInstructor() {
        Instructor instructor = new Instructor("hin", "l", "mj@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube.com/ttt", "tenis");
        instructor.setInstructorDetail(instructorDetail);

        System.out.println("my dear instructor --> " + instructor);
        appDAO.save(instructor);
        return "created";
    }

    @GetMapping("find")
    public String findById() {
        return appDAO.findInstructorById(1).toString() + ".....details->" + appDAO.findInstructorById(1).getInstructorDetail().toString();
    }

    @GetMapping("/find_by_details")
    public String findByInstructorDetailId() {
        return "instructor detail -> " + appDAO.findInstructorDetailsById(2).toString() + ".....details->" + appDAO.findInstructorDetailsById(2).getInstructor().toString();
    }

    @GetMapping("delete")
    public String deleteById() {
        appDAO.deleteById(1);
        return "deleted";
    }

    @GetMapping("/delete_by_instructor_detail")
    public String deleteByInstructorDetailId() {
        appDAO.DeleteByInstructorDetailById(5);
        return "deleted";
    }

    @GetMapping("/create_course_with_instructor")
    public String createCourseWithInstructor() {

        Instructor instructor = new Instructor("ram", "rahim", "ram_rahim@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("youtube.com/ram", "Ludo");

        instructor.setInstructorDetail(instructorDetail);
        Course course = new Course("the ultimate Java course");
        Course course2 = new Course("the ultimate Python course");
        instructor.add(course);
        instructor.add(course2);
        appDAO.save(instructor);
        return instructor.toString() + "\n course detail -> " + instructor.getCourses().toString();
    }


    @GetMapping("/find_instructor_with_courses")
    public String findInstructorWithCourse() {
        int instructorId = 6;
        Instructor instructor = appDAO.findInstructorById(instructorId);
        return instructor + "\n course detail -> " + instructor.getCourses();
    }

    @GetMapping("/find_course_from_instructor")
    public String findCourseFromInstructor() {
        int instructorId = 6;
        Instructor instructor = appDAO.findInstructorById(instructorId);
        List<Course> courseList = appDAO.findCourseByInstructorId(instructorId);


        return "\n Instructor -> " + instructor + "\n course detail -> " + courseList;
    }

    @GetMapping("/find_instructor_by_id_join_fetch")
    public String findInstructorByIdJoinFetch() {
        int instructorId = 6;
        Instructor instructor = appDAO.findInstructorByIdJoinFetch(instructorId);


        return "hello bro, I am using join fetch=> " + "\n Instructor -> " + instructor + "\n course detail -> " + instructor.getCourses();
    }

    @GetMapping("/update_instructor")
    public String updateInstructor() {
        int instructorId = 6;
        Instructor instructor = appDAO.findInstructorById(instructorId);
        instructor.setLastName("Rana ji");
        appDAO.updateInstructor(instructor);
        return "Updated";
    }

    @GetMapping("/update_course")
    public String updateCourse() {
        int courseId = 10;
        Course course = appDAO.findCourseByID(courseId);
        course.setTitle("Python for pro ");
        appDAO.updateCourse(course);
        return "Updated course";
    }

    @GetMapping("/delete_instructor_without_deleting_courses")
    public String deleteInstructor() {
        int instructorId = 7;
        appDAO.deleteById(instructorId);
        return "deleted";
    }

    @GetMapping("/delete_course_by_id")
    public String deleteCourseById() {
        appDAO.deleteCourseById(17);
        return "deleted course";
    }

    @GetMapping("/create_course_and_review")
    public String createCourseAndReview() {

        Course course = new Course("my Ruby course");
        course.addReview(new Review("good Course"));
        course.addReview(new Review("cool"));
        course.addReview(new Review("bad"));
        course.addReview(new Review("Awesome"));
        course.addReview(new Review("get lost!!!"));

        appDAO.save(course);
        return "course => " + course + "review=> " + course.getReviewList();
    }


    @GetMapping("/get_course_and_review")
    public String getCourseAndReview() {

        Course course = appDAO.findCourseAndReviewByCourseId(21);
        return "course => " + course + "review=> " + course.getReviewList();
    }

    @GetMapping("/delete_course_and_reviews")
    public String deleteCourseAndReviews() {

        appDAO.deleteCourseById(21);
        return "Course deleted ";
    }

    @GetMapping("/create_course_and_student")
    public String createCourseAndStudent() {

        Course course = new Course("hindi");
        StudentUdemy studentUdemy = new StudentUdemy("st1", "st_1", "st1@gmail.com");
        StudentUdemy studentUdemy2 = new StudentUdemy("st2", "st_2", "st2@gmail.com");
        course.addStudent(studentUdemy);
        course.addStudent(studentUdemy2);
        appDAO.save(course);


        return "Course and student created  => "+ course+ " student details=> "+course.getStudents();
    }
  @GetMapping("/find_course_with_student")
    public String findCourseAndStudent() {

       Course course = appDAO.findCourseAndStudentByCourseId(22);

        return "Course   => "+ course+ " student details=> "+course.getStudents();
    }

@GetMapping("/find_student_with_course")
    public String findStudentAndCourse() {

       StudentUdemy studentUdemy = appDAO.findStudentAndCourseByStudentId(2);

        return "studentUdemy   => "+ studentUdemy+ " course details=> "+studentUdemy.getCourses();
    }

@GetMapping("/delete_course_without_student")
    public String deleteCourseWithoutStudent() {

      appDAO.deleteCourseWithoutStudent(23);

        return "deleted";
    }
@GetMapping("/delete_student_without_course")
    public String deleteStudentWithoutCourse() {

      appDAO.deleteStudentWithoutCourse(2);

        return "deleted";
    }


}
