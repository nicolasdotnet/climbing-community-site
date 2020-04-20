<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<form:form method="POST"
           action="/user/spotUpdate" modelAttribute="spotFind">

    <form:hidden path="spotId"/>

    <form class="form-horizontal">

        <div class="form-group">
            <label for="spotName" class="col-sm-2 control-label">Nom</label>
            <div class="col-sm-10">
                <form:input class="form-control" path="spotName" value="${spotFind.spotName}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="spotRate" class="col-sm-2 control-label">Difficulté</label>
            <div class="col-sm-10">
                <form:input path="spotRate" class="form-control" type="text" value="${spotFind.spotRate}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="spotDescription" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
                <form:input path="spotDescription" class="form-control" type="text" value="${spotFind.spotDescription}"/>
            </div>
        </div>

        <div class="form-group">
            <label for="spotAccessPath" class="col-sm-2 control-label">Accès</label>
            <div class="col-sm-10">
                <form:input path="spotAccessPath" class="form-control" type="text" value="${spotFind.spotAccessPath}"/>
            </div>
        </div> 

        <div class="form-group">
            <label for="departement" class="col-sm-2 control-label">Département</label>
            <div class="col-sm-10">
                <form:input path="departement" class="form-control" type="text" value="${spotFind.departement}"/>
            </div>
        </div> 

        <div class="form-group">
            <label for="country" class="col-sm-2 control-label">Pays</label>
            <div class="col-sm-10">
                <form:input path="country" class="form-control" type="text" value="${spotFind.country}"/>
            </div>
        </div> 
            
                    <div class="form-group">
            <label for="official" class="col-sm-2 control-label">Site offciel des Amis</label>
            <div class="col-sm-10">
                <form:checkbox path="official" class="form-control"/>
            </div>
        </div> 

        <div class="btn-group" role="group" aria-label="...">
             <a href="/spot/${spotFind.spotId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div>

    </form>   


</form:form> 
            
            <c:if test="${!empty error}"><span>${error}</span></c:if>

<%@ include file="../common/footer.jsp" %>
