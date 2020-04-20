<%-- 
    Document   : topolist
    Created on : 23 mars 2020, 19:44:38
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<spring:url value="/user/topo/add" var="url" htmlEscape="true"/>

<c:if test="${!empty error}"><span>${error}</span></c:if>

<p><a href="${url}"> ajouter un topo</a></p>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Titre</th>
        <th>Description</th>
        <th>Lieu</th>
        <th>Statut</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${topos}" var="t">

        <spring:url value="/user/topo/${t.topoId}" var="topoUrl" />
        <spring:url value="/user/topo/${t.topoId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/topo/${t.topoId}/update" var="updateUrl" />
        <spring:url value="/user/topo/${t.topoId}/booking" var="bookingUrl" />

        <tr>
            <td><c:out value="${t.topoDate}">Valeur par défaut</c:out> </td>
        <td><a href="${topoUrl}"><c:out value="${t.topoTitle}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${t.topoDescription}">Valeur par défaut</c:out> </td>
        <td><c:out value="${t.topoArea}">Valeur par défaut</c:out> </td>
        <td><c:out value="${t.topoStatus}">Valeur par défaut</c:out> </td>

        <td>    
            <form action="${bookingUrl}" method="POST">
                <button class="btn btn-default" 
                        onclick="return confirm('Are you sure?')">Réserver</button>
            </form>
            <form action="${updateUrl}">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Modifier</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Supprimer</button>
            </form>

        </td>
        </tr>

    </c:forEach>
</table>



<%@ include file="../common/footer.jsp" %>