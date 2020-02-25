package com.godel.test.command;
/**
 * путь к jsp файлам
 *
 * @author Shpakova A.
 */

public enum PathForJsp {
    ERROR("/jsp/error.jsp");
    private String path;

    PathForJsp(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
