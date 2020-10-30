package com.comp586.bonfilms.repositories;

import com.comp586.bonfilms.models.FilmDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(path = "film-details")
@Repository
public interface FilmDetailRepository extends JpaRepository<FilmDetail, Integer> {
}
