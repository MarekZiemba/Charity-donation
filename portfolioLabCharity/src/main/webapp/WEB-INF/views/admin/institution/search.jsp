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
        <h2>Wyszukiwanie Fundacji</h2>
    </div>
</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/institution/add'/>" class="btn btn--without-border">Dodaj Fundację</a>
    <a href="<c:url value='/admin/institution/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/institution/list'/>" class="btn btn--without-border">Lista Fundacji</a>
</div>
<section style="padding-left: 240px; font-size: large">
    <div class="help--slides active" data-id="1">
        <h2>Wyszukaj Użytkownika</h2>
    </div>
    <div>
        <p>Znajdź wg nazwy fundacji</p>
        <form>
            <div class="form-group">
                <label for="name">Nazwa:</label>
                <input id="name" name="name" type="text" placeholder="Podaj Nazwę Fundacji">
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