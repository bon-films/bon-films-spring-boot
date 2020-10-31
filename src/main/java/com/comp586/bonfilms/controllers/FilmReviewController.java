package com.comp586.bonfilms.controllers;

import java.util.ArrayList;
import java.util.List;

import com.comp586.bonfilms.models.FilmReview;
import com.comp586.bonfilms.repositories.FilmRepository;
import com.comp586.bonfilms.repositories.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class FilmReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/reviews")
    public ResponseEntity<List<FilmReview>> getAllReviews() {
        List<FilmReview> filmReviews = new ArrayList<>();
        reviewRepository.findAll().forEach(review -> {
            int id = review.getFilm().getId();
            String title = filmRepository.findById(id).get().getTitle();
            filmReviews.add(new FilmReview(review.getRating(), review.getReview(), review.getUserReviewedId(), title,
                    review.getDateReviewed()));
        });
        return new ResponseEntity<List<FilmReview>>(filmReviews, HttpStatus.ACCEPTED);
    }
}
