package com.godel.test.service.impl;

import com.godel.test.dao.DirectorDao;
import com.godel.test.dao.impl.DirectorDaoImpl;
import com.godel.test.entity.Director;
import com.godel.test.exception.ConnectionPoolException;
import com.godel.test.exception.DaoException;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.DirectorService;

import java.util.List;

/**
 * Класс, реализующий DirectorService
 *
 * @author Shpakova A.
 */

public class DirectorServiceImpl implements DirectorService {
    private DirectorDao directorDao;
    public DirectorServiceImpl() {
        directorDao = new DirectorDaoImpl();
    }

    @Override
    public List<Director> takeAllDirectors() throws ServiceException {
        return directorDao.takeAllDirectors();
}

    @Override
    public Director findById(Integer id) throws ServiceException, DaoException {
        return directorDao.findById(id);
    }

}
