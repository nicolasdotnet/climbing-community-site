<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<div class="row container">
    <form:form method="POST"
               action="/userUpload" enctype="multipart/form-data">
        <h3>Sélectionner une photo</h3>

        <div class="panel panel-default">
            <div class="panel-body">
                <div class="form-group">
                    <input name="profile" type="file" required />
                </div>
                <span hidden><input name="id" value="${userFind.userId}"/></span>

                <div class="btn-group" role="group" aria-label="...">
                    <a href="/user/update" name="cancel" class="btn btn-default">Annuler</a>
                    <button type="submit" class="btn btn-info">Ajouter</button>
                </div>
            </div>
        </div>
    </form:form> 
</div>
<c:if test="${!empty error}"><span>${error}</span></c:if> 

<%@ include file="../common/footer.jsp" %>