<%-- 
    Document   : snowsector
    Created on : 21 mars 2020, 08:55:41
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>


<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Name</th>
        <th>Rate</th>
        <th>Description</th>
        <th>Accés</th>
    </tr>
    
    <tr>
        <td><c:out value="${sectorFind.sectorDate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${sectorFind.sectorName}">Valeur par défaut</c:out> </td>
        <td><c:out value="${sectorFind.sectorRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${sectorFind.sectorDescription}">Valeur par défaut</c:out> </td>
        <td><c:out value="${sectorFind.sectorAccessPath}">Valeur par défaut</c:out> </td>
        </tr>
    </table>

<spring:url value="/sector/${sectorFind.sectorId}/delete" var="url" htmlEscape="true"/>

<form action="${url}" method="POST">

    <button class="btn btn-danger" 
            onclick="return confirm('Are you sure?')">Delete</button>

</form>

<spring:url value="/composants/${sectorFind.sectorId}" var="urlSector" htmlEscape="true"/>

<form action="${urlSector}">

    <button class="btn btn-danger" 
            onclick="return confirm('Are you sure?')">Composants</button>

</form>

<%@ include file="../common/footer.jsp" %>
