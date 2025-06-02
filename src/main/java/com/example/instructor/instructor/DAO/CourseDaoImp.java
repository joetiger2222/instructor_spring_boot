package com.example.instructor.instructor.DAO;

import com.example.instructor.instructor.Entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Course> getAll() {
        return entityManager.createQuery("from Course",Course.class).getResultList();
    }
}
