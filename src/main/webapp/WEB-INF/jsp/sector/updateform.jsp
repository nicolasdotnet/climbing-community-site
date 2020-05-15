<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li><a href="/user/spots">Mes sites</a></li>
    <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
    <li><a href="/spot/${spot.spotId}/sectors">Secteurs de ${spot.spotName}</a></li>
    <li><a href="/sector/${sectorFind.sectorId}">${sectorFind.sectorName}</a></li>
    <li class="active">Modifier</li>
</ol>

<h2>${sectorFind.sectorName}</h2>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/sector/update" modelAttribute="sectorFind">

    <form:hidden path="sectorId"/>

    <form class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-body">

                <div class="form-group p">
                    <label for="sectorName" class="col-sm-4 control-label">Nom du secteur</label>
                    <div class="col-sm-8">
                        <form:input path="sectorName" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="sectorRate" class="col-sm-4 control-label">Difficulté</label>
                    <div class="col-sm-8">
                        <form:input path="sectorRate" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="sectorDescription" class="col-sm-4 control-label">Description</label>
                    <div class="col-sm-8">
                        <form:textarea rows="5" path="sectorDescription" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="sectorAccessPath" class="col-sm-4 control-label">Chemin d'accès</label>
                    <div class="col-sm-8">
                        <form:textarea rows="2" path="sectorAccessPath" class="form-control" type="text"/>
                    </div>
                </div>       

            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/sector/${sectorFind.sectorId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div>

    </form>  
</form:form> 

<%@ include file="../common/footer.jsp" %>
