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
        <th>Actions</th>
    </tr>

    <tr>
        <td><c:out value="${spotFind.spotDate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotName}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotDescription}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.spotAccessPath}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.departement}">Valeur par défaut</c:out> </td>
        <td><c:out value="${spotFind.country}">Valeur par défaut</c:out> </td>
        <td>
            <spring:url value="/spot/${spotFind.spotId}" var="spotUrl" />
            <spring:url value="/spot/${spotFind.spotId}/delete" var="deleteUrl" /> 
            <spring:url value="/spot/${spotFind.spotId}/update" var="updateUrl" />
            <spring:url value="/sectors/${spotFind.spotId}" var="sectorsUrl" />

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

</table>

<%@ include file="footer.jsp" %>
