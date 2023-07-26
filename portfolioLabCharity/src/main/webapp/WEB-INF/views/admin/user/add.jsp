<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="../../header.jsp" %>

<div class="slogan container container--90">

    <div class="slogan--item">
        <h1>
            Panel administratora
        </h1>
        <h2>Dodaj użytkownika</h2>
    </div>

</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/user/add'/>" class="btn btn--without-border">Dodaj użytkownika</a>
    <a href="<c:url value='/admin/user/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/user/list'/>" class="btn btn--without-border">Lista Użytkowników</a>
</div>
<br>
<br>
<br>
<section class="help">
    <div class="help--slides active" data-id="1">
        <h2>Dodaj nowego Użytkownika</h2>
    </div>
    <div class="help--slides active" data-id="1">
        <form:form method="post" modelAttribute="user">
            <div class="form-group">
                <label for="username"><p>Username:</p></label>
                <form:input path="username" id="username" placeholder="Podaj nazwę użytkownika"/>
                <form:errors path="username" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="password" title="Podaj hasło"><p>Hasło:</p></label>
                <form:input path="password" id="password" placeholder="Podaj hasło"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="email" title="Podaj e-mail"><p>E-mail:</p></label>
                <form:input path="email" id="email" placeholder="Podaj e-mail"/>
                <form:errors path="email" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="firstName" title="Podaj imię"><p>Imię:</p></label>
                <form:input path="firstName" id="firstName" placeholder="Podaj imię"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="lastName" title="Podaj nazwisko"><p>Nazwisko:</p></label>
                <form:input path="lastName" id="lastName" placeholder="Podaj nazwisko"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="dateOfBirth" title="Podaj datę urodzenia"><p>Data Urodzenia:</p></label>
                <form:input path="dateOfBirth" id="dateOfBirth" placeholder="Podaj datę urodzenia"/>
                <form:errors path="dateOfBirth" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="profilePhotoUrl" title="Podaj zdjęcie profilowe"><p>Zdjęcie Profilowe:</p></label>
                <form:input path="profilePhotoUrl" id="dateOfBirth" placeholder="Podaj zdjęcie profilowe"/>
                <form:errors path="profilePhotoUrl" cssClass="error"/>
            </div>
            <div class="form-group">
                <label for="enabled"><p>Aktywowany:</p></label>
                <form:select path="enabled" id="enabled">
                    <form:option value="true">True</form:option>
                    <form:option value="false">False</form:option>
                </form:select>
                <form:errors path="enabled" cssClass="error"/>
            </div>
            <div class="form-group"><p>Role:</p>
                <form:select path="roles" items="${roles}" itemLabel="name" itemValue="id" multiple="true"/>
                <form:errors path="roles" cssClass="error"/>
            </div>
            <input type="hidden" path="id"/>
            <input type="submit" value="Zapisz" class="button btn--small">
        </form:form>
    </div>
</section>

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