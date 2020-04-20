<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>

<c:if test="${!empty error}"><span>${error}</span></c:if>

<p><a href="/user/spot/add"> ajouter un spot </a></p>

<%@ include file="search.jsp" %>

<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Rate</th>
        <th>Secteurs</th>
        <th>Officiel</th>
        <th>Département</th>
        <th>Pays</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${spots}" var="s">

        <spring:url value="/spot/${s.spotId}" var="spotUrl" />
        <spring:url value="/user/spot/${s.spotId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/spot/${s.spotId}/update" var="updateUrl" />
        <spring:url value="/sectors/${s.spotId}/spot" var="sectorsUrl" />
        <spring:url value="/components/${s.spotId}/spot" var="componentsUrl" />
        <spring:url value="/user/spot/${s.spotId}/comments/" var="commentsUrl" />

        <tr>
            <td><a href="${spotUrl}"><c:out value="${s.spotName}">Valeur par défaut</c:out></a> </td>
            <td><c:out value="${s.spotRate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.official}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.departement}">Valeur par défaut</c:out> </td>
        <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
        <td>

            <form action="${updateUrl}">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Modifier</button>
            </form>

            <a href="${commentsUrl}" id="comments" name="comments" class="btn btn-default">Commentaire</a>

        </td>
        </tr>
    </c:forEach>
</table>
<div>

    <ul class="nav nav-pills">

        <c:forEach items="${pages}" var="pa" varStatus="status">
            
            <spring:url value="/spots?page=${status.index}&size=${size}" var="pageUrl" />

            <li>
                <a href="${pageUrl}"> <c:out value="${status.index}"></c:out> </a>

            </li>

        </c:forEach>

    </ul>


</div>

<%@ include file="../common/footer.jsp" %>
