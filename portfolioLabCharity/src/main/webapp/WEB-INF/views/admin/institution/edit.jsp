<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../../header.jsp" %>


<div class="slogan container container--90">

    <div class="slogan--item">
        <h1>
            Panel administratora
        </h1>
        <h2>Edytuj dane Fundacji</h2>
    </div>

</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/institution/add'/>" class="btn btn--without-border">Dodaj Fundację</a>
    <a href="<c:url value='/admin/institution/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/institution/list'/>" class="btn btn--without-border">Lista Fundacji</a>
</div>
<br>
<br>
<br>
<section class="help">
    <div class="help--slides active" data-id="1">
        <h2>Wprowadź zmiany w istniejącej Fundacji</h2>
    </div>
    <div class="help--slides active" data-id="1">
        <form:form method="post" modelAttribute="institution">
            <div style="font-size: x-large"><p>Nazwa Fundacji:</p> <form:input path="name"/><form:errors path="name" cssClass="error"/></div><br><br>
            <div style="font-size: x-large"><p>Opis:</p> <form:textarea path="description" rows="4" cols="50"/><form:errors path="description" cssClass="error"/></div><br><br>
            <div><input type="submit" value="Zapisz zmiany" class="btn btn--without-border btn--large"></div>
        </form:form>
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