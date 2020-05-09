<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/allspots">Sites</a></li>
    <li><a href="/spot/+${spotFind.spotId}">${spotFind.spotName}</a></li>
    <li class="active">modifié</li>
</ol>

<h1>${spotFind.spotName}</h1>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>


<form:form method="POST"
           action="/user/spotUpdate" modelAttribute="spotFind">

    <form:hidden path="spotId"/>

    <form class="form-horizontal">
        <div class="panel panel-default">
            <div class="panel-body">

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
                    <label for="location" class="col-sm-2 control-label">Département</label>
                    <div class="col-sm-10">
                        <form:input path="location" class="form-control" type="text" value="${spotFind.location}"/>
                    </div>
                </div> 

                <div class="form-group">
                    <label for="country" class="col-sm-2 control-label">Pays</label>
                    <div class="col-sm-10">
                        <form:input path="country" class="form-control" type="text" value="${spotFind.country}"/>
                    </div>
                </div> 
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/spot/${spotFind.spotId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div>

    </form>   


</form:form> 

<%@ include file="../common/footer.jsp" %>
