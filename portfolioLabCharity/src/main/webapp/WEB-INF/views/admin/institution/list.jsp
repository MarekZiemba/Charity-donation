<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>

<%@ include file="../../header.jsp" %>


<div class="slogan container container--90">

    <div class="slogan--item">
        <h1>
            Panel administratora
        </h1>
        <h2>Lista Fundacji</h2>
    </div>

</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/institution/add'/>" class="btn btn--without-border">Dodaj Fundację</a>
    <a href="<c:url value='/admin/institution/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/institution/list'/>" class="btn btn--without-border">Lista Fundacji</a>
</div>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2>Lista wszystkich Fundacji</h2>
    </div>
    <div class="pagination">
        <c:if test="${institutions.hasPrevious()}">
            <a href="<c:url value='/admin/institution/list?page=${institutions.previousPageable().pageNumber}'/>"
               class="btn btn--small">Poprzednia</a>
        </c:if>
        <c:if test="${institutions.hasNext()}">
            <a href="<c:url value='/admin/institution/list?page=${institutions.nextPageable().pageNumber}'/>"
               class="btn btn--small">Następna</a>
        </c:if>
    </div>
    <table style="font-size: large">
        <tr style="font-size: x-large">
            <th>No.</th>
            <th>Nazwa</th>
            <th>Opis</th>
            <th>Akcja</th>
        </tr>
        <jstl:forEach items="${institutions.content}" var="institution">
            <tr>
                <td>${institution.id}</td>
                <td style="font-size: x-large">${institution.name}</td>
                <td>${institution.description}</td>
                <td>
                    <a href="<c:url value='/admin/institution/edit?id=${institution.id}'/>"
                       class="btn btn--small">Edytuj</a>
                    <a href="<c:url value='/admin/institution/remove?id=${institution.id}'/>"
                       class="btn btn--small" onclick="return confirm('Na pwwno skasować?')">Usuń</a>
                </td>
            </tr>
        </jstl:forEach>
    </table>
</div>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2></h2>
    </div>
</div>
<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <form action="/logout" method="post">
                <sec:csrfInput/>
                <input type="submit" value="Wyloguj" class="btn btn--large"/>
            </form>
        </div>
    </div>
</section>

<%@ include file="../../footer.jsp" %>