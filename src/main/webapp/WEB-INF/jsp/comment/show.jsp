<%-- 
    Document   : commentshow
    Created on : 23 mars 2020, 17:54:03
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>


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

<spring:url value="/user/spotcomment/${commentFind.commentId}/delete" var="deleteUrl" htmlEscape="true"/>
<spring:url value="/user/spotcomment/${commentFind.commentId}/update" var="updateUrl" htmlEscape="true"/>

<form action="${deleteUrl}" method="POST">

    <button class="btn btn-danger" 
            onclick="return confirm('Are you sure?')">Delete</button>

</form>

<form action="${updateUrl}">

    <button class="btn btn-danger" 
            onclick="return confirm('Are you sure?')">Update</button>

</form>


<%@ include file="../common/footer.jsp" %>