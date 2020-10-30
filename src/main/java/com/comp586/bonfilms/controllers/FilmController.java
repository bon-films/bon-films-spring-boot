package com.comp586.bonfilms.controllers;

import com.comp586.bonfilms.models.Film;
import com.comp586.bonfilms.models.Review;
import com.comp586.bonfilms.repositories.FilmRepository;

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

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    // @GetMapping("/film")
    // public ResponseEntity<Film> getAllFilms() { }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") int id) {
        Optional<Film> filmData = filmRepository.findById(id);
        if (filmData.isPresent()) {
            return new ResponseEntity<Film>(filmData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/film/create")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) throws Exception {
        return new ResponseEntity<Film>(filmRepository.save(film), HttpStatus.CREATED);
    }

    @GetMapping("/film/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByFilmId(@PathVariable("id") int id) {
        Optional<Film> filmData = filmRepository.findById(id);
        if (filmData.isPresent()) {
            List<Review> reviews = filmData.get().getReviews();
            return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
        }
    }

}
