package com.comp586.bonfilms.services;

import java.util.List;

import com.comp586.bonfilms.entities.Review;

import org.springframework.stereotype.Component;

@Component
public interface ReviewService {

    public List<Review> getAllReviews();

    public Review getReview(int id);

    public Review saveReview(Review review);

    public Review updateReview(Review review);

    public Review deleteReview(Review review);

}
