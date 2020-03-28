<%-- 
    Document   : sector
    Created on : 17 mars 2020, 12:52:34
    Author     : nicolasdotnet
--%>

<%@ include file="header.jsp" %>

<spring:url value="/sectors/${spotId}/add" var="url" htmlEscape="true"/>

<h1><c:out value="${spotId}">Valeur par défaut</c:out></h1>

<p><a href="${url}"> ajouter un secteur </a></p>

<%@ include file="searchSectorbyMC.jsp" %>

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
        <tr>
            <td><c:out value="${s.sectorDate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.sectorName}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.sectorRate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.sectorDescription}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.sectorAccessPath}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.spot.spotName}">Valeur par défaut</c:out> </td>
            </tr>
            
            <td>
            <spring:url value="/sectors/${s.sectorId}" var="sectorUrl" />
            <spring:url value="/sectors/${s.sectorId}/delete" var="deleteUrl" /> 
            <spring:url value="/sectors/${s.sectorId}/update" var="updateUrl" />
            <spring:url value="/composants/${s.sectorId}" var="composantsUrl" />

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

<%@ include file="footer.jsp" %>