<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
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


<h1>${spotFind.spotName}</h1>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Descriptions : </h3></div>

        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/spot/${spotFind.spotId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/spot/${spotFind.spotId}/update" var="updateUrl" />

                <form action="${updateUrl}">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('Are you sure?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right"
                            onclick="return confirm('Are you sure?')">Supprimer</button>
                </form>
            </c:if>
            <secu:authorize access="hasAuthority('admin')">
                <spring:url value="/user/spotstatus/${spotFind.spotId}" var="updateStatusUrl" />
                <form action="${updateStatusUrl}" method="POST">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('Are you sure?')">${spotFind.official ? "non officiel" : "officiel" }</button>
                </form>
            </secu:authorize>
        </div>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-body">
        <div>
            <label>Site officiel des Amis</label>
            <span><c:out value="${spotFind.official}">Valeur par défaut</c:out> </span>
        </div>
        <div>
            <div>
                <label>Niveau</label>
                <span><c:out value="${spotFind.spotRate}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <label>Département</label>
                <span><c:out value="${spotFind.location}">Valeur par défaut</c:out>  </span>
            </div>
            <div>
                <label>Pays</label>
                <span><c:out value="${spotFind.country}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Date d'enregistrement</label>
                <span><fmt:formatDate pattern="dd/MM/yyyy" value="${spotFind.spotDate}" /></span>
            </div>
        </div>
    </div>
</div>

<h3>Informations complémentaires : </h3>
<div class="panel panel-default">
    <div class="panel-body">
        <div>
            <label>Description</label>
            <p><c:out value="${spotFind.spotDescription}">Valeur par défaut</c:out></p>
        </div>
        <div>
            <label>Accès</label>
            <span><c:out value="${spotFind.spotAccessPath}">Valeur par défaut</c:out> </span>
        </div>
        <div>
            <label>Nombre de Secteurs enregistrés : </label>
            <span><c:out value="${spotFind.sectorCount}">Valeur par défaut</c:out> </span>
        </div>
        <div>
            <div>
                <label>Nombre de Voie/Bloc enregistrées : </label>
                <span><c:out value="${spotFind.componentCount}">Valeur par défaut</c:out> </span>
            </div>
        </div>
    </div>
</div>

<spring:url value="/spot/${spotFind.spotId}/comments" var="commentUrl"/>
<spring:url value="/user/spot/${spotFind.spotId}/sector/add" var="addUrl"/>  
<spring:url value="/spot/${spotFind.spotId}/sectors" var="sectorUrl"/>

<ul class="nav navbar-nav">
    <li><a href="${commentUrl}"> Consulter les commentaires</a></li>
    <c:choose>
        <c:when test="${spotFind.sectorCount >0}">
            <li><a href="${sectorUrl}"> Consulter les secteurs du site</a></li>
            <c:if test="${owner}">
                <li><a href="${addUrl}"> Ajouter un secteur au site</a></li>
            </c:if>
        </c:when>
        <c:otherwise> 
            <c:if test="${owner}">
                <li><a href="${addUrl}"> Ajouter un secteur au site</a></li>
            </c:if>
        </c:otherwise>
    </c:choose>
</ul> 
<div class="col-sm-3 hidden-sm hidden-lg">
    <c:if test="${owner}">
        <spring:url value="/user/spot/${spotFind.spotId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/spot/${spotFind.spotId}/update" var="updateUrl" />
        <form action="${updateUrl}">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('Are you sure?')">Modifier</button>
        </form>
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right"
                    onclick="return confirm('Are you sure?')">Supprimer</button>
        </form>
    </c:if>
    <secu:authorize access="hasAuthority('admin')">
        <spring:url value="/user/spotstatus/${spotFind.spotId}" var="updateStatusUrl" />
        <form action="${updateStatusUrl}" method="POST">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('Are you sure?')">${spotFind.official ? "non officiel" : "officiel" }</button>
        </form>
    </secu:authorize>
</div>

<%@ include file="../common/footer.jsp" %>
