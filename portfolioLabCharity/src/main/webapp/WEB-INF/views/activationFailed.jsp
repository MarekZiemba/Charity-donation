<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>

<div class="slogan container container--90">
    <h2>
        Konto nie zostało pomyślnie aktywowane.

        <a href="<c:url value='/'/>" class="btn btn--large">
            Wyślij nowego maila, w celu potwierdzenia adresu email i aktywacji konta</a>

    </h2>
</div>

<%@ include file="footer.jsp" %>
