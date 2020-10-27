package com.comp586.bonfilms.controllers;

import com.comp586.bonfilms.dao.FilmDetailRepository;
import com.comp586.bonfilms.models.FilmDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class FilmDetailController {
    @Autowired
    private FilmDetailRepository filmDetailRepository;

    // @GetMapping("/film-details")
    // public ResponseEntity<FilmDetails> getAllFilmDetails() { }

    @GetMapping("/film-detail/{id}")
    public ResponseEntity<FilmDetail> getFilmDetailById(@PathVariable("id") int id) {
        Optional<FilmDetail> filmDetailData = filmDetailRepository.findById(id);
        if (filmDetailData.isPresent()) {
            return new ResponseEntity<FilmDetail>(filmDetailData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<FilmDetail>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/film-detail/create")
    public ResponseEntity<FilmDetail> createFilmDetail(@RequestBody Map<String, String> body) throws Exception {
        FilmDetail filmDetail = new FilmDetail(body.get("filmName"), body.get("genre"), body.get("studio"),
                body.get("director"), body.get("topBilling"), body.get("synopsis"));
        return new ResponseEntity<FilmDetail>(filmDetailRepository.save(filmDetail), HttpStatus.CREATED);
    }

}
