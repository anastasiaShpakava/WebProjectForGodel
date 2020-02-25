package com.godel.test.command;

import com.godel.test.entity.Film;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.impl.FilmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс используется для показа всех фильмов
 *
 * @author Shpakova A.
 */

public class ShowAllFilmsCommand implements Command {
    private static final String STATUS_CODE = "statusCode";
    private static final Logger logger = LogManager.getLogger();
    private FilmServiceImpl filmService;

    public ShowAllFilmsCommand (FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Film> films =new ArrayList<>();

        try {
            films=filmService.takeAllFilms();
        } catch (ServiceException e) {
            request.setAttribute("error", "Error  data");
            request.setAttribute(STATUS_CODE, 404);
//            return PathForJsp.ERROR.getPath();
        }
        if (!films.isEmpty()) {
            request.setAttribute("films", films);

        }
    }
}
