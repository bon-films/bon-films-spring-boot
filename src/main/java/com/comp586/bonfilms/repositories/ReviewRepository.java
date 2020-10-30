package com.comp586.bonfilms.repositories;

import com.comp586.bonfilms.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
