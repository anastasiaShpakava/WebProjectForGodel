package com.godel.test.dao;

import com.godel.test.entity.Director;

import java.util.List;

/**
 * Класс представляет собой слой для взаимодействия с базой данных Director
 *
 * @author Shpakova A.
 */


public interface DirectorDao extends BaseDao <Integer, Director> {
    List<Director> takeAllDirectors();

}
