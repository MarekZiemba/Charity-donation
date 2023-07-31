<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="header.jsp" %>

    <section class="reset-password-success-page">
        <h2>Hasło zostało zmienione</h2>
        <p>Twoje hasło zostało pomyślnie zmienione. Teraz możesz zalogować się używając nowego hasła.</p>
        <a href="/login" class="btn">Powrót do logowania</a>
    </section>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
</div>
<%@ include file="footer.jsp" %>