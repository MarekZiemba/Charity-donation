<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="header.jsp" %>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <sec:authorize access="${param.error == 'disabled'}">
        <p>${errorMessage}</p>
    </sec:authorize>
    <form method="post" action="login">
        <div class="form-group">
            <input type="text" name="username" placeholder="Nazwa użytkownika" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <sec:csrfInput/>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
    </form>
</section>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
</div>
<%@ include file="footer.jsp" %>
