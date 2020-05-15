<%-- 
    Document   : sector
    Created on : 17 mars 2020, 12:52:34
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/spot/${component.sector.spot.spotId}">${component.sector.spot.spotName}</a></li>
            <li><a href="/spot/${component.sector.spot.spotId}/sectors">Secteurs de ${component.sector.spot.spotName}</a></li>
            <li><a href="/sector/${component.sector.sectorId}">${component.sector.sectorName}</a></li>
            <li><a href="/sector/${component.sector.sectorId}/components">Voies de ${component.sector.sectorName}</a></li>
            <li><a href="/component/${component.componentId}">${component.componentName}</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${component.sector.spot.spotId}">${component.sector.spot.spotName}</a></li>
            <li><a href="/spot/${component.sector.spot.spotId}/sectors">Secteurs de ${component.sector.spot.spotName}</a></li>
            <li><a href="/sector/${component.sector.sectorId}">${component.sector.sectorName}</a></li>
            <li><a href="/sector/${component.sector.sectorId}/components">Voies de ${component.sector.sectorName}</a></li>
            <li><a href="/component/${component.componentId}">${component.componentName}</a></li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <c:if test="${!owner}">

        <div  class="col-sm-10 multisearch">
            <h3>Longeurs de <c:out value="${component.componentName}">Valeur par défaut</c:out></h3>
        </div>
    </c:if>

    <c:if test="${owner}">
        <div class="col-sm-14 hidden-xs">

            <spring:url value="/user/component/${component.componentId}/pitch/add" var="addUrl"/> 

            <form action="${addUrl}">
                <button class="btn btn-primary pull-right w"
                        >ajouter une longeur</button>
            </form>
        </div>
    </c:if>
</div>




<table class="table table-striped">
    <tr>
        <th>Numéro</th>
        <th>Cotation</th>
        <th>Hauteur</th>
    <c:if test="${owner}">
        <th class="hidden-xs">Actions</th>
    </c:if>
</tr>

<c:forEach items="${pitchs}" var="p">

    <spring:url value="/pitch/${p.pitchId}" var="pitchUrl" />
    <spring:url value="/user/pitch/${p.pitchId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/pitch/${p.pitchId}/update" var="updateUrl" />

    <tr>
        <td><a href="${pitchUrl}"><c:out value="${p.pitchCode}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${p.pitchRate}">Valeur par défaut</c:out> </td>
    <td><c:out value="${p.pitchHeight} M">Valeur par défaut</c:out></td>

    <c:if test="${owner}">
        <td class="hidden-xs">
            <form action="${updateUrl}">
                <button class="btn btn-primary x pull-right"
                        onclick="return confirm('Êtes-vous sûr ?')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right"
                        onclick="return confirm('Êtes-vous sûr ?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
            </form>
        </td>
    </c:if>
    </tr>

</c:forEach>
</table>

<div>

    <ul class="nav nav-pills">

        <c:forEach items="${pages}" var="pa" varStatus="status">

            <spring:url value="/pitchs?page=${status.index}&size=${size}" var="pageUrl" />

            <li>
                <a href="${pageUrl}"> <c:out value="${status.index}"></c:out> </a>

            </li>

        </c:forEach>

    </ul>

    <div class="col-sm-3 visible-xs">
        <c:if test="${owner}">
            <spring:url value="/user/component/${component.componentId}/pitch/add" var="addUrl"/> 

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        >ajouter une longeur</button>
            </form>
        </c:if>
    </div>


</div>

<%@ include file="../common/footer.jsp" %>