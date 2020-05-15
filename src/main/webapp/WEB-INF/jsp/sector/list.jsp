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
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li class="active">Secteurs de ${spot.spotName}</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li class="active">Secteurs de ${spot.spotName}</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <c:if test="${!owner}">
        <div  class="col-sm-10 multisearch">
            <h3>Secteurs de <c:out value="${spot.spotName}">Valeur par défaut</c:out></h3>
        </div>
    </c:if>
    <c:if test="${owner}">
        <div class="col-sm-14 hidden-xs">

            <spring:url value="/user/spot/${spot.spotId}/sector/add" var="addUrl"/> 

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        >ajouter un secteur</button>
            </form>
        </div>
    </c:if>
</div>


<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Non du secteur</th>
        <th>Cotation</th>
    <c:if test="${owner}">
        <th class="hidden-xs">Actions</th>
    </c:if>
</tr>

<c:forEach items="${sectors}" var="s">

    <spring:url value="/sector/${s.sectorId}" var="sectorUrl" />
    <spring:url value="/user/sector/${s.sectorId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/sector/${s.sectorId}/update" var="updateUrl" />
    <spring:url value="/sector/${s.sectorId}/components" var="componentsUrl" />

    <tr>
    <td><fmt:formatDate pattern="dd/MM/yyyy" value="${s.sectorDate}"/></td>
    <td><a href="${sectorUrl}"><c:out value="${s.sectorName}">Valeur par défaut</c:out></a></td>
    <td><c:out value="${s.sectorRate}">Valeur par défaut</c:out> </td>

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
            <spring:url value="/user/spot/${spot.spotId}/sector/add" var="addUrl"/> 

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        >ajouter un secteur</button>
            </form>
        </c:if>
    </div>


</div>

<%@ include file="../common/footer.jsp" %>