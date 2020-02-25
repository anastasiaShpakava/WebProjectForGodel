package com.godel.test.command;

import com.godel.test.entity.Director;
import com.godel.test.exception.DaoException;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class FindDirectorByIdCommand implements Command {
    private static final String STATUS_CODE = "statusCode";
    private DirectorServiceImpl directorService;

    @Override
    public void execute(HttpServletRequest request) {
        Director director = null;
        try {
            director = directorService.findById(Integer.parseInt(request.getParameter("directorId")));
        } catch (DaoException | ServiceException e) {
            request.setAttribute("exception", "Enter id Director");
            request.setAttribute(STATUS_CODE, 404);
        }
        if (director == null) {
            request.setAttribute("exception", "Director with such id is not exist");
        } else {

            request.setAttribute("director", director);
        }
    }
}

