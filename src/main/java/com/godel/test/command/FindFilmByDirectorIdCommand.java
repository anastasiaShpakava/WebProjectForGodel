package com.godel.test.command;

import com.godel.test.entity.Film;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.impl.FilmServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Этот класс используется для поиска фильма по id директора
 *
 * @author Shpakova A.
 */

public class FindFilmByDirectorIdCommand implements Command {
    private static final String STATUS_CODE = "statusCode";
    private FilmServiceImpl filmService;
    public FindFilmByDirectorIdCommand() {
    }
    @Override
    public void execute(HttpServletRequest request) {
        List<Film> films=null;
        try {
            films = filmService.findFilmByDirectorId(Integer.parseInt(request.getParameter("directorId")));
        } catch (ServiceException e) {
            request.setAttribute("exception", "Enter id Director");
        }
        if (films == null) {
            request.setAttribute("exception", "Director with such id is not exist");
            request.setAttribute(STATUS_CODE, 404);
        } else {

            request.setAttribute("films", films);
        }
    }
}

