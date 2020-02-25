package com.godel.test.service;

import com.godel.test.entity.Film;
import com.godel.test.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Слой для взаимдействия  с FilmDao
 *
 * @author Shpakova A.
 */

public interface FilmService {
    List<Film> findFilmByDirectorId(int directorId) throws ServiceException;
    List<Film> findFilmByDate(LocalDateTime date)throws ServiceException;
    List<Film> takeAllFilms() throws ServiceException;
}
