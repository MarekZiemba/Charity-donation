<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
</head>
<body>
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="<c:url value='/login'/>" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="<c:url value='/register'/>" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="<c:url value='/'/>" class="btn btn--without-border active">Start</a></li>
            <li><a href="<c:url value='/user/list'/>" class="btn btn--without-border">Mój Profil</a></li>
<%--            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>--%>
            <li><a href="<c:url value='/admin/panel'/>" class="btn btn--without-border">Panel Admina</a></li>
<%--            <li><a href="#" class="btn btn--without-border">O nas</a></li>--%>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <!-------------------------------- Header -------------------------------->
