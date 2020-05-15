<%-- 
    Document   : sectorform
    Created on : 17 mars 2020, 15:35:28
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li><a href="/user/spots">Mes sites</a></li>
    <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
    <li><a href="/spot/${spot.spotId}/sectors">Secteurs de ${spot.spotName}</a></li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/sectorSave/${spot.spotId}" modelAttribute="sectorForm">

    <div class="row">
        <h3>Ajouter un secteur</h3>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="form-group p">
                    <label for="sectorName" class="col-sm-4 control-label">Nom du secteur</label>
                    <div class="col-sm-8">
                        <form:input path="sectorName" class="form-control" type="text" value="${sectorForm.sectorName}"/>
                    </div>
                </div>


                <div class="form-group p">
                    <label for="sectorRate" class="col-sm-4 control-label">Cotation</label>
                    <div class="col-sm-8">
                        <form:input path="sectorRate" class="form-control" type="text" value="${sectorForm.sectorRate}"/>
                    </div>
                </div>


                <div class="form-group p">
                    <label for="sectorDescription" class="col-sm-4 control-label">Description</label>
                    <div class="col-sm-8">
                        <form:textarea rows="5" path="sectorDescription" class="form-control" type="text" value="${sectorForm.sectorDescription}"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="sectorAccessPath" class="col-sm-4 control-label">Chemin d'accès</label>
                    <div class="col-sm-8">
                        <form:textarea rows="2" path="sectorAccessPath" class="form-control" type="text" value="${sectorForm.sectorAccessPath}"/>
                    </div>
                </div>


            </div>
        </div>
    </div>

    <div class="btn-group" role="group" aria-label="...">
        <a href="/spot/${spot.spotId}/sectors" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
        <button type="submit" class="btn btn-info">Ajouter</button>
    </div>
</form:form>  

<%@ include file="../common/footer.jsp" %>
