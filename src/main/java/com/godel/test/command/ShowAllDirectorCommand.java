package com.godel.test.command;

import com.godel.test.entity.Director;
import com.godel.test.exception.ServiceException;
import com.godel.test.service.impl.DirectorServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
/**
 * Этот класс используется для показа всех режиссеров
 *
 * @author Shpakova A.
 */


public class ShowAllDirectorCommand implements Command {
    private static final String STATUS_CODE = "statusCode";
    private DirectorServiceImpl directorService;

    public ShowAllDirectorCommand(DirectorServiceImpl directorService) {
        this.directorService = directorService;
    }

    @Override
    public void execute(HttpServletRequest request) {
        List<Director> directors = new ArrayList<>();
        try {
            directors = directorService.takeAllDirectors();
        } catch (ServiceException e) {
            request.setAttribute("error", "Error  data");
            request.setAttribute(STATUS_CODE, 404);
//            return PathForJsp.ERROR.getPath();
        }
        if (!directors.isEmpty()) {
            request.setAttribute("directors", directors);

        }
    }
}