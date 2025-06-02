package com.example.instructor.instructor.DAO;

import com.example.instructor.instructor.Entities.Course;

import java.util.List;

public interface ICourseDao {
    Course save(Course course);
    List<Course> getAll();
}
