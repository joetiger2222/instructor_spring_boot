package com.example.instructor.instructor.DAO.Course;

import com.example.instructor.instructor.DTOs.GetAllCoursesDto;
import com.example.instructor.instructor.Entities.Course;

import java.util.List;

public interface ICourseDao {
    Course save(Course course);
    List<GetAllCoursesDto> getAll();
    List<GetAllCoursesDto> getCoursesByInstructorId(int id);
    Course getCourseById(int id);
    void deleteCourse(int id);
}
