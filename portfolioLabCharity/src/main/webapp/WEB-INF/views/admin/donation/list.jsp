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
        <h2>Lista Przekazanych Darów</h2>
    </div>

</div>
</header>

<div class="form--steps-container">
    <a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Administratora</a>
    <a href="<c:url value='/admin/donation/search'/>" class="btn btn--without-border">Wyszukaj</a>
    <a href="<c:url value='/admin/donation/list'/>" class="btn btn--without-border">Lista Darów</a>
</div>
<div class="form--steps-container">
    <div class="help--slides active" data-id="1">
        <h2>Lista wszystkich Darów</h2>
    </div>
    <div class="pagination">
        <c:if test="${donations.hasPrevious()}">
            <a href="<c:url value='/admin/donation/list?page=${donations.previousPageable().pageNumber}'/>"
               class="btn btn--small">Poprzednia</a>
        </c:if>
        <c:if test="${donations.hasNext()}">
            <a href="<c:url value='/admin/donation/list?page=${donations.nextPageable().pageNumber}'/>"
               class="btn btn--small">Następna</a>
        </c:if>
    </div>
    <table style="font-size: large">
        <tr style="font-size: x-large">
            <th>No.</th>
            <th>Ilość</th>
            <th>Rodzaj</th>
            <th>Fundacja</th>
            <th>Godzina</th>
            <th>Data Odbioru</th>
            <th>Ulica</th><th>Miasto</th><th>Kod Pocztowy</th>
            <th>Telefon</th>
            <th>Akcja</th>
        </tr>
        <jstl:forEach items="${donations.content}" var="donation">
            <tr>
                <td>${donation.id}</td>
                <td style="font-size: x-large">${donation.quantity}</td>
                <td>
                    <c:forEach items="${donation.categories}" var="category">
                        ${category.name}
                    </c:forEach>
                </td>
                <td>${donation.institution.name}</td>
                <td>${donation.pickUpTime}</td>
                <td>${donation.pickUpDate}</td>
                <td>${donation.street}</td>
                <td>${donation.city}</td>
                <td>${donation.zipCode}</td>
                <td>${donation.phone}</td>
                <td>${donation.pickUpComment}</td>
                <td>
                    <a href="<c:url value='/admin/donation/edit?id=${donation.id}'/>"
                       class="btn btn--small">Edytuj</a>
                    <a href="<c:url value='/admin/donation/remove?id=${donation.id}'/>"
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