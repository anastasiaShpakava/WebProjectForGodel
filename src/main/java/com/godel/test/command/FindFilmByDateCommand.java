package com.godel.test.command;

import com.godel.test.entity.Film;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.impl.FilmServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Этот класс используется для поиска фильма по дате
 *
 * @author Shpakova A.
 */

public class FindFilmByDateCommand implements Command {
    private static final String STATUS_CODE = "statusCode";
    private FilmServiceImpl filmService;

    public FindFilmByDateCommand() {
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Film> films = new ArrayList<Film>();

        try {
            films = filmService.findFilmByDate(LocalDateTime.parse(request.getParameter("releaseDate")));
        } catch (ServiceException e) {
            request.setAttribute("exception", "Enter date of release of film");
        }
        if (films == null) {
            request.setAttribute("exception", "Film with such date is not exist");
            request.setAttribute(STATUS_CODE, 404);
        } else {

            request.setAttribute("films", films);
        }
    }
}
