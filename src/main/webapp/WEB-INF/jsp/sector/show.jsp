<%-- 
    Document   : snowsector
    Created on : 21 mars 2020, 08:55:41
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/spot/${sectorFind.spot.spotId}">${sectorFind.spot.spotName}</a></li>
            <li><a href="/spot/${sectorFind.spot.spotId}/sectors">Secteurs de ${sectorFind.spot.spotName}</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${sectorFind.spot.spotId}">${sectorFind.spot.spotName}</a></li>
            <li><a href="/spot/${sectorFind.spot.spotId}/sectors">Secteurs de ${sectorFind.spot.spotName}</a></li>
        </c:otherwise>  
    </c:choose>
</ol>


<h2>${sectorFind.sectorName}</h2>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Description</h3></div>

        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/sector/${sectorFind.sectorId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/sector/${sectorFind.sectorId}/update" var="updateUrl" />

                <form action="${updateUrl}">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('Êtes-vous sûr ?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right"
                            onclick="return confirm('Êtes-vous sûr ?')">Supprimer</button>
                </form>
            </c:if>
        </div>
    </div>
</div>


<div class="panel panel-default">
    <div class="panel-body">
        <div>
            <label>Auteur :</label>
            <span><c:out value="${sectorFind.sectorAuthor.username}">Valeur par défaut</c:out>  </span>
        </div>
        <div>
            <label>Date d'enregistrement :</label>
            <span><fmt:formatDate pattern="dd/MM/yyyy" value="${sectorFind.sectorDate}"/></span>
        </div>
        <div>
            <div>
                <label>Nom du secteur :</label>
                <span><c:out value="${sectorFind.sectorName}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <label>Cotation :</label>
                <span><c:out value="${sectorFind.sectorRate}">Valeur par défaut</c:out>  </span>
            </div>
            <div>
                <label>Description :</label>
                <p><c:out value="${sectorFind.sectorDescription}">Valeur par défaut</c:out>  </p>
            </div>
            <div>
                <label>Chemin d'accés :</label>
                <p><c:out value="${sectorFind.sectorAccessPath}">Valeur par défaut</c:out></p>
            </div>
        </div>
    </div>
</div>


<spring:url value="/user/sector/${sectorFind.sectorId}/component/add" var="addUrl"/>  
<spring:url value="/sector/${sectorFind.sectorId}/components/" var="componentUrl"/>

<ul class="nav navbar-nav">

    <li><a href="${componentUrl}"> Consulter les voies du secteur</a></li>

</ul> 
<div class="col-sm-3 visible-xs">
    <c:if test="${owner}">
        <spring:url value="/user/sector/${sectorFind.sectorId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/sector/${sectorFind.sectorId}/update" var="updateUrl" />
        <form action="${updateUrl}">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('Êtes-vous sûr ?')">Modifier</button>
        </form>
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right"
                    onclick="return confirm('Êtes-vous sûr ?')">Supprimer</button>
        </form>
    </c:if>
</div>

<%@ include file="../common/footer.jsp" %>
