<%-- 
    Document   : password
    Created on : 27 avr. 2020, 08:42:04
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<form:form method="POST"
           action="/user/passwordupdate" modelAttribute="userFind">

    <form:hidden path="userId"/>

    <form class="form-horizontal">
        <h2> Informations obligatoires</h2>
        
                <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Nouveau mot de passe</label>
            <div class="col-sm-10">
                <form:password path="password" class="form-control"/>
                <form:errors path="password" class="error"/>
            </div>
        </div>

        <div class="form-group">
            <label for="passwordMatch" class="col-sm-2 control-label">Confirmation du nouveau mot de passe</label>
            <div class="col-sm-10">
                <input name="passwordMatch" class="form-control" type="password"/>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/update" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info active">Ajouter</button>
        </div>
    </form>
</form:form> 

<c:if test="${!empty error}"><span>${error}</span></c:if>

<%@ include file="../common/footer.jsp" %>