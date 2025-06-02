package com.example.instructor.instructor.Controllers;


import com.example.instructor.instructor.DAO.InstructorDaoImp;
import com.example.instructor.instructor.Entities.Instructor;
import com.example.instructor.instructor.Entities.InstructorDetails;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private InstructorDaoImp instructorDaoImp;

    public InstructorController(InstructorDaoImp instructorDaoImp) {
        this.instructorDaoImp = instructorDaoImp;
    }


    @PostMapping
    Instructor createInstructor(@RequestBody Instructor instructor){
        return this.instructorDaoImp.save(instructor);
    }

    @GetMapping
    public Instructor getById(@Param("id")int id){
        return instructorDaoImp.getById(id);
    }

    @GetMapping("/all")
    public List<Instructor> getAll(){
        return instructorDaoImp.getAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        instructorDaoImp.delete(id);
        return "Instructor deleted successfully";
    }

    @GetMapping("/details")
    public InstructorDetails getInstructorDetailsByInstructorId(@Param("detailsId")int detailsId){
        return instructorDaoImp.findInstructorDetailsByInstructorId(detailsId);
    }



}
