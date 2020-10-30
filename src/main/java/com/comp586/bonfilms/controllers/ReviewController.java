package com.comp586.bonfilms.controllers;

import java.util.Map;
import java.util.Optional;

import com.comp586.bonfilms.models.Review;
import com.comp586.bonfilms.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // @GetMapping("/reviews")
    // public ResponseEntity<Review> getAllReviews() { }

    @GetMapping("/review/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") int id) {
        Optional<Review> reviewData = reviewRepository.findById(id);
        if (reviewData.isPresent()) {
            return new ResponseEntity<Review>(reviewData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/review/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) throws Exception {
        return new ResponseEntity<Review>(reviewRepository.save(review), HttpStatus.CREATED);
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable("id") int id, @RequestBody Map<String, String> body) {
        Optional<Review> reviewData = reviewRepository.findById(id);
        if (reviewData.isPresent()) {
            Review review = reviewData.get();
            review.setRating(Integer.parseInt(body.get("rating")));
            review.setReview(body.get("review"));
            return new ResponseEntity<Review>(reviewRepository.save(review), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/review/{id}")
    public ResponseEntity<Review> deleteReview(@PathVariable("id") int id) {
        Optional<Review> reviewData = reviewRepository.findById(id);
        if (reviewData.isPresent()) {
            Review review = reviewData.get();
            reviewRepository.delete(review);
            return new ResponseEntity<Review>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
        }
    }

}
