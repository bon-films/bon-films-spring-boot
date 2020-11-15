package com.comp586.bonfilms.impls;

import com.comp586.bonfilms.entities.Review;
import com.comp586.bonfilms.services.ReviewService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service("reviewServiceImpl")
public class ReviewServiceImpl implements ReviewService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Review> getAllReviews() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Review> criteria = builder.createQuery(Review.class);
        Root<Review> root = criteria.from(Review.class);
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Transactional
    public Review getReview(int id) {
        return entityManager.find(Review.class, id);
    }

    @Transactional
    public Review saveReview(Review review) {
        entityManager.persist(review);
        return review;
    }

    @Transactional
    public Review updateReview(Review review) {
        entityManager.merge(review);
        return review;
    }

    @Transactional
    public Review deleteReview(Review review) {
        if (entityManager.contains(review)) {
            entityManager.remove(review);
        } else {
            entityManager.remove(entityManager.merge(review));
        }
        return null;
    }

}
