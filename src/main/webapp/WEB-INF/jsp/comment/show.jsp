<%-- 
    Document   : commentshow
    Created on : 23 mars 2020, 17:54:03
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/spot/${commentFind.spot.spotId}">${commentFind.spot.spotName}</a></li>
            <li><a href="/spot/${commentFind.spot.spotId}/comments">Les commentaires</a></li>
            <li class="active">Un commentaire</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${commentFind.spot.spotId}">${commentFind.spot.spotName}</a></li>
            <li><a href="/spot/${commentFind.spot.spotId}/comments">Les commentaires</a></li>
            <li class="active">Un commentaire</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>


<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3></h3></div>

        <div class="col-sm-4 hidden-xs">
            <secu:authorize access="hasAuthority('membre')">
                <spring:url value="/user/comment/${commentFind.commentId}/delete" var="deleteUrl"/>
                <spring:url value="/user/comment/${commentFind.commentId}/update" var="updateUrl"/>

                <form action="${updateUrl}">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('Êtes-vous sûr ?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right"
                            onclick="return confirm('Êtes-vous sûr ?')">Supprimer</button>
                </form>
            </secu:authorize>
        </div>
    </div>
</div>

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

<div class="col-sm-3 hidden-sm hidden-lg">
    <secu:authorize access="hasAuthority('membre')">
        <spring:url value="/user/comment/${commentFind.commentId}/delete" var="deleteUrl"/>
        <spring:url value="/user/comment/${commentFind.commentId}/update" var="updateUrl"/>
        <form action="${updateUrl}">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('Êtes-vous sûr ?')">Modifier</button>
        </form>
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right"
                    onclick="return confirm('Êtes-vous sûr ?')">Supprimer</button>
        </form>
    </secu:authorize>
</div>


<%@ include file="../common/footer.jsp" %>