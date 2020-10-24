package com.comp586.bonfilms.dao;

import com.comp586.bonfilms.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
