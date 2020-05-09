<%-- 
    Document   : sectorform
    Created on : 17 mars 2020, 15:35:28
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
            <li class="active">Ajouter un secteur</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots/">Les sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li><a href="/spot/${spot.spotId}/sectors">Les secteurs de ${spot.spotName}</a></li>
            <li class="active">Ajouter un secteur</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/sectorSave/${spot.spotId}" modelAttribute="sectorForm">
   
        <div class="row">
            <h2>Informations obligatoires</h2>

            <div class="form-group">
                <label for="sectorName" class="col-sm-2 control-label">Nom</label>
                <div class="col-sm-10">
                    <form:input path="sectorName" class="form-control" type="text" value="${sectorForm.sectorName}"/>
                </div>   
                <div class="form-group">
                    <label for="sectorRate" class="col-sm-2 control-label">Difficulté</label>
                    <div class="col-sm-10">
                        <form:input path="sectorRate" class="form-control" type="text" value="${sectorForm.sectorRate}"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sectorDescription" class="col-sm-2 control-label">Description</label>
                    <div class="col-sm-10">
                        <form:input path="sectorDescription" class="form-control" type="text" value="${sectorForm.sectorDescription}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="sectorAccessPath" class="col-sm-2 control-label">Accès</label>
                    <div class="col-sm-10">
                        <form:input path="sectorAccessPath" class="form-control" type="text" value="${sectorForm.sectorAccessPath}"/>
                    </div>
                </div>
            </div>

            <div class="btn-group" role="group" aria-label="...">
                <a href="/spot/${spot.spotId}/sectors" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Ajouter</button>
            </div>
        </div>
</form:form>  

<%@ include file="../common/footer.jsp" %>
