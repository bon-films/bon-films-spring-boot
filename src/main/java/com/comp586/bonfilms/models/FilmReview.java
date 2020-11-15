package com.comp586.bonfilms.models;

import lombok.Data;

import java.sql.Date;

@Data
public class FilmReview {

    private final int id;
    private final int rating;
    private final String review;
    private final String userReviewedId;
    private final String title;
    private final Date dateReviewed;

    public FilmReview(int id, int rating, String review, String userReviewedId, String title, Date dateReviewed) {
        this.id = id;
        this.rating = rating;
        this.review = review;
        this.userReviewedId = userReviewedId;
        this.title = title;
        this.dateReviewed = dateReviewed;
    }

}
