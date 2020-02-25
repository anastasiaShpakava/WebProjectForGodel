package com.godel.test.service;

import com.godel.test.entity.Director;
import com.godel.test.exception.DaoException;
import com.godel.test.exception.ServiceException;

import java.util.List;

/**
 * Слой для взаимдействия  с DirectorDao
 *
 * @author Shpakova A.
 */

public interface DirectorService {
    List<Director> takeAllDirectors() throws ServiceException;
    Director findById(Integer id) throws ServiceException, DaoException;
}
