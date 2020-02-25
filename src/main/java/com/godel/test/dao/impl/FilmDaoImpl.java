package com.godel.test.dao.impl;

import com.godel.test.connetion.ConnectionPool;
import com.godel.test.dao.FilmDao;
import com.godel.test.entity.Director;
import com.godel.test.entity.Film;
import com.godel.test.exception.DaoException;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует интерфейс FilmDao
 *
 * @author Shpakova A.
 */

public class FilmDaoImpl implements FilmDao {
    private static final String SQL_FIND_FILM_BY_DIRECTOR_ID = "SELECT film_id, director_id, name, release_date,genre FROM film WHERE director_id=?";
    private static final String SQL_FIND_FILM_BY_DATE = "SELECT film_id, director_id, name, release_date, genre FROM film WHERE release_date=?";
    private static final String SQL_FIND_FILM_BY_ID = "SELECT film_id, director_id, name, release_date,genre FROM film WHERE film_id=?";
    private static final String SQL_TAKE_ALL_FILM = "SELECT film_id, director_id, name, release_date, genre FROM film";

    @Override
    public List<Film> findFilmByDirectorId(int directorId) {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_FILM_BY_DIRECTOR_ID);
            preparedStatement.setInt(1, directorId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                film.setFilmId(resultSet.getInt(1));
                film.setName(resultSet.getString(3));
                film.setReleaseDate(resultSet.getTimestamp(4).toLocalDateTime());
                film.setGenre(resultSet.getString(5));
                film.setDirectorId(directorId);
                films.add(film);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            close(preparedStatement);
// код возвращения экземпляра Connection в пул
        }
        return films;
    }


    @Override
    public List<Film> findFilmByDate(LocalDateTime date) {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_FILM_BY_DATE);
     preparedStatement.setTimestamp(1, Timestamp.valueOf(date));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Film film = new Film();
                film.setFilmId(resultSet.getInt(1));
                film.setDirectorId(resultSet.getInt(2));
                film.setName(resultSet.getString(3));
                film.setGenre(resultSet.getString(5));
                film.setReleaseDate(date);
                films.add(film);
            }
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            close(preparedStatement);
        }
        return films;
    }

    @Override
    public List<Film> takeAllFilms() {
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;
        try {
            connection=ConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_TAKE_ALL_FILM);
            while (resultSet.next()) {
             Film film=new Film();
             film.setFilmId(resultSet.getInt(1));
          film.setDirectorId(resultSet.getInt(2));
          film.setName(resultSet.getString(3));
          film.setReleaseDate(resultSet.getTimestamp(4).toLocalDateTime());
          film.setGenre(resultSet.getString(5));
               films.add(film);
            }
        } catch (SQLException e) {
            logger.error("SQL exception (request or table failed): " + e);
        } finally {
            close(statement);
        }
        return films;
    }

    @Override
    public Film findById(Integer id) throws DaoException {
        Film film = new Film();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_FILM_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            film.setFilmId(id);
            film.setDirectorId(resultSet.getInt(2));
            film.setName(resultSet.getString(3));
            film.setReleaseDate(resultSet.getTimestamp(4).toLocalDateTime());
            film.setGenre(resultSet.getString(5));
        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            close(preparedStatement);
// код возвращения экземпляра Connection в пул
        }
        return film;
    }
}

