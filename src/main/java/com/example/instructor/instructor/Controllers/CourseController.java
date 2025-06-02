package com.example.instructor.instructor.Controllers;

import com.example.instructor.instructor.DAO.CourseDaoImp;
import com.example.instructor.instructor.DAO.InstructorDaoImp;
import com.example.instructor.instructor.Entities.Course;
import com.example.instructor.instructor.Entities.Instructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseDaoImp courseDaoImp;
    private InstructorDaoImp instructorDaoImp;
    public CourseController(CourseDaoImp courseDaoImp,InstructorDaoImp instructorDaoImp) {
        this.courseDaoImp = courseDaoImp;
        this.instructorDaoImp=instructorDaoImp;
    }

    @PostMapping("/{instructorId}")
    public Course createCourse(@RequestBody Course course, @PathVariable int instructorId){
        Instructor instructor=instructorDaoImp.getById(instructorId);
        if(instructor==null){
            throw new RuntimeException("Instructor not found");
        }
        instructor.add(course);
        return courseDaoImp.save(course);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses(){
        return courseDaoImp.getAll();
    }
}
