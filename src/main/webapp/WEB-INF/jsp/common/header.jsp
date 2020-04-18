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
                    <li><a href="/multisearch">Chercher</a></li>
                    <li><a href="/topos/user">Topos</a></li>
                    <li><a href="/bookings/topo">Demande de réservations</a></li>
                    <li><a href="/bookings/user">Mes réservations</a></li>
                    <li><a href="/user/add">Inscription</a></li>
                    <li><a href="/users">Users</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/login?logout">
                            Logout
                        </a></li>
                        <li><a href="/userinfo">Users</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <body>

        <div class="container">

