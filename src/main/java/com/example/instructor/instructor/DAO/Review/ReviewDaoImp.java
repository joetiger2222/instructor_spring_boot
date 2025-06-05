package com.example.instructor.instructor.DAO.Review;

import com.example.instructor.instructor.Entities.Review;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReviewDaoImp implements IReview{

    private EntityManager entityManager;

    public ReviewDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void add(Review review) {
        entityManager.merge(review);
    }
}
