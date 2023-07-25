<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="header.jsp" %>

<div class="slogan container container--90">
    <p>Login form</p>
    <form method="post" action="login">
        Username: <label>
        <input type="text" name="email">
    </label>
        Password: <label>
        <input type="password" name="password">
    </label>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <sec:csrfInput/>
        <input type="submit" value="Zaloguj" class="button">
    </form>
    <a href="<c:url value='/login'/>" class="button">Login</a>
    <a href="<c:url value='/register'/>" class="button">Register</a>

</div>

<%@ include file="footer.jsp" %>
