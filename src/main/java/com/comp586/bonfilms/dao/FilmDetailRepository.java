package com.comp586.bonfilms.dao;

import com.comp586.bonfilms.entity.FilmDetail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "filmDetail", path = "film-detail")
public interface FilmDetailRepository extends JpaRepository<FilmDetail, Long> {
}
