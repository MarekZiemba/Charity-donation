<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="header.jsp" %>

<section class="reset-password-confirm-page">
    <h2>Zmiana hasła</h2>
    <form method="post" action="/resetPasswordConfirm">
        <input type="hidden" name="token" value="${resetToken}" />
        <div class="form-group">
            <input type="password" name="password" placeholder="Nowe hasło" />
        </div>
        <div class="form-group">
            <input type="password" name="confirmPassword" placeholder="Potwierdź nowe hasło" />
        </div>
        <div class="form-group form-group--buttons">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <sec:csrfInput/>
            <button class="btn" type="submit">Zmień hasło</button>
        </div>
    </form>
</section>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
</div>
<%@ include file="footer.jsp" %>