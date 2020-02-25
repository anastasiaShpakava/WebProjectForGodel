package com.godel.test.command;

import javax.servlet.http.HttpServletRequest;
/**
 * Интерфейс Command определяет одно действие execute(), реализации интерфейса
 * определяют в имплементированном методе бизнес-логику выполнения соответствующей команды.
 *
 * @author Shpakova A.
 */


public interface Command {

    void execute(HttpServletRequest request);
}
