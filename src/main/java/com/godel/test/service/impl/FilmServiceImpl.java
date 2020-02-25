package com.godel.test.service.impl;

import com.godel.test.dao.DirectorDao;
import com.godel.test.dao.FilmDao;
import com.godel.test.dao.impl.DirectorDaoImpl;
import com.godel.test.dao.impl.FilmDaoImpl;
import com.godel.test.entity.Film;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.FilmService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс, реализующий FilmService
 *
 * @author Shpakova A.
 */

public class FilmServiceImpl implements FilmService {
    private FilmDao filmDao;
    public FilmServiceImpl(FilmDaoImpl filmDao) {
       this.filmDao = new FilmDaoImpl();
    }

    public FilmServiceImpl() {

    }

    @Override
    public List<Film> findFilmByDirectorId(int directorId) throws ServiceException {
        return filmDao.findFilmByDirectorId(directorId);
    }

    @Override
    public List<Film> findFilmByDate(LocalDateTime date) throws ServiceException {
       return filmDao.findFilmByDate(date);
    }

    @Override
    public List<Film> takeAllFilms() throws ServiceException {
        return filmDao.takeAllFilms();
    }
}
