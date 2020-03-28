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
        <th>Actions</th>
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
            <td>
            <spring:url value="/spots/${s.spotId}" var="spotUrl" />
            <spring:url value="/spots/${s.spotId}/delete" var="deleteUrl" /> 
            <spring:url value="/spots/${s.spotId}/update" var="updateUrl" />
            <spring:url value="/sectors/${s.spotId}" var="sectorsUrl" />


            <form action="${spotUrl}">
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
            <form action="${sectorsUrl}">
                <button class="btn btn-danger">Secteurs</button>
            </form>
        </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="footer.jsp" %>
