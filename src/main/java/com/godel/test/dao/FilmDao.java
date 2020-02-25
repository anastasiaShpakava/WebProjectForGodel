package com.godel.test.dao;

import com.godel.test.entity.Director;
import com.godel.test.entity.Film;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс представляет собой слой для взаимодействия с базой данных Film
 *
 * @author Shpakova A.
 */
public interface FilmDao extends BaseDao<Integer, Film> {
    List<Film> findFilmByDirectorId(int directorId);
    List<Film> findFilmByDate(LocalDateTime date);
    List<Film> takeAllFilms();
}
