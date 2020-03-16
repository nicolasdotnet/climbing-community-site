<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="header.jsp" %>

<h1>${msg}</h1>


<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Name</th>
        <th>Rate</th>
        <th>Description</th>
        <th>Accés</th>
        <th>Département</th>
        <th>Pays</th>
    </tr>
    
    <tr>
        <td><c:out value="${spotFind.spotDate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotName}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotDescription}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotAccessPath}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.departement}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.country}">Valeur par défaut</c:out> </td>
        </tr>

    </table>

<spring:url value="/spots/${spotFind.spotId}/delete" var="url" htmlEscape="true"/>

<form action="${url}" method="POST">

    <button class="btn btn-danger" 
            onclick="return confirm('Are you sure?')">Delete</button>

</form>

<%@ include file="footer.jsp" %>
