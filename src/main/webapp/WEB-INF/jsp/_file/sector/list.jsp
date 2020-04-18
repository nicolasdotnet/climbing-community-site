<%-- 
    Document   : sector
    Created on : 17 mars 2020, 12:52:34
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<spring:url value="/sectors/${spotId}/add" var="url" htmlEscape="true"/>

<h1>Secteurs du spot <c:out value="${spotName}">Valeur par défaut</c:out></h1>

<p><a href="${url}"> ajouter un secteur avec un spot</a></p>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Name</th>
        <th>Rate</th>
        <th>Description</th>
        <th>Accés</th>
        <th>Spot</th>
    </tr>

    <c:forEach items="${sectors}" var="s">

        <spring:url value="/sector/${s.sectorId}" var="sectorUrl" />
        <spring:url value="/sector/${s.sectorId}/delete" var="deleteUrl" /> 
        <spring:url value="/sector/${s.sectorId}/update" var="updateUrl" />
        <spring:url value="/composants/${s.sectorId}" var="composantsUrl" />

        <tr>
            <td><c:out value="${s.sectorDate}">Valeur par défaut</c:out> </td>
        <td><a href="${sectorUrl}"><c:out value="${s.sectorName}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${s.sectorRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.sectorDescription}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.sectorAccessPath}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.spot.spotName}">Valeur par défaut</c:out> </td>
        </tr>

        <td>

            <form action="${sectorUrl}">
                <button class="btn btn-info">Query</button>
            </form> 
            <form action="${updateUrl}">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Update</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Delete</button>
            </form>
            <form action="${composantsUrl}">
                <button class="btn btn-danger">Composants</button>
            </form>
        </td>

    </c:forEach>
</table>

<%@ include file="../common/footer.jsp" %>