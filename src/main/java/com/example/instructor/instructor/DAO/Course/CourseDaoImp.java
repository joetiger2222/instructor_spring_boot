package com.example.instructor.instructor.DAO.Course;

import com.example.instructor.instructor.DTOs.GetAllCoursesDto;
import com.example.instructor.instructor.Entities.Course;
import com.example.instructor.instructor.Entities.Review;
import jakarta.persistence.EntityManager;
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
        entityManager.merge(course);
        return course;
    }

    @Override
    public List<GetAllCoursesDto> getAll() {
        List<Course>courses= entityManager.createQuery("from Course",Course.class).getResultList();
        List<GetAllCoursesDto>courseDtos=courses.stream().map(c->new GetAllCoursesDto(c.getName(),c.getId(),c.getReviews())).toList();
        return courseDtos;
    }

    @Override
    public List<GetAllCoursesDto> getCoursesByInstructorId(int id) {
        List<Course> courses= entityManager.createQuery("from Course c where c.instructor.id = :id").setParameter("id",id).getResultList();
        List<Review>reviwes=null;
        List<GetAllCoursesDto>coursesDtos=courses.stream().map(c->new GetAllCoursesDto(c.getName(),c.getId(),reviwes)).toList();
        return coursesDtos;
    }

    @Override
    public Course getCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteCourse(int id) {
        Course course=entityManager.find(Course.class,id);
        if(course!=null){
            entityManager.remove(course);
        }
    }


}
