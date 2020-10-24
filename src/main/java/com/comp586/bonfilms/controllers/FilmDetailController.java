package com.comp586.bonfilms.controllers;

import com.comp586.bonfilms.dao.FilmDetailRepository;
import com.comp586.bonfilms.models.FilmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class FilmDetailController {
    @Autowired
    private FilmDetailRepository filmDetailRepository;

    @PostMapping("/films")
    public ResponseEntity<FilmDetail> createReview(@RequestBody Map<String, String> body) throws Exception {
        FilmDetail filmDetail = new FilmDetail(body.get("filmName"), body.get("genre"), body.get("studio"),
                body.get("director"), body.get("topBilling"), body.get("synopsis"));
        return new ResponseEntity<FilmDetail>(filmDetailRepository.save(filmDetail), HttpStatus.CREATED);
    }

}
