package com.comp586.bonfilms.controllers;

import java.util.Map;

import com.comp586.bonfilms.entities.Review;
import com.comp586.bonfilms.services.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") int id) {
        Review reviewData = reviewService.getReview(id);
        if (reviewData != null) {
            return new ResponseEntity<Review>(reviewData, HttpStatus.OK);
        } else {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/review/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) throws Exception {
        return new ResponseEntity<Review>(reviewService.saveReview(review), HttpStatus.CREATED);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") int id, @RequestBody Map<String, String> body) {
        Review reviewData = reviewService.getReview(id);
        if (reviewData != null) {
            reviewData.setRating(Integer.parseInt(body.get("rating")));
            reviewData.setReview(body.get("review"));
            return new ResponseEntity<Review>(reviewService.updateReview(reviewData), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable("id") int id) {
        Review reviewData = reviewService.getReview(id);
        if (reviewData != null) {
            return new ResponseEntity<Review>(reviewService.deleteReview(reviewData), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

}
