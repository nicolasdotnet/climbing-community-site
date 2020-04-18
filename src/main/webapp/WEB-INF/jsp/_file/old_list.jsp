<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>

<p><a href="/spot/add"> ajouter un spot </a></p>

<%@ include file="search.jsp" %>

<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Rate</th>
        <th>Secteurs</th>
        <th>Officiel</th>
        <th>Département</th>
        <th>Pays</th>
    </tr>
    <c:forEach items="${spots}" var="s">
        <spring:url value="/spot/${s.spotId}" var="spotUrl" />
        <tr>
        <td><a href="${spotUrl}"><c:out value="${s.spotName}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${s.spotRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.official}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.departement}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
        </tr>
    </c:forEach>
</table>

nom, département, difficulté, n° secteur

<%@ include file="../common/footer.jsp" %>
