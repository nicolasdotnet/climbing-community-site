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
    <li><a href="/spot/${pitchFind.component.sector.spot.spotId}">${pitchFind.component.sector.spot.spotName}</a></li>
    <li><a href="/spot/${pitchFind.component.sector.spot.spotId}/sectors">Les secteurs de ${pitchFind.component.sector.spot.spotName}</a></li>
    <li><a href="/sector/${pitchFind.component.sector.sectorId}">${pitchFind.component.sector.sectorName}</a></li>
    <li><a href="/sector/${pitchFind.component.sector.sectorId}/components">Voie de ${pitchFind.component.sector.sectorName}</a></li>
    <li><a href="/component/${pitchFind.component.componentId}">${pitchFind.component.componentName}</a></li>
    <li><a href="/component/${pitchFind.component.componentId}/pitchs">Longueurs de ${pitchFind.component.componentName}</a></li>
    <li><a href="/pitch/${pitchFind.pitchId}">Longueur N°${pitchFind.pitchCode}</a></li>
    <li class="active">Modifier</li>
</ol>

<h2>Longueur N°${pitchFind.pitchCode}</h2>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/pitch/update" modelAttribute="pitchFind">

    <form:hidden path="pitchId"/>

    <form class="form-horizontal">
        <div class="panel panel-default t">
            <div class="panel-body">

                <div class="form-group p">
                    <label for="pitchCode" class="col-sm-2 control-label">Code longeur</label>
                    <div class="col-sm-10">
                        <form:input path="pitchCode" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="pitchRate" class="col-sm-2 control-label">Cotation</label>
                    <div class="col-sm-10">
                        <form:input path="pitchRate" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="pitchHeight" class="col-sm-2 control-label">Hauteur</label>
                    <div class="col-sm-10">
                        <form:input path="pitchHeight" class="form-control" type="text"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/pitch/${pitchFind.pitchId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div>

    </form>  
</form:form> 

<%@ include file="../common/footer.jsp" %>
