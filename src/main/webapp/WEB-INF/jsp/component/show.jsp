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
            <li><a href="/spot/${componentFind.sector.spot.spotId}">${componentFind.sector.spot.spotName}</a></li>
            <li><a href="/spot/${componentFind.sector.spot.spotId}/sectors">Secteurs de ${componentFind.sector.spot.spotName}</a></li>
            <li><a href="/sector/${componentFind.sector.sectorId}">${componentFind.sector.sectorName}</a></li>
            <li><a href="/sector/${componentFind.sector.sectorId}/components">Voie de ${componentFind.sector.sectorName}</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${componentFind.sector.spot.spotId}">${componentFind.sector.spot.spotName}</a></li>
            <li><a href="/spot/${componentFind.sector.spot.spotId}/sectors">Secteurs de ${componentFind.sector.spot.spotName}</a></li>
            <li><a href="/sector/${componentFind.sector.sectorId}">${componentFind.sector.sectorName}</a></li>
            <li><a href="/sector/${componentFind.sector.sectorId}/components">Voie de ${componentFind.sector.sectorName}</a></li>
        </c:otherwise>  
    </c:choose>
</ol>


<h2>${componentFind.componentName}</h2>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Description</h3></div>

        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/component/${componentFind.componentId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/component/${componentFind.componentId}/update" var="updateUrl" />

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
            <span><c:out value="${componentFind.componentAuthor.username}">Valeur par défaut</c:out></span>
        </div>
        <div>
            <label>Date d'enregistrement :</label>
            <span><fmt:formatDate pattern="dd/MM/yyyy" value="${componentFind.componentDate}"/></span>
        </div>
        <div>
            <label>Catégorie :</label>
            <span><c:out value="${componentFind.componentCategory.componentCategoryLabel}">Valeur par défaut</c:out></span>
        </div>
        <div>
            <label>Hauteur :</label>
            <span><c:out value="${componentFind.componentHeight} M">Valeur par défaut</c:out>  </span>
        </div>
        <div>
            <label>Cotation :</label>
            <span><c:out value="${componentFind.componentRate}">Valeur par défaut</c:out>  </span>
        </div>
        <div>
            <label>Voie équipée :</label>
            <c:choose>                
                <c:when test = "${componentFind.spits == true}">
                    <span>Oui</span>
                </c:when>
                <c:when test = "${componentFind.spits == false}">
                    <span>Non</span>
                </c:when>
            </c:choose>
        </div>
        <div>
            <label>Code du bloc :</label>
            <span><c:out value="${componentFind.componentCode}">Valeur par défaut</c:out></span>
        </div>
        <div>
            <label>Description :</label>
            <p><c:out value="${componentFind.componentDescription}">Valeur par défaut</c:out>  </p>
        </div>
    </div>
</div>

<ul class="nav navbar-nav">

    <spring:url value="/component/${componentFind.componentId}/pitchs" var="pitchUrl" /> 
    <spring:url value="/user/component/${componentFind.componentId}/pitch/add" var="pitchAddUrl" />

    <li><a href="${pitchUrl}"> Consulter les longeurs</a></li>
</ul> 
<div class="col-sm-3 visible-xs">
    <c:if test="${owner}">
        <spring:url value="/user/component/${componentFind.componentId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/component/${componentFind.componentId}/update" var="updateUrl" />
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
