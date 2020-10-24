package com.comp586.bonfilms.controllers;

import com.comp586.bonfilms.dao.ReviewRepository;
import com.comp586.bonfilms.models.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/create-review")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> body) throws Exception {
        Review review = new Review(body.get("filmName"), body.get("rating"), body.get("review"),
                body.get("userReviewedId"), body.get("filmDetail"));
        return new ResponseEntity<Review>(reviewRepository.save(review), HttpStatus.CREATED);
    }
}
