package com.example.instructor.instructor.DAO.Instructor;

import com.example.instructor.instructor.DTOs.GetAllInstructorsDto;
import com.example.instructor.instructor.Entities.Instructor;
import com.example.instructor.instructor.Entities.InstructorDetails;

import java.util.List;

public interface IInstructorDao {
    Instructor save(Instructor instructor);
    Instructor getById(int id);
    List<GetAllInstructorsDto> getAll();
    void delete(int id);
    InstructorDetails findInstructorDetailsByInstructorId(int instructorId);
}
