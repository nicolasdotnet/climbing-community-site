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
            <li><a href="/spot/${spot.spotId}/sector/${sector.sectorId}">${sector.sectorName}"</a></li>
            <li class="active">Ajouter une voie</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots/">Les sites</a></li>
            <li><a href="/spot/${spot.spotId}">${spot.spotName}</a></li>
            <li><a href="/spot/${spot.spotId}/sectors">Les secteurs de ${spot.spotName}</a></li>
            <li><a href="/spot/${spot.spotId}/sector/${sector.sectorId}">${sector.sectorName}"</a></li>
            <li class="active">Ajouter une voie</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/componentSave/${sector.sectorId}" modelAttribute="componentForm">

    <div class="row">
        <h2>Informations obligatoires</h2>

        <div class="form-group">
            <label for="componentName" class="col-sm-2 control-label">Nom</label>
            <div class="col-sm-10">
                <form:input path="componentName" class="form-control" type="text"/>
            </div>   
            <div class="form-group">
                <label for="componentRate" class="col-sm-2 control-label">Difficulté</label>
                <div class="col-sm-10">
                    <form:input path="componentRate" class="form-control" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label for="componentCode" class="col-sm-2 control-label">Code</label>
                <div class="col-sm-10">
                    <form:input path="componentCode" class="form-control" type="text"/>
                </div>
            </div>
            <div class="form-group">
                <label for="componentDescription" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <form:input path="componentDescription" class="form-control" type="text"/>
                </div>
            </div>

            <div class="form-group">
                <label for="componentCategory" class="col-sm-2 control-label">Catégorie</label>
                <div class="col-sm-10">
                    <select class="form-control" name="componentCategory">
                        <c:forEach items="${componentCategorys}" var="c">

                            <option value="${c.componentCategoryId}">${c.componentCategoryLabel}</option>

                        </c:forEach>
                    </select>
                </div>

                <div class="btn-group" role="group" aria-label="...">
                    <a href="/spot/${spot.spotId}/sectors" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                    <button type="submit" class="btn btn-info">Ajouter</button>
                </div>
            </div>
            </form:form>  

            <%@ include file="../common/footer.jsp" %>
