<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../../header.jsp" %>

<div class="slogan container container--90">
    <div class="slogan--item">
        <h1>
            Panel administratora
        </h1>
        <h2>Wyszukiwanie Użytkowników</h2>
    </div>
</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/donation/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/donation/list'/>" class="btn btn--without-border">Lista Darów</a>
</div>
<br>
<br>
<br>
<section style="padding-left: 240px; font-size: large">
    <div class="help--slides active" data-id="1">
        <h2>Wyszukaj Przekazane dary</h2>
    </div>
    <div>
        <p>Znajdź wg nazwy użytkownika</p>
        <form>
            <div class="form-group">
                <label for="donationname">Nazwa Użytkownika:</label>
                <input id="donationname" name="donationname" type="text" placeholder="Podaj Nazwę Użytkownika">
            </div>
            <input type="submit" value="Search" class="btn btn--small">
        </form>
    </div>
    <div>
        <p>Znajdź wg e-maila użytkownika</p>
        <form>
            <div class="form-group">
                <label for="email">E-Mail:</label>
                <input id="email" name="email" type="text" placeholder="Podaj E-mail">
            </div>
            <input type="submit" value="Search" class="btn btn--small">
        </form>
    </div>
    <div class="sub-container">
        <p>Znajdź wg imienia i nazwiska</p>
        <form>
            <div class="form-group">
                <label for="firstName">Imię:</label>
                <input id="firstName" name="firstName" type="text" placeholder="Podaj imię">
            </div>
            <div class="form-group">
                <label for="lastName">Nazwisko:</label>
                <input id="lastName" name="lastName" type="text" placeholder="Podaj nazwisko">
            </div>
            <input type="submit" value="Search" class="btn btn--small">
        </form>
    </div>
    <div>
        <p>Znajdź wg przekazanych darów</p>
        <form action="<c:url value='/admin/donation/search/category'/>">
            <div class="form-group">
                <label for="cname">Rola:</label>
                <input id="cname" name="name" type="text" placeholder="Wpisz rodzaj">
            </div>
            <input type="submit" value="Search" class="btn btn--small">
        </form>
    </div>
</section>
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