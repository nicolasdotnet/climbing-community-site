<%-- 
    Document   : commentshow
    Created on : 23 mars 2020, 17:54:03
    Author     : nicolasdotnet
--%>


<%@ include file="header.jsp" %>


<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Comment</th>
        <th>Statut</th>
        <th>Auteur</th>
    </tr>
    
    <tr>
        <td><c:out value="${commentFind.commentDate}">Valeur par défaut</c:out> </td>
        <td><c:out value="${commentFind.commentBody}">Valeur par défaut</c:out> </td>
        <td><c:out value="${commentFind.commentStatus}">Valeur par défaut</c:out> </td>
        <td><c:out value="${commentFind.commentAuthor.lastname}">Valeur par défaut</c:out> </td>
        </tr>
    </table>

<spring:url value="/comment/${commentFind.commentId}/delete" var="url" htmlEscape="true"/>

<form action="${url}" method="POST">

    <button class="btn btn-danger" 
            onclick="return confirm('Are you sure?')">Delete</button>

</form>


<%@ include file="footer.jsp" %>