package com.comp586.bonfilms.impls;

import com.comp586.bonfilms.entities.Film;
import com.comp586.bonfilms.services.FilmService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Service("filmServiceImpl")
public class FilmServiceImpl implements FilmService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Film> getAllFilms() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Film> criteria = builder.createQuery(Film.class);
        Root<Film> root = criteria.from(Film.class);
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Transactional
    public Film getFilm(int id) {
        return entityManager.find(Film.class, id);
    }

    @Transactional
    public Film saveFilm(Film film) {
        entityManager.persist(film);
        return film;
    }
}
