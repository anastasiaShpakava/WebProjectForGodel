package com.godel.test.command;

import com.godel.test.service.impl.DirectorServiceImpl;
import com.godel.test.service.impl.FilmServiceImpl;

/**
 * Список возможных команд
 *
 * @author Shpakova A.
 */

public enum CommandType {

    SHOW_ALL_FILMS(new ShowAllFilmsCommand(new FilmServiceImpl())),
    SHOW_ALL_DIRECTOR(new ShowAllDirectorCommand(new DirectorServiceImpl())),
    FIND_DIRECTOR_BY_ID(new FindDirectorByIdCommand()),
    FIND_FILM_BY_DATE(new FindFilmByDateCommand()),
    FIND_FILM_BY_DIRECTOR_ID(new FindFilmByDirectorIdCommand());

    CommandType(Command command) {
        this.command = command;
    }

    Command command;

    public Command getCurrentCommand() {
        return command;
    }
}