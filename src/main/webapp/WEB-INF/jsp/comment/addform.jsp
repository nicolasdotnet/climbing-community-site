<%-- 
    Document   : spotcommentaddform
    Created on : 23 mars 2020, 16:36:09
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li><a href="/spot/${spot.spotId}/comments">Les commentaires</a></li>
            <li class="active">Ajouter</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li><a href="/spot/${spot.spotId}/comments">Les commentaires</a></li>
            <li class="active">Ajouter</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <form:form method="POST"
               action="/user/commentSave/${spot.spotId}" modelAttribute="spotCommentForm">

        <h3>Entrer votre message</h3>

        <div class="panel panel-default">
            <div class="panel-body">
                <div class="form-group">
                    <div class="col-sm-12">
                        <form:textarea path="commentBody" rows="2" cols="50" placeholder="Votre message"/>
                    </div>
                </div>
            </div>
        </div>
            
            <div class="btn-group" role="group" aria-label="...">
                <a href="/spot/${spot.spotId}/comments" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Publier</button>
            </div>

    </form:form>
</div>

<%@ include file="../common/footer.jsp" %>
