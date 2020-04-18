<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="header.jsp" %>

<p><a href="/spot/add"> ajouter un spot </a></p>

<%@ include file="spotsearch.jsp" %>

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
        
        <spring:url value="/spot/${s.spotId}" var="spotUrl" />
        <spring:url value="/spot/${s.spotId}/delete" var="deleteUrl" /> 
        <spring:url value="/spot/${s.spotId}/update" var="updateUrl" />
        <spring:url value="/sectors/${s.spotId}/spot" var="sectorsUrl" />
        <spring:url value="/components/${s.spotId}/spot" var="componentsUrl" />
        <spring:url value="/spot/comments/${s.spotId}" var="commentsUrl" />
        
        <tr>
        <td><c:out value="${s.spotDate}">Valeur par défaut</c:out></td>
        <td><a href="${spotUrl}"><c:out value="${s.spotName}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${s.spotRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.spotDescription}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.spotAccessPath}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.departement}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
        <td>
            
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

        <form action="${commentsUrl}">
            <button class="btn btn-danger">Comments</button>
        </form>
            
                    <form action="${componentsUrl}">
            <button class="btn btn-danger">Components</button>
        </form>
        </td>
        </tr>
    </c:forEach>
</table>

nom, département, difficulté, n° secteur

<c:import url="common/footer.jsp"></c:import>
