package com.godel.test.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Класс получения объекта-команды
 *
 * @author Shpakova A.
 */

public class ActionFactory {

    private static final Logger logger = LogManager.getLogger();

    public static Command defineCommand(String action) {
       Command command = new EmptyCommand();
        if(action==null){
            return  command;
        }
        try {
            String act = action.toUpperCase();
           CommandType commandType= CommandType.valueOf(act);
            command = commandType.getCurrentCommand();
        }
        catch (IllegalArgumentException e){
            throw e;
        }
        return command;

    }



//    public static Optional<Command> defineCommand(String commandName) {
//        Optional<Command> current = Optional.empty();
//        if (commandName == null) {
//            return current;
//        }
//        try {
//            CommandType type = CommandType.valueOf(commandName.toUpperCase());
//            current = Optional.of(type.getCurrentCommand());
//        } catch (EnumConstantNotPresentException | IllegalArgumentException e) {
//            logger.error("Can't define command", e);
//        }
//        return current;
//    }
}