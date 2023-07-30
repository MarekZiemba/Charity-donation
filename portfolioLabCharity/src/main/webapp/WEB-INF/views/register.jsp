<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>

<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" action="/register" modelAttribute="user">
        <div class="form-group">
            <form:input type="text" path="username" id="username" placeholder="Nazwa Użytkownika"/>
            <form:errors path="username" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input type="newPassword" path="newPassword" id="newPassword" placeholder="Podaj hasło"/>
            <form:errors path="newPassword" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input type="password" path="confirmPassword" id="confirmPassword" placeholder="Powtórz hasło"/>
            <form:errors path="confirmPassword" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="email" id="email" placeholder="Podaj email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="firstName" id="firstName" placeholder="Podaj imię"/>
            <form:errors path="firstName" cssClass="error"/>
        </div>
        <div class="form-group">
            <form:input type="text" path="lastName" id="lastName" placeholder="Podaj nazwisko"/>
            <form:errors path="lastName" cssClass="error"/>
        </div>
        <div class="form-group">
            Hasło musi mieć minimum 8 znaków, przynajmniej 1 mała i dużą litere, cyfrę i znak specjalny
        </div>

        <div class="form-group">
            Po zatwierszeniu danych, na podany email zostanie wysłany kod aktywacyjny.
        </div>
        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <sec:csrfInput/>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
</div>
<%@ include file="footer.jsp" %>
