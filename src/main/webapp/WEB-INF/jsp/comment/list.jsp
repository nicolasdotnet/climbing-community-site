<%-- 
    Document   : spotcomment
    Created on : 23 mars 2020, 13:49:37
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<spring:url value="/user/spot/${spot.spotId}/comments/add" var="url" htmlEscape="true"/>

<h1 class="">Commentaires sur le spot <c:out value="${spot.spotName}">Valeur par défaut</c:out></h1>

<%@ include file="addform.jsp" %>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Commentaire</th>
        <th>Statut</th>
        <th>Auteur</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${comments}" var="c">
        <tr>
            <td><c:out value="${c.commentDate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${c.commentBody}">Valeur par défaut</c:out> </td>
        <td><c:out value="${c.commentStatus}">Valeur par défaut</c:out> </td>
        <td><c:out value="${c.commentAuthor.lastname}">Valeur par défaut</c:out> </td>


        <spring:url value="/user/comment/${c.commentId}" var="commentUrl" />
        <spring:url value="/user/comment/${c.commentId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/comment/${c.commentId}/update" var="updateUrl" />

        <td><a href="${updateUrl}" id="update" name="update" class="btn btn-primary">Modifier</a></td>

        <td><form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Supprimer</button>
            </form></td>
        </tr>

    </c:forEach>
</table>
<%@ include file="../common/footer.jsp" %>