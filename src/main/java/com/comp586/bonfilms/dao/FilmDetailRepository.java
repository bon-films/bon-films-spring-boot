package com.comp586.bonfilms.dao;

import com.comp586.bonfilms.models.FilmDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(path = "film-details")
public interface FilmDetailRepository extends JpaRepository<FilmDetail, Integer> {
}
