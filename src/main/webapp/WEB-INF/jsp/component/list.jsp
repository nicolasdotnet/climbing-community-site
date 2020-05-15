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
            <li><a href="/spot/${sector.spot.spotId}">${sector.spot.spotName}</a></li>
            <li><a href="/spot/${sector.spot.spotId}/sectors">Secteurs de ${sector.spot.spotName}</a></li>
            <li><a href="/sector/${sector.sectorId}">${sector.sectorName}</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${sector.spot.spotId}">${sector.spot.spotName}</a></li>
            <li><a href="/spot/${sector.spot.spotId}/sectors">Secteurs de ${sector.spot.spotName}</a></li>
            <li><a href="/sector/${sector.sectorId}">${sector.sectorName}</a></li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <c:if test="${!owner}">
        <div  class="col-sm-10 multisearch">
            <h3>Voies de <c:out value="${sector.sectorName}">Valeur par défaut</c:out></h3>
        </div>
    </c:if>
    <c:if test="${owner}">
        <div class="col-sm-14 hidden-xs">

            <spring:url value="/user/sector/${sector.sectorId}/component/add" var="addUrl"/> 

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        >ajouter une voie</button>
            </form>
        </div>
    </c:if>
</div>


<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Nom de la voie</th>
        <th>Cotation</th>
        <th>Hauteur</th>
    <c:if test="${owner}">
        <th class="hidden-xs">Actions</th>
    </c:if>
</tr>

<c:forEach items="${components}" var="c">

    <spring:url value="/component/${c.componentId}" var="componentUrl" />
    <spring:url value="/user/component/${c.componentId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/component/${c.componentId}/update" var="updateUrl" />

    <tr>
    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.componentDate}"/></td>
    <td><a href="${componentUrl}"><c:out value="${c.componentName}">Valeur par défaut</c:out></a> </td>
    <td><c:out value="${c.componentRate}">Valeur par défaut</c:out> </td>
    <td><c:out value="${c.componentHeight} M">Valeur par défaut</c:out> </td>
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

            <spring:url value="/sectors?page=${status.index}&size=${size}" var="pageUrl" />

            <li>
                <a href="${pageUrl}"> <c:out value="${status.index}"></c:out> </a>

            </li>

        </c:forEach>

    </ul>

    <div class="col-sm-3 visible-xs">
        <c:if test="${owner}">
            <spring:url value="/user/sector/${sector.sectorId}/component/add" var="addUrl"/> 

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        >ajouter une voie</button>
            </form>
        </c:if>
    </div>


</div>

<%@ include file="../common/footer.jsp" %>