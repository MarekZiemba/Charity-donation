<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp" %>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Panel administratora
            </h1>
        </div>
    </div>
</header>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
</div>
<section class="steps">
    <h2>Zarządzaj</h2>
    <a href="<c:url value='/admin/institution/list'/>" class="btn btn--large">Fundacje</a>
<%--    <a href="<c:url value='/admin/admin/list'/>" class="btn btn--large">Administratorzy</a>--%>
    <a href="<c:url value='/admin/user/list'/>" class="btn btn--large">Użytkownicy</a>
    <a href="<c:url value='/admin/donation/list'/>" class="btn btn--large">Dary</a>
</section>

<%@ include file="../footer.jsp" %>
