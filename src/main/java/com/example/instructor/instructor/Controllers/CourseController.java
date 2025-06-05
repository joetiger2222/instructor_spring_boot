package com.example.instructor.instructor.Controllers;

import com.example.instructor.instructor.DAO.Course.CourseDaoImp;
import com.example.instructor.instructor.DAO.Instructor.InstructorDaoImp;
import com.example.instructor.instructor.DAO.Review.ReviewDaoImp;
import com.example.instructor.instructor.DTOs.GetAllCoursesDto;
import com.example.instructor.instructor.Entities.Course;
import com.example.instructor.instructor.Entities.Instructor;
import com.example.instructor.instructor.Entities.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private CourseDaoImp courseDaoImp;
    private InstructorDaoImp instructorDaoImp;
    private ReviewDaoImp reviewDaoImp;
    public CourseController(CourseDaoImp courseDaoImp,InstructorDaoImp instructorDaoImp,ReviewDaoImp reviewDaoImp) {
        this.courseDaoImp = courseDaoImp;
        this.instructorDaoImp=instructorDaoImp;
        this.reviewDaoImp=reviewDaoImp;
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
    public List<GetAllCoursesDto> getAllCourses(){
        return courseDaoImp.getAll();
    }

    @GetMapping("/{instructorId}")
    public List<GetAllCoursesDto>getCoursesByInstructorId(@PathVariable int instructorId){
        return courseDaoImp.getCoursesByInstructorId(instructorId);
    }

    @PostMapping("/review/{courseId}")
    public void addReviewToCourse(@PathVariable int courseId,@RequestBody Review review){
        Course course= courseDaoImp.getCourseById(courseId);
        if(course==null){
//            return new RuntimeException("Course not found");
        }
        course.add(review);
        courseDaoImp.save(course);

    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable int courseId){
        courseDaoImp.deleteCourse(courseId);
    }
}
