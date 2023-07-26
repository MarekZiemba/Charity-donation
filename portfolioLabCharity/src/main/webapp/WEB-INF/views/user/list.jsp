<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp" %>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Panel administratora
        </h1>
        <h2>Lista Użytkowników</h2>
    </div>
</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/user/list'/>" class="btn btn--without-border">Mój profil</a>
</div>
<br>
<br>
<br>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2>Moje dane</h2>
    </div>
    <table style="font-size: large">
        <tr style="font-size: x-large">
            <th>Nazwa</th>
            <th>E-mail</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Data urodzenia</th>
            <th>Zdjęcie profilowe</th>
            <th>Edycja</th>
        </tr>

            <tr>
                <td style="font-size: x-large">${user.username}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.profilePhotoUrl}</td>
                <td>
                    <a href="<c:url value='/user/edit?id=${user.id}'/>" class="btn btn--small">Edytuj</a>
                </td>
            </tr>

    </table>
</div>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Wyloguj" class="btn btn--large"/>
            </form>
        </div>
    </div>
</section>

<%@ include file="../footer.jsp" %>