<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li class="active">${spotFind.spotName}</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li class="active">${spotFind.spotName}</li>
        </c:otherwise>  
    </c:choose>
</ol>

<h3>R�servation n� ${bookingFind.bookingId} : </h3>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Descriptions : </h3></div>

        <div class="col-sm-4 hidden-xs">
            <spring:url value="/user/booking/${bookingFind.bookingId}/cancel" var="deleteUrl"/>
            <spring:url value="/user/booking/${bookingFind.bookingId}/available" var="availableUrl"/>
            <spring:url value="/user/booking/${bookingFind.bookingId}/validate" var="validateUrl"/> 

            <c:if test="${owner}">
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right" 
                            onclick="return confirm('Are you sure?')">Annuler</button>
                </form>
            </c:if>
            <c:choose> 
                <c:when test="${bookingFind.bookingStatus && !owner}">
                    <form action="${availableUrl}" method="POST">
                        <button class="btn btn-danger x pull-right" 
                                onclick="return confirm('Are you sure?')">Refuser</button>
                    </form>
                    <form action="${deleteUrl}" method="POST">
                        <button class="btn btn-danger x pull-right" 
                                onclick="return confirm('Are you sure?')">Annuler</button>
                    </form>
                </c:when>
                <c:when test="${!bookingFind.bookingStatus && !owner}">
                    <form action="${validateUrl}" method="POST">
                        <button class="btn btn-danger x pull-right" 
                                onclick="return confirm('Are you sure?')">Valider</button>
                    </form>
                    <form action="${deleteUrl}" method="POST">
                        <button class="btn btn-danger x pull-right" 
                                onclick="return confirm('Are you sure?')">Annuler</button>
                    </form>
                </c:when>
            </c:choose> 
        </div>
    </div>
</div>

<div class="row">
    <div class="panel panel-default col-md-14">
        <div class="panel-body">
            <div>
                <label>Date</label>
                <span><c:out value="${bookingFind.bookingDate}">Valeur par d�faut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Statut</label>
                    <span><c:out value="${bookingFind.bookingStatus}">Valeur par d�faut</c:out> </span>
                </div>
                <div>
                    <label>Demandeur</label>
                    <span><c:out value="${bookingFind.bookingUser.username}">Valeur par d�faut</c:out></span>
                </div>
                <div>
                    <label>Titre du topo</label>
                    <span><c:out value="${bookingFind.bookingTopo.topoTitle}">Valeur par d�faut</c:out> </span>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="col-sm-3 hidden-sm hidden-lg">
    <spring:url value="/user/booking/${bookingFind.bookingId}/cancel" var="deleteUrl"/>
    <spring:url value="/user/booking/${bookingFind.bookingId}/available" var="availableUrl"/>
    <spring:url value="/user/booking/${bookingFind.bookingId}/validate" var="validateUrl"/> 

    <c:if test="${owner}">
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right" 
                    onclick="return confirm('Are you sure?')">Annuler</button>
        </form>
    </c:if>
    <c:choose> 
        <c:when test="${bookingFind.bookingStatus && !owner}">
            <form action="${availableUrl}" method="POST">
                <button class="btn btn-danger x pull-right" 
                        onclick="return confirm('Are you sure?')">Refuser</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right" 
                        onclick="return confirm('Are you sure?')">Annuler</button>
            </form>
        </c:when>
        <c:when test="${!bookingFind.bookingStatus && !owner}">
            <form action="${validateUrl}" method="POST">
                <button class="btn btn-danger x pull-right" 
                        onclick="return confirm('Are you sure?')">Valider</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right" 
                        onclick="return confirm('Are you sure?')">Annuler</button>
            </form>
        </c:when>
    </c:choose> 
</div>

<%@ include file="../common/footer.jsp" %>
