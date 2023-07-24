<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Login form</title>
    <%--        <link rel="stylesheet" type="text/css" href="/css/style.css">--%>
</head>
<body>
<div class="sub-container">
    <p>Registration form</p>
    <form:form method="post" action="/register" modelAttribute="user">
        <label for="email">Username:</label>
        <form:input type="text" path="email" id="email" placeholder="Enter email"/>
        <form:errors path="username" cssClass="error"/>
        </br>
        <label for="password">Password:</label>
        <form:input type="password" path="password" id="password" placeholder="Enter password"/>
        <form:errors path="password" cssClass="error"/>
        </br>
        <label for="confirmPassword">Confirm Password:</label>
        <form:input type="password" path="confirmPassword" id="confirmPassword" placeholder="Confirm password"/>
        <form:errors path="confirmPassword" cssClass="error"/>
        </br>
        <div>Password requirements:</br>
            - must be at least 8 characters long;</br>
            - with at least 1 lowercase letter;</br>
            - at least 1 uppercase letter;</br>
            - at least 1 number;</br>
            - at least 1 special character</div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <sec:csrfInput/>
        <input type="submit" value="Zarejestruj" class="button">
    </form:form>
</div>
</body>
</html>