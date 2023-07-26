<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<%@ include file="../../header.jsp" %>

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
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/user/add'/>" class="btn btn--without-border">Dodaj Użytkownika</a>
    <a href="<c:url value='/admin/user/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/user/list'/>" class="btn btn--without-border">Lista Użytkowników</a>
</div>
<br>
<br>
<br>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2>Wykaz wszystkich zarejestrowanych użytkowników</h2>
    </div>
    <div class="pagination">
        <c:if test="${users.hasPrevious()}">
            <a href="<c:url value='/admin/user/list?page=${users.previousPageable().pageNumber}'/>"
               class="btn btn--small">Poprzednia</a>
        </c:if>
        <c:if test="${users.hasNext()}">
            <a href="<c:url value='/admin/user/list?page=${users.nextPageable().pageNumber}'/>"
               class="btn btn--small">Następna</a>
        </c:if>
    </div>
    <table style="font-size: large">
        <tr style="font-size: x-large">
            <th>No.</th>
            <th>Nazwa</th>
            <th>E-mail</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Data urodzenia</th>
            <th>Zdjęcie profilowe</th>
            <th>Aktywowany</th>
            <th>Rola</th>
            <th>Akcja</th>
        </tr>
        <jstl:forEach items="${users.content}" var="user">
            <tr>
                <td>${user.id}</td>
                <td style="font-size: x-large">${user.username}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.dateOfBirth}</td>
                <td>${user.profilePhotoUrl}</td>
                <td>${user.enabled}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">
                        ${role.name}
                    </c:forEach>
                </td>
                <td>
                    <a href="<c:url value='/admin/user/edit?id=${user.id}'/>" class="btn btn--small">Edytuj</a>
                    <a href="<c:url value='/admin/user/remove?id=${user.id}'/>" class="btn btn--small" onclick="return confirm('Na pwwno skasować?')">Usuń</a>
                </td>
            </tr>
        </jstl:forEach>
    </table>
</div>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
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

<%@ include file="../../footer.jsp" %>