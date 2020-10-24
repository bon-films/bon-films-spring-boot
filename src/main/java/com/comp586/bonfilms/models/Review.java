package com.comp586.bonfilms.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "film_name")
    private String filmName;

    @Column(name = "rating")
    private int rating;

    @Column(name = "review")
    private String review;

    @Column(name = "user_reviewed_id")
    private String userReviewedId;

    // @ManyToOne
    // @JoinColumn(name = "film_detail_id", nullable = false)
    @Column(name = "film_detail_id")
    private int filmDetail;

    @Column(name = "date_reviewed")
    @CreationTimestamp
    private Date dateReviewed;

    public Review() {
        super();
    }

    public Review(String filmName, String rating, String review, String userReviewedId, String filmDetail) {
        this.filmName = filmName;
        this.rating = Integer.parseInt(rating);
        this.review = review;
        this.userReviewedId = userReviewedId;
        this.filmDetail = Integer.parseInt(filmDetail);
    }
}
