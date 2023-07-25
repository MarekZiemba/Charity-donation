<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="header.jsp" %>

<div class="slogan container container--90">
    <h2>
        <p>Nie masz wystarczających uprawnień do wyświetlenia tego widoku.</p>
        <p>Skontaktuj się z administratorem systemu w celu uzyskania dostępu.</p>
    </h2>

</div>
<a href="<c:url value='/index'/>" class="button" class="btn next-step">Powrót na stronę główną</a>
</header>

<%@ include file="footer.jsp" %>