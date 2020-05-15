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
    <li><a href="/spot/${sector.spot.spotId}">${sector.spot.spotName}</a></li>
    <li><a href="/spot/${sector.spot.spotId}/sectors">Secteurs de ${sector.spot.spotName}</a></li>
    <li><a href="/sector/${sector.sectorId}">${sector.sectorName}</a></li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/componentSave/${sector.sectorId}" modelAttribute="componentForm">

    <div class="row">
        <h3>Ajouter une voie</h3>
        <div class="panel panel-default">
            <div class="panel-body">

                <div class="form-group p">
                    <label for="componentName" class="col-sm-4 control-label">Nom</label>
                    <div class="col-sm-8">
                        <form:input path="componentName" class="form-control" type="text"/>
                    </div> 
                </div>
                    <div class="form-group p">
                        <label for="componentRate" class="col-sm-4 control-label">Cotation</label>
                        <div class="col-sm-8">
                            <form:input path="componentRate" class="form-control" type="text"/>
                        </div>
                    </div>
                    <div class="form-group p">
                        <label for="componentHeight" class="col-sm-4 control-label">Hauteur</label>
                        <div class="col-sm-8">
                            <form:input path="componentHeight" class="form-control" type="text"/>
                        </div>
                    </div>
                    <div class="form-group p">
                        <label for="componentCode" class="col-sm-4 control-label">Code du bloc</label>
                        <div class="col-sm-8">
                            <form:input path="componentCode" class="form-control" type="text"/>
                        </div>
                    </div>
                    <div class="form-group p">
                        <label for="spits" class="col-sm-4 control-label">Voie équipée</label>
                        <div class="col-sm-8">
                            <form:checkbox path="spits"/>
                            <form:errors path="spits"/>
                        </div>
                    </div>

                    <div class="form-group p">
                        <label for="componentCategory" class="col-sm-4 control-label">Catégorie</label>
                        <div class="col-sm-8">
                            <select class="form-control" name="componentCategory">
                                <c:forEach items="${componentCategorys}" var="c">

                                    <option value="${c.componentCategoryId}">${c.componentCategoryLabel}</option>

                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group p">
                        <label for="componentDescription" class="col-sm-4 control-label">Description</label>
                        <div class="col-sm-8">
                            <form:textarea rows="5" path="componentDescription" class="form-control" type="text"/>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/sector/${sector.sectorId}/components" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info">Ajouter</button>
        </div>
</form:form>  

<%@ include file="../common/footer.jsp" %>
