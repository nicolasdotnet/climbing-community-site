<%-- 
    Document   : spotcomment
    Created on : 23 mars 2020, 13:49:37
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb b">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spotFind.spotName}</a></li>
            <li class="active">Les commentaires</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li class="active">Les commentaires</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <secu:authorize access="isAuthenticated()">
            <div class="col-sm-12 hidden-xs">
                <spring:url value="/user/spot/${spot.spotId}/comments/add" var="addUrl"/>

                <form action="${addUrl}" class="x pull-right">
                    <button class="btn btn-primary"
                            >Ajouter un commentaire</button>
                </form>
            </div>
        </secu:authorize>
    </div>
</div>


<spring:url value="/user/spot/${spot.spotId}/comments/add" var="url"/>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Commentaire</th>
        <th>Auteur</th>
    <secu:authorize access="hasAuthority('membre')">
        <th class="hidden-xs">Actions</th>
    </secu:authorize>
</tr>

<c:forEach items="${comments}" var="c">

    <spring:url value="/user/comment/${c.commentId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/comment/${c.commentId}/update" var="updateUrl" />
    <spring:url value="/user/comment/${c.commentId}" var="url" />

    <tr>
        <td><c:out value="${c.commentDate}">Valeur par défaut</c:out> </td>
    <td><c:out value="${c.commentBody}">Valeur par défaut</c:out></td>
    <td><c:out value="${c.commentAuthor.username}">Valeur par défaut</c:out> </td>

    <secu:authorize access="hasAuthority('membre')">
        <td class="hidden-xs">
            <form action="${updateUrl}">
                <button class="btn btn-primary x pull-right"
                        onclick="return confirm('Êtes-vous sûr ?')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right"
                        onclick="return confirm('Êtes-vous sûr ?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
            </form>
        </td>
    </secu:authorize>
    </tr>

</c:forEach>
</table>



<div class="col-sm-3 visible-xs">
    <secu:authorize access="isAuthenticated()">
        <spring:url value="/user/spot/${spot.spotId}/comments/add" var="addUrl"/>

        <form action="${addUrl}">
            <button class="btn btn-primary x pull-right"
                    >Ajouter un commentaire</button>
        </form>
    </secu:authorize>
</div>
<%@ include file="../common/footer.jsp" %>