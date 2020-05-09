<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
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
            <li><a href="/spot/${spot.spotId}/sectors">Les secteurs de ${spot.spotName}</a></li>
            <li><a href="/sector/${sector.sectorId}">${componentFind.componentName}</a></li>
            <li class="active">Modifier un secteur</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots/">Les sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li><a href="/spot/${spot.spotId}/sectors">Les secteurs de ${spot.spotName}</a></li>
            <li><a href="/sector/${sector.sectorId}">${componentFind.componentName}</a></li>
            <li class="active">Modifier un secteur</li>
        </c:otherwise>  
    </c:choose>
</ol>

<h1>${componentFind.componentName}</h1>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/component/update" modelAttribute="componentFind">

    <form:hidden path="componentId"/>

    <form class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-body">

                <div class="form-group">
                    <label for="componentName" class="col-sm-2 control-label">Nom de la voie</label>
                    <div class="col-sm-10">
                        <form:input path="componentName" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="componentRate" class="col-sm-2 control-label">Difficulté</label>
                    <div class="col-sm-10">
                        <form:input path="componentRate" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="componentDescription" class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <form:input path="componentDescription" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="componentCode" class="col-sm-2 control-label">Code</label>
                    <div class="col-sm-10">
                        <form:input path="componentCode" class="form-control" type="text"/>
                    </div>
                </div>       

            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/component/${componentFind.componentId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div>

    </form>  
</form:form> 

<%@ include file="../common/footer.jsp" %>
