package com.example.instructor.instructor.DAO;

import com.example.instructor.instructor.Entities.Course;
import com.example.instructor.instructor.Entities.Instructor;
import com.example.instructor.instructor.Entities.InstructorDetails;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstructorDaoImp implements IInstructorDao {
    private EntityManager entityManager;

    @Autowired
    public InstructorDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        if (instructor.getCourses() != null) {
            // Use the helper method to maintain bidirectional relationship
            List<Course> originalCourses = new ArrayList<>(instructor.getCourses());
            instructor.getCourses().clear(); // clear to avoid duplicate adding
            for (Course course : originalCourses) {
                instructor.add(course); // this sets both sides
            }
        }

        entityManager.persist(instructor);
        return instructor;
    }


    @Override
    public Instructor getById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    public List<Instructor> getAll() {
        return entityManager.createQuery("from Instructor",Instructor.class).getResultList();
    }

    @Override
    @Transactional
    public void delete(int id) {
        Instructor delete=entityManager.find(Instructor.class,id);
        entityManager.remove(delete);
    }

    @Override
    public InstructorDetails findInstructorDetailsByInstructorId(int instructorId) {
        return entityManager.find(InstructorDetails.class,instructorId);
    }


}
