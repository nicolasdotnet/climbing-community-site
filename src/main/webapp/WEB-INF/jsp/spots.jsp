<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="header.jsp" %>

<p><a href="/spots/add"> ajouter un spot </a></p>

<%@ include file="searchSpotbyMC.jsp" %>

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

    <c:forEach items="${spots}" var="s">
        <tr>
            <td><c:out value="${s.spotDate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.spotName}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.spotRate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.spotDescription}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.spotAccessPath}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.departement}">Valeur par défaut</c:out> </td>
            <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
            </tr>
    </c:forEach>
</table>

<%@ include file="footer.jsp" %>
