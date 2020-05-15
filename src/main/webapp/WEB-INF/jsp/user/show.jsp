<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb b">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li>Mon compte</li>
        </c:when>
        <c:otherwise>
            <li>Compte de ${userFind.username}</li>
        </c:otherwise>  
    </c:choose>
</ol>

<div class="row container">
    <div>
        <img width="150" height="150" src="/getPhoto/<c:out value='${userFind.userId}'/>" alt="Ajouter votre photo !" class="img-thumbnail img-responsive">
    </div>
</div>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div class="col-sm-8">
            <h3>Vos informations</h3> 
        </div>
        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}"> 
                <spring:url value="/user/update" var="updateUrl"/>
                <a href="${updateUrl}" class="btn btn-primary x pull-right" role="button">Modifier</a>
            </c:if>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <div>
                <label>Prénom :</label>
                <span><c:out value="${userFind.firstname}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Nom :</label>
                <span><c:out value="${userFind.lastname}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Identifiant :</label>
                <span><c:out value="${userFind.username}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Email :</label>
                <a href="mailto:${userFind.email}"><c:out value="${userFind.email}">Valeur par défaut</c:out></a>
            </div>
            <div>
                <label>Groupe :</label>
                <span><c:out value="${userFind.role.roleName}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Date d'enregistrement :</label>
                <span><fmt:formatDate pattern="dd/MM/yyyy" value="${userFind.userDate}" /></span>
            </div>
        </div>
    </div>
</div>

<c:if test="${!owner}">
    <ul class="nav navbar-nav">
        <li><a href="/user/${userFind.userId}/owner">Consulter les Topos de ${userFind.username}</a></li>
    </ul>
</c:if>


<c:if test="${owner}">
    <ul class="nav navbar-nav">
        <li><a href="/user/bookings/topos">Demande de réservations</a></li>
        <li><a href="/user/bookings">Mes réservations</a></li>
        <li><a href="/user/topos">Mes topos</a></li>
        <li><a href="/user/spots">Mes sites</a></li>
    </ul>
</c:if>

<div class="col-sm-3 visible-xs">
    <c:if test="${owner}">
        <spring:url value="/user/update" var="updateUrl"/>
        <a href="${updateUrl}" class="btn btn-primary x pull-right" role="button">Modifier</a>
    </c:if>
</div>


<%@ include file="../common/footer.jsp" %>
