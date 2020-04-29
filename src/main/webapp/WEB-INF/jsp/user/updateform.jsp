<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/user/account">Mon compte</a></li>
    <li class="active">Modifier votre compte</li>
</ol>


<div class="row container">
    <img width="150" height="150" src="/getPhoto/<c:out value='${userFind.userId}'/>" alt="Ajouter votre profil" class="img-thumbnail img-responsive">
    <spring:url value="/user/upload" var="uploadUrl" />
    <form action="${uploadUrl}">
        <button class="btn btn-info">Ajouter</button>
    </form>
</div>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div class="col-sm-9">
            <h2>Vos informations :</h2> 
        </div>
        <div class="col-sm-4 hidden-xs">
            <spring:url value="/user/passform" var="passwordUrl" />
            <form action="${passwordUrl}" class="x pull-right">
                <button class="btn btn-primary x" 
                        onclick="return confirm('Are you sure?')">Modifier votre mot de passe</button>
            </form>
        </div>
    </div>

    <c:if test="${!empty error}"><span>${error}</span></c:if>
    <c:if test="${!empty msg}"><span>${msg}</span></c:if>
    
    <form:form method="POST"
               action="/user/userupdate" modelAttribute="userFind">

        <form class="form-horizontal">
            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="form-group">
                        <form:hidden path="userId"/>
                        <label for="firstname" class="col-sm-2 control-label">Prénom</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="firstname"  autofocus="true" placeholder="Prénom"/>
                            <form:errors path="firstname"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">Nom</label>
                        <div class="col-sm-10">
                            <form:input path="lastname" class="form-control" type="text" placeholder="Nom"/>
                            <form:errors path="lastname"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <form:input path="email" class="form-control" type="text" placeholder="Email"/>
                            <form:errors path="email" class="error"/>
                        </div>
                    </div>
                </div>
            </div>
            <div class="btn-group " role="group" aria-label="...">
                <a href="/user/account" id="cancel" name="cancel" class="btn btn-default x">Annuler</a>
                <button type="submit" class="btn btn-danger active x" onclick="return confirm(${testmsg})">Modifier</button>
            </div>
        </form>
    </form:form> 
</div>

<%@ include file="../common/footer.jsp" %>