package com.example.instructor.instructor.DAO;

import com.example.instructor.instructor.Entities.Course;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CourseDaoImp implements ICourseDao{

    private EntityManager entityManager;

    public CourseDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }
}
