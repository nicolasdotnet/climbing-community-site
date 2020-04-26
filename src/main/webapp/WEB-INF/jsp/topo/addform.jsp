<%-- 
    Document   : sectorform
    Created on : 17 mars 2020, 15:35:28
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<form:form method="POST"
           action="/user/topoSave" modelAttribute="topoForm">
    <form class="form-horizontal">
        <h2> Informations obligatoires</h2>

        <div class="form-group">
            <form:input class="form-control" path="topoTitle" autofocus="true" value="${topoForm.topoTitle}" placeholder="Titre du topo"/>
            <form:errors path="topoTitle" class="error"/>
        </div>

        <div class="form-group">
            <form:input class="form-control" path="topoArea" value="${topoForm.topoArea}" placeholder="Lieu"/>
            <form:errors path="topoArea" class="error"/>
        </div>

        <div class="form-group">
            <form:input class="form-control" path="topoDescription" value="${topoForm.topoDescription}" placeholder="Description"/>
            <form:errors path="topoDescription" class="error"/>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/topos" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info">Ajouter</button>
        </div>
    </form>
</form:form> 

<c:if test="${!empty error}"><span>${error}</span></c:if> 

<%@ include file="../common/footer.jsp" %>
