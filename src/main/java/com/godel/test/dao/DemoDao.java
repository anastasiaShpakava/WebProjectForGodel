package com.godel.test.dao;

import com.godel.test.dao.impl.DirectorDaoImpl;
import com.godel.test.dao.impl.FilmDaoImpl;
import com.godel.test.entity.Film;
import com.godel.test.exception.DaoException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DemoDao {
    public static void main(String[] args) throws DaoException {
        FilmDaoImpl filmDao=new FilmDaoImpl();
        System.out.println(filmDao.findFilmByDate(LocalDateTime.of(2016,12,01,0,0,0)));
//        System.out.println(filmDao.findById(3));
//        System.out.println(filmDao.findFilmByDirectorId(4));
        DirectorDaoImpl directorDao=new DirectorDaoImpl();
//        System.out.println(directorDao.takeAllDirectors());
//        System.out.println(directorDao.findById(3));
    }
}
