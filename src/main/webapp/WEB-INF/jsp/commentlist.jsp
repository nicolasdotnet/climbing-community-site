<%-- 
    Document   : spotcomment
    Created on : 23 mars 2020, 13:49:37
    Author     : nicolasdotnet
--%>

<%@ include file="header.jsp" %>

<spring:url value="/spot/comments/${spotId}/add" var="url" htmlEscape="true"/>

<h1><c:out value="${spotId}">Valeur par défaut</c:out></h1>

<p><a href="${url}"> ajouter un comment </a></p>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Comment</th>
        <th>Statut</th>
        <th>Auteur</th>
    </tr>
    
    <c:forEach items="${comments}" var="c">
        <tr>
            <td><c:out value="${c.commentDate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.commentBody}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.commentStatus}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.commentAuthor.lastname}">Valeur par défaut</c:out> </td>
            </tr>
            
            <td>
            <spring:url value="/comment/${c.commentId}" var="commentUrl" />
            <spring:url value="/comment/${c.commentId}/delete" var="deleteUrl" /> 
            <spring:url value="/comment/${c.commentId}/update" var="updateUrl" />

            <form action="${commentUrl}">
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
        </td>
            
    </c:forEach>
</table>

<%@ include file="footer.jsp" %>