package com.comp586.bonfilms.models;

import java.sql.Date;

import lombok.Data;

@Data
public class FilmReview {

    private int id;
    private int rating;
    private String review;
    private String userReviewedId;
    private String title;
    private Date dateReviewed;

    public FilmReview(int id, int rating, String review, String userReviewedId, String title, Date dateReviewed) {
        this.id = id;
        this.rating = rating;
        this.review = review;
        this.userReviewedId = userReviewedId;
        this.title = title;
        this.dateReviewed = dateReviewed;
    }

}
