package com.comp586.bonfilms.services;

import java.util.List;

import com.comp586.bonfilms.entities.Film;

import org.springframework.stereotype.Component;

@Component
public interface FilmService {

    public List<Film> getAllFilms();

    public Film getFilm(int id);

    public Film saveFilm(Film film);

}
