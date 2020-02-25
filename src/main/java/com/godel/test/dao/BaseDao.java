package com.godel.test.dao;

import com.godel.test.connetion.ConnectionPool;
import com.godel.test.connetion.ProxyConnection;
import com.godel.test.entity.Entity;
import com.godel.test.exception.ConnectionPoolException;
import com.godel.test.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Описание общих методов, которые будут использоваться при взаимодействии с бд
 *
 * @author Shpakova A.
 */
public interface BaseDao <K, T extends Entity> { //K-ключ
    Logger logger = LogManager.getLogger();

    T findById(K id) throws DaoException;


    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error ("Impossible to close object Statement", e);
        }
    }

    default void close(ProxyConnection proxyConnection) {
        if (proxyConnection != null) {
            try {
                proxyConnection.close();
            } catch (SQLException e) {      // генерация исключения, т.к. нарушается работа пула
                e.printStackTrace();
            }
        }
    }
}
