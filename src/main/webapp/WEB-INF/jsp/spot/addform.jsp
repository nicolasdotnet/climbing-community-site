<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:24:26
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>


<form:form method="POST"
           action="/spotSave" modelAttribute="spotForm">
    <form class="form-horizontal">


        <div class="row">

            <h2> Informations obligatoires</h2>

            <div class="form-group">
                <label for="spotName" class="col-sm-2 control-label">Nom</label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="spotName" value="${spotForm.spotName}"/>
                </div>
            </div>

            <div class="form-group">
                <label for="spotRate" class="col-sm-2 control-label">Difficulté</label>
                <div class="col-sm-10">
                    <form:input path="spotRate" class="form-control" type="text" value="${spotForm.spotRate}"/>
                </div>
            </div>
            <div class="form-group">
                <label for="departement" class="col-sm-2 control-label">Département</label>
                <div class="col-sm-10">
                    <form:input path="departement" class="form-control" type="text" value="${spotForm.departement}"/>
                </div>
            </div> 
            <div class="form-group">
                <label for="country" class="col-sm-2 control-label">Pays</label>
                <div class="col-sm-10">
                    <form:input path="country" class="form-control" type="text" value="${spotForm.country}"/>
                </div>
                <div class="col-sm-10">
                    <c:if test="${!empty error}"><span class="error">${error}</span></c:if> 
                </div>
            </div>
        </div>

        <div class="row">
            <h2>Informations complémentaires</h2>

            <div class="form-group">
                <label for="spotDescription" class="col-sm-2 control-label">Description</label>
                <div class="col-sm-10">
                    <form:input path="spotDescription" class="form-control" type="text" value="${spotForm.spotDescription}"/>
                </div>   
                <div class="form-group">
                    <label for="spotAccessPath" class="col-sm-2 control-label">Accès</label>
                    <div class="col-sm-10">
                        <form:input path="spotAccessPath" class="form-control" type="text" value="${spotForm.spotAccessPath}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="sectorCount" class="col-sm-2 control-label">Nombre de secteurs</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="sectorCount" value="${spotForm.sectorCount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="sectorDescription" class="col-sm-2 control-label">Descriptions secteurs</label>
                    <div class="col-sm-10">
                        <form:input path="sectorDescription" class="form-control" type="text" value="${spotForm.sectorDescription}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="routeCount" class="col-sm-2 control-label">Nombre de voies</label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="routeCount" value="${spotForm.routeCount}"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="routeDescription" class="col-sm-2 control-label">Description des voies</label>
                    <div class="col-sm-10">
                        <form:input path="routeDescription" class="form-control" type="text" value="${spotForm.routeDescription}"/>
                    </div>
                </div>

            </div>

            <div class="btn-group" role="group" aria-label="...">
                <a href="/spots" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Ajouter</button>
            </div>
    </form>
</form:form>             


<%@ include file="../common/footer.jsp" %>
