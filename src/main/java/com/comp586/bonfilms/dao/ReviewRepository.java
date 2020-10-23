package com.comp586.bonfilms.dao;

import com.comp586.bonfilms.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
