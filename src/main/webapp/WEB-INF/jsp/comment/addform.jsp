<%-- 
    Document   : spotcommentaddform
    Created on : 23 mars 2020, 16:36:09
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <form:form method="POST"
               action="/user/commentSave/${spot.spotId}" modelAttribute="spotCommentForm">
        <div class="form-group">
            <div class="col-sm-12">
                <form:textarea path="commentBody" rows="2" cols="50" placeholder="Entrer un message"/>
            </div>
        </div>


        <div class="btn-group" role="group" aria-label="...">
            <a href="/spot/${spot.spotId}/comments" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info">Publier</button>
        </div>

    </form:form>
</div>

<%@ include file="../common/footer.jsp" %>
