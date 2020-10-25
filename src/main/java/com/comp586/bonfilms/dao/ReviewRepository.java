package com.comp586.bonfilms.dao;

import java.util.List;

import com.comp586.bonfilms.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByFilmDetail(int id);
}
