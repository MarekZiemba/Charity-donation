<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ include file="header.jsp" %>

<div class="slogan container container--90">
    <h2>
        Konto zostało pomyślnie aktywowane.
        Dziękujemy za założenie konta.

        <a href="<c:url value='/'/>" class="btn btn--large">
            Możesz przejść do strony głównej i przekazać pierwsze dary</a>

        <a href="<c:url value='/user/list'/>" class="btn btn--large">
            Albo zalogować się na swoje konto i uzupełnić swoje dane</a>
    </h2>
</div>
</header>

<%@ include file="footer.jsp" %>
