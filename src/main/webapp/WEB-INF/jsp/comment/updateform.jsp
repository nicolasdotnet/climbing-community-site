<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/spot/${spotFind.spotId}">${spotFind.spotName}</a></li>
            <li><a href="/spot/${spotFind.spotId}/comments">Les commentaires</a></li>
            <li class="active">Un commentaire</li>
            <li class="active">Modifier</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${spotFind.spotId}">${spotFind.spotName}</a></li>
            <li><a href="/spot/${spotFind.spotId}/comments">Les commentaires</a></li>
            <li class="active">Un commentaire</li>
            <li class="active">Modifier</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <form:form method="POST"
               action="/user/commentUpdate" modelAttribute="spotCommentFind">
        <form:hidden path="commentId"/>

        <div class="form-group">
            <div class="col-sm-12">
                <form:textarea path="commentBody" rows="2" cols="50" placeholder="Entrer un message"/>
            </div>
        </div>


        <div class="btn-group" role="group" aria-label="...">
            <a href="/spot/${spot.spotId}/comments" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info">Modifier</button>
        </div>
    </form:form> 

</div>

<%@ include file="../common/footer.jsp" %>
