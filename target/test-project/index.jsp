<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<html>
<head>
    <title>Films</title>
    <meta charset="utf-8">

</head>
<body>
<h1 align="center">Films and Directors</h1>

</br>
</br>

<button>
    <a href="films?action=show_all_films">Show all films</a>
</button>

</br>
</br>

<button>
    <a href="films?action=show_all_directors">Show all directors</a>
</button>


<%--FORM TO SELECT DIRECTOR BY ID--%>
<form action="films" method="get">
    <input type="number" name="id" placeholder="enter id of director">
    <input type="submit" value="Search">
    <input name="action" value="find_director_by_id" hidden="hidden">
</form>

<%--FORM TO SELECT FILM BY DATE--%>
<form action="films" method="get">
    <input type="number" name="date" placeholder="enter date of film">
    <input type="submit" value="Search">
    <input name="action" value="find_film_by_date" hidden="hidden">
</form>

<%--FORM TO SELECT FILM BY DIRECTOR ID--%>
<form action="films" method="get">
    <input type="number" name="film" placeholder="enter id of director">
    <input type="submit" value="Search">
    <input name="action" value="find_film_by_director_id" hidden="hidden">
</form>

<br/>
<c:out value="${exception}"/>


<div class="film">
    <table>

        <thead class="film">
        <tr>
            <th>id</th>
            <th>director_id</th>
            <th>name</th>
            <th>release_data</th>
            <th>genre</th>
        </tr>
        </thead>

        <c:forEach items="${film}" var="film">
            <tr>
                <td align="center">${film.filmId}</td>
                <td align="center">${film.directorId}</td>
                <td align="center">${film.name}</td>
                <td align="center">${film.releaseDate}</td>
                <td align="center">${film.genre}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="director">
    <table>

        <thead class="director">
        <tr>
            <th>id</th>
            <th>first_name</th>
            <th>last_name</th>
            <th>birth_date</th>
        </tr>
        </thead>

        <c:forEach items="${director}" var="director">
            <tr>
                <td align="center">${director.directorId}</td>
                <td align="center">${director.firstName}</td>
                <td align="center">${director.lastName}</td>
                <td align="center">${director.birthDate}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
