package com.comp586.bonfilms.services;

import com.comp586.bonfilms.entities.Review;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReviewService {

    List<Review> getAllReviews();

    Review getReview(int id);

    Review saveReview(Review review);

    Review updateReview(Review review);

    Review deleteReview(Review review);

}
