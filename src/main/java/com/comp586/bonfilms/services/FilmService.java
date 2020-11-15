package com.comp586.bonfilms.services;

import com.comp586.bonfilms.entities.Film;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FilmService {

    List<Film> getAllFilms();

    Film getFilm(int id);

    Film saveFilm(Film film);

}
