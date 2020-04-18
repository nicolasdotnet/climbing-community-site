<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<form:form method="POST"
           action="/userSave" modelAttribute="userForm" enctype="multipart/form-data">
    <form class="form-horizontal">


        <div class="row">

            <h2> Informations obligatoires</h2>

            <div class="form-group">
                <label for="firstname" class="col-sm-2 control-label">Prénom</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="firstname" value="${userForm.firstname}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="lastname" class="col-sm-2 control-label">Nom</label>
                <div class="col-sm-10">
                    <form:input path="lastname" class="form-control" type="text" value="${userForm.lastname}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">Identifiant</label>
                <div class="col-sm-10">
                    <form:input path="username" class="form-control" type="text" value="${userForm.username}"/>
                </div>
            </div> 
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">Mot de passe</label>
                <div class="col-sm-10">
                    <form:input path="password" class="form-control" type="text" value="${userForm.password}"/>
                </div>
            </div>
            <div class="btn-group" role="group" aria-label="...">
                <a href="/spots" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Ajouter</button>
            </div>
    </form>
</form:form> 

        <c:if test="${!empty error}"><span>${error}</span></c:if> 

        <%@ include file="../common/footer.jsp" %>
