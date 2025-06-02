package com.example.instructor.instructor.DAO;

import com.example.instructor.instructor.Entities.Instructor;
import com.example.instructor.instructor.Entities.InstructorDetails;

import java.util.List;

public interface IInstructorDao {
    Instructor save(Instructor instructor);
    Instructor getById(int id);
    List<Instructor> getAll();
    void delete(int id);
    InstructorDetails findInstructorDetailsByInstructorId(int instructorId);
}
