<%-- 
    Document   : header
    Created on : 9 mars 2020, 09:04:04
    Author     : nicolasdotnet
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="secu" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="fr">
    <head>
        <meta charset="UTF-8" />
        <title>Les Amis de l'escalade</title>
        <link rel='stylesheet' type='text/css' href='/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css' />
        <link rel='stylesheet' type='text/css' href='/styles.css' />
    </head>

    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand"  href="#">AdE</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/">Home</a></li>
                    <li><a href="/spots">Spots</a></li>
                    <li><a href="/spot/multisearch">Chercher</a></li>
                    <secu:authorize access="isAuthenticated()">
                    <li><a href="/user/bookings/topos">Demande de réservations</a></li>
                    <li><a href="/user/bookings">Mes réservations</a></li>
                    <li><a href="/user/topos">Mes topos</a></li>
                    <li><a href="/user/spots">Mes sites</a></li>
                    </secu:authorize>
                    <secu:authorize access="hasAuthority('grimpeur')">
                        <li><a href="/admin">Administration</a></li>
                    </secu:authorize>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <secu:authorize access="isAuthenticated()">
                        <li><a href="/logout">Logout</a></li>
                        <li class="username"><a href="/user/account"><secu:authentication property="principal.username"/></a></li>
                    </secu:authorize>
                    <secu:authorize access="isAnonymous()">
                        <li><a href="/login">Se connecter</a></li>
                    </secu:authorize>
                </ul>
            </div>
        </div>
    </nav>

    <body>

        <div class="container">

