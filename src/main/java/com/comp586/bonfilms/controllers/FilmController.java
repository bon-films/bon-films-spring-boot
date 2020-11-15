package com.comp586.bonfilms.controllers;

import com.comp586.bonfilms.entities.Film;
import com.comp586.bonfilms.entities.Review;
import com.comp586.bonfilms.services.FilmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @GetMapping("/films")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable("id") int id) {
        Film filmData = filmService.getFilm(id);
        if (filmData != null) {
            return new ResponseEntity<Film>(filmData, HttpStatus.OK);
        } else {
            return new ResponseEntity<Film>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/film/create")
    public ResponseEntity<Film> createFilm(@RequestBody Film film) throws Exception {
        return new ResponseEntity<Film>(filmService.saveFilm(film), HttpStatus.CREATED);
    }

    @GetMapping("/film/{id}/reviews")
    public ResponseEntity<List<Review>> getReviewsByFilmId(@PathVariable("id") int id) {
        Film filmData = filmService.getFilm(id);
        if (filmData != null) {
            List<Review> reviews = filmData.getReviews();
            return new ResponseEntity<List<Review>>(reviews, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
        }
    }

}
