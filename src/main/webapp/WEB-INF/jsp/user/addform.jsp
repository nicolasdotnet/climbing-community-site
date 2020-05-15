<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="signup" modelAttribute="userForm">
    <form class="form-horizontal">
        <h3> Informations obligatoires</h3>

        <div class="form-group">
            <form:input class="form-control" path="firstname"  autofocus="true" placeholder="Prénom"/>
            <form:errors path="firstname" class="error"/>
        </div>

        <div class="form-group">
            <form:input path="lastname" class="form-control" type="text" placeholder="Nom"/>
        </div>
        <form:errors path="lastname" class="error"/>
        <div class="form-group">
            <form:input path="email" class="form-control" type="text" placeholder="Email"/>
        </div>
        <form:errors path="email" class="error"/>

        <div class="form-group">
            <form:input path="username" class="form-control" type="text" placeholder="Identifiant"/>
        </div>
        <form:errors path="username" class="error"/> 
        <div class="form-group">
            <form:password path="password" class="form-control" placeholder="Mot de passe"/>
            <form:errors path="password" class="error"/>
        </div>
        <div class="form-group">
            <input name="passwordMatch" class="form-control" type="password" placeholder="Confirmer Mot de passe"/>
        </div>
        <div class="btn-group" role="group" aria-label="...">
            <button type="submit" class="btn btn-info active">Créer</button>
        </div>
    </form>
</form:form> 

<%@ include file="../common/footer.jsp" %>