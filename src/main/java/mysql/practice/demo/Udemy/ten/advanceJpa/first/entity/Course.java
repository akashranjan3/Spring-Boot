package mysql.practice.demo.Udemy.ten.advanceJpa.first.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "title")
    private String title;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviewList;

    public Course() {
    }

    @ManyToMany(fetch = FetchType.LAZY,
            cascade =
                    {CascadeType.PERSIST, CascadeType.DETACH,
                            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentUdemy> students;


    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public  void addReview( Review review){
        if(reviewList==null){
            reviewList = new ArrayList<>();
        }
        reviewList.add(review);
    }

    public List<StudentUdemy> getStudents() {
        return students;
    }

    public void setStudents(List<StudentUdemy> students) {
        this.students = students;
    }

//    adding a convenience method to add a student in a course

    public  void  addStudent(StudentUdemy studentUdemy){
        if(students==null){
            students = new ArrayList<>();
        }
        students.add(studentUdemy);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
