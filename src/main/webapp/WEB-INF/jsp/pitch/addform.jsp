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
    <li><a href="/spot/${component.sector.spot.spotId}">${component.sector.spot.spotName}</a></li>
    <li><a href="/spot/${component.sector.spot.spotId}/sectors">Les secteurs de ${component.sector.spot.spotName}</a></li>
    <li><a href="/sector/${component.sector.sectorId}">${component.sector.sectorName}</a></li>
    <li><a href="/sector/${component.sector.sectorId}/components">Voie de ${component.sector.sectorName}</a></li>
    <li><a href="/component/${component.componentId}">${component.componentName}</a></li>
    <li><a href="/component/${component.componentId}/pitchs">Longueurs de ${component.componentName}</a></li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/pitchSave/${component.componentId}" modelAttribute="pitchForm">

    <form class="form-horizontal">
        <h3>Ajouter une longueur</h3>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <div class="container">

                        <div class="form-group p">
                            <label for="pitchCode" class="col-sm-2 control-label">Numéro</label>
                            <div class="col-sm-9">
                                <form:input path="pitchCode" class="form-control" type="text" value="${pitchForm.pitchCode}"/>
                            </div>
                        </div>
                        <div class="form-group p">
                            <label for="pitchRate" class="col-sm-2 control-label">Cotation</label>
                            <div class="col-sm-9">
                                <form:input path="pitchRate" class="form-control" type="text" value="${pitchForm.pitchRate}"/>
                            </div>
                        </div>
                        <div class="form-group p">
                            <label for="pitchHeight" class="col-sm-2 control-label">Hauteur</label>
                            <div class="col-sm-9">
                                <form:input path="pitchHeight" class="form-control" type="text" value="${pitchForm.pitchHeight}"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/component/${component.componentId}/pitchs" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info">Ajouter</button>
        </div>
    </form>
</form:form>  

<%@ include file="../common/footer.jsp" %>