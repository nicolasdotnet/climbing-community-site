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
            <li><a href="/spot/${pitchFind.component.sector.spot.spotId}">${pitchFind.component.sector.spot.spotName}</a></li>
            <li><a href="/spot/${pitchFind.component.sector.spot.spotId}/sectors">Secteurs de ${pitchFind.component.sector.spot.spotName}</a></li>
            <li><a href="/sector/${pitchFind.component.sector.sectorId}">${pitchFind.component.sector.sectorName}</a></li>
            <li><a href="/sector/${pitchFind.component.sector.sectorId}/components">Voies de ${pitchFind.component.sector.sectorName}</a></li>
            <li><a href="/component/${pitchFind.component.componentId}">${pitchFind.component.componentName}</a></li>
            <li><a href="/component/${pitchFind.component.componentId}/pitchs">Longueurs de la voie ${pitchFind.component.componentName}</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${pitchFind.component.sector.spot.spotId}">${pitchFind.component.sector.spot.spotName}</a></li>
            <li><a href="/spot/${pitchFind.component.sector.spot.spotId}/sectors">Secteurs de ${pitchFind.component.sector.spot.spotName}</a></li>
            <li><a href="/sector/${pitchFind.component.sector.sectorId}">${pitchFind.component.sector.sectorName}</a></li>
            <li><a href="/sector/${pitchFind.component.sector.sectorId}/components">Voies de ${pitchFind.component.sector.sectorName}</a></li>
            <li><a href="/component/${pitchFind.component.componentId}">${pitchFind.component.componentName}</a></li>
            <li><a href="/component/${pitchFind.component.componentId}/pitchs">Longueurs de la voie ${pitchFind.component.componentName}</a></li>
        </c:otherwise>  
    </c:choose>
</ol>


<h2>Longueur N°${pitchFind.pitchCode}</h2>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Description</h3></div>

        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/pitch/${pitchFind.pitchId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/pitch/${pitchFind.pitchId}/update" var="updateUrl" />

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
            <span><c:out value="${pitchFind.pitchAuthor.username}">Valeur par défaut</c:out>  </span>
        </div>
        <div>
            <label>Date d'enregistrement :</label>
            <span><fmt:formatDate pattern="dd/MM/yyyy" value="${pitchFind.pitchDate}"/></span>
        </div>
        <div>
            <label>Hauteur :</label>
            <span><c:out value="${pitchFind.pitchHeight} M">Valeur par défaut</c:out>  </span>
        </div>
        <div>
            <label>Cotation :</label>
            <span><c:out value="${pitchFind.pitchRate}">Valeur par défaut</c:out>  </span>
        </div>
    </div>
</div>

<div class="col-sm-3 visible-xs">
    <c:if test="${owner}">
        <spring:url value="/user/pitch/${pitchFind.pitchId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/pitch/${pitchFind.pitchId}/update" var="updateUrl" />
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
