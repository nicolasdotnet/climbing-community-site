<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<h2>Profile</h2>
<div>
    <img width="150" height="150" src="/getPhoto/<c:out value='${userFind.userId}'/>" alt="Ajouter votre profil" class="img-thumbnail img-responsive">
</div> 
<spring:url value="/user/${userFind.userId}/upload" var="uploadUrl" />
<form action="${uploadUrl}">
    <button class="btn btn-info">Ajouter</button>
</form>

<form:form method="POST"
           action="/user/userupdate" modelAttribute="userFind">

    <form:hidden path="userId"/>

    <form class="form-horizontal">
        <h2> Informations obligatoires</h2>

        <div class="form-group">
            <form:input class="form-control" path="firstname"  autofocus="true" value="${userFind.firstname}" placeholder="Prénom"/>
            <form:errors path="firstname"/>
        </div>

        <div class="form-group">
            <form:input path="lastname" class="form-control" type="text" value="${userFind.lastname}" placeholder="Nom"/>
        </div>
        <form:errors path="lastname"/>

        <div class="form-group">
            <form:input path="email" class="form-control" type="text" value="${userFind.email}" placeholder="Email"/>
        </div>
        <form:errors path="email" class="error"/>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/account" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info active">Ajouter</button>
        </div>
    </form>
</form:form> 

<h1>The button disabled attribute</h1>

<button type="button" disabled="disabled">Click Me!</button>

<form:errors path="email"/> 
<c:if test="${!empty error}"><span>${error}</span></c:if> 

<%@ include file="../common/footer.jsp" %>
