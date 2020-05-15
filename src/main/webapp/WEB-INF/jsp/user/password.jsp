<%-- 
    Document   : password
    Created on : 27 avr. 2020, 08:42:04
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li><a href="/user/update">Modifier votre compte</a></li>
    <li class="active">Modifier votre mot de passe</li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/passwordupdate" modelAttribute="userFind">

    <form:hidden path="userId"/>

    <form class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-body">

                <div class="form-group">
                    <label for="password" class="col-sm-4 control-label">Nouveau mot de passe</label>
                    <div class="col-sm-8">
                        <form:password path="password" class="form-control"/>
                        <form:errors path="password" class="error"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="passwordMatch" class="col-sm-4 control-label">Confirmation du nouveau mot de passe</label>
                    <div class="col-sm-8">
                        <input name="passwordMatch" class="form-control" type="password"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/update" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info active">Ajouter</button>
        </div>
    </form>
</form:form> 

<%@ include file="../common/footer.jsp" %>