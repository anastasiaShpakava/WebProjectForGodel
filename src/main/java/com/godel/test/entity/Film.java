package com.godel.test.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Класс-сущность для  Director
 *
 * @author Shpakova A.
 */
public class Film extends Entity {
    private Integer filmId;
    private Integer directorId;
    private String name;
    private LocalDateTime releaseDate;
    private String genre;

    public Film (){

    }
    public Film (Integer filmId, Integer directorId, String name, LocalDateTime releaseDate, String genre){
        this.filmId=filmId;
        this.directorId=directorId;
        this.name=name;
        this.releaseDate=releaseDate;
        this.genre=genre;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Film film = (Film) o;
        return (filmId== film.filmId || (filmId != null && filmId.equals(film.getFilmId()))) &&
                (directorId == film.directorId || (directorId != null && directorId.equals(film.getDirectorId()))) &&
                (name == film.name || (name != null && name.equals(film.getName()))) &&
                (releaseDate == film.releaseDate || (releaseDate!= null && releaseDate.equals(film.getReleaseDate()))) &&
                (genre == film.genre|| (genre!= null && genre.equals(film.getGenre())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((filmId== null) ? 0 : filmId.hashCode());
        result = prime * result + ((directorId == null) ? 0 : directorId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
        result = prime * result + ((genre== null) ? 0 : genre.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Film {" + "filmId=" + " " + filmId + ", directorId=" + " " + directorId + ", name=" + " " + name
                + ", releaseDate=" + releaseDate+ ", genre=" + " " + genre + "}");  // в строковом представлении
        return str.toString();
    }
}
