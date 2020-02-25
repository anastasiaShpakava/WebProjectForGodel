package com.godel.test.service.impl;

import com.godel.test.connetion.ConnectionPool;
import com.godel.test.entity.Director;
import com.godel.test.exception.DaoException;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.DirectorService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class DirectorServiceImplTest {

    @DataProvider
    public Object[][]  testFindById() { //expected [Kate] but found [Tarantino]
        return new Object[][]{
                {1, "Kate"},
        };
    }

    @Test(dataProvider = "testFindById")
    public void testServiceFindEventById(int id, String name) throws ServiceException, DaoException {
        ConnectionPool connectionPool= ConnectionPool.INSTANCE;
      DirectorService directorService=new DirectorServiceImpl();
      Director director=directorService.findById(id);
      Assert.assertEquals(director.getLastName(), name);
    }
}