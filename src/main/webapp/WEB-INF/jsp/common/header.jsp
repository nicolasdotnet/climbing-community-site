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

<!-- Le doctype permet de savoir quelle version de HTML est utilisée sur la page -->
<!DOCTYPE html>
<html lang="fr">
    <head>
        <!-- Permet de spécifier l'encodage de caractères de la page -->
        <meta charset="UTF-8">
        <title>Les Amis de l'escalade</title>
        <!-- Chargement de FontAwesome-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <!-- chargement d'une GoogleFont -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <!-- chargement de bootstrap css -->
        <link rel='stylesheet' type='text/css' href='/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css' />
        <!-- chargement de la feuille de style personnalisée-->
        <link rel='stylesheet' type='text/css' href='/styles.css' />
    </head>


    <!-- Corps de la page (ce qui s'affiche dans la fenêtre du navigateur)-->
    <body>
        <header>
            <!-- menu de navigation -->
            <nav class="nav fixed-top">
                <!-- menu de navigation no js-->
                <div class="container">
                    <a class="navbar-brand"  href="/"><img src="img/logo.png" alt="Les Amis de l'escalade"/></a>
                    <ul class="nav navbar-nav">
                        <li><a href="/allspots">Spots</a></li>
                        <secu:authorize access="isAuthenticated()">
                            <li><a href="/user/alltopos">Topos</a></li>
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
            </nav>


           <!-- <nav class="navbar navbar-inverse fixed-top">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand"  href="/"><img src="img/logo.png" alt="Les Amis de l'escalade"/></a>
                    </div>
                    <div id="navbar" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="/spots">Spots</a></li>
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
            </nav>-->
        </header>
        <main>
            <div class="container">

