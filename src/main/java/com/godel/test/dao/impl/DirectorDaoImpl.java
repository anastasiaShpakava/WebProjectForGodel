package com.godel.test.dao.impl;

import com.godel.test.connetion.ConnectionPool;
import com.godel.test.dao.DirectorDao;
import com.godel.test.entity.Director;
import com.godel.test.exception.DaoException;
/**
 * Класс реализует интерфейс DirectorDao
 *
 * @author Shpakova A.
 */

import javax.xml.registry.infomodel.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DirectorDaoImpl implements DirectorDao {
    private static final String SQL_TAKE_ALL_DIRECTOR = "SELECT director_id, first_name, last_name,birth_date FROM director";
    private static final String SQL_FIND_DIRECTOR_BY_ID = "SELECT director_id, first_name, last_name,birth_date FROM director WHERE director_id=?";

    @Override
    public List<Director> takeAllDirectors() {
        List<Director> directors = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;
        try {
        connection=ConnectionPool.INSTANCE.getConnection();
            statement = connection.createStatement();
           resultSet = statement.executeQuery(SQL_TAKE_ALL_DIRECTOR);
            while (resultSet.next()) {
                Director director = new Director();
                director.setDirectorId(resultSet.getInt(1));
                director.setFirstName(resultSet.getString(2));
                director.setLastName(resultSet.getString(3));
                director.setBirthDate(resultSet.getDate(4).toLocalDate());
                directors.add(director);

            }
        } catch (SQLException e) {
            logger.error("SQL exception (request or table failed): " + e);
        } finally {
            close(statement);

// код возвращения экземпляра Connection в пул
        }
        return directors;
    }


    @Override
    public Director findById(Integer id) throws DaoException {
        Director director = new Director();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
          connection=  ConnectionPool.INSTANCE.getConnection();
            preparedStatement = connection.prepareStatement(SQL_FIND_DIRECTOR_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            director.setDirectorId(id);
            director.setFirstName(resultSet.getString(2));
            director.setLastName(resultSet.getString(3));
            director.setBirthDate(resultSet.getDate(4).toLocalDate());

        } catch (SQLException e) {
            System.err.println("SQL exception (request or table failed): " + e);
        } finally {
            close(preparedStatement);
// код возвращения экземпляра Connection в пул
        }
        return director;
    }
}
