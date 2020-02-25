package com.godel.test.entity;

import java.time.LocalDate;

/**
 * Класс-сущность для  Director
 *
 * @author Shpakova A.
 */

public class Director extends Entity {
    private Integer directorId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public Director() {
    }

    public Director(Integer directorId, String firstName, String lastName, LocalDate birthDate) {
        this.directorId = directorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Director director = (Director) o;
        return (directorId == director.directorId || (directorId!= null && directorId.equals(director.getDirectorId()))) &&
                (firstName == director.firstName || (firstName != null && firstName.equals(director.getFirstName()))) &&
                (lastName == director.lastName || (lastName != null && lastName.equals(director.getLastName()))) &&
                (birthDate == director.birthDate || (birthDate != null && birthDate.equals(director.getBirthDate())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((directorId == null) ? 0 : directorId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Director {" + "directorId=" + " " + directorId + ", firstName=" + " " + firstName + ", lastName=" + " " + lastName
                + ", birthDate=" + birthDate + "}");  // в строковом представлении
        return str.toString();
    }
}
