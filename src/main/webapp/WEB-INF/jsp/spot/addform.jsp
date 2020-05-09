<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:24:26
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>
<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/spots">Sites</a></li>
    <li class="active">Ajouter un site</li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/spotSave" modelAttribute="spotForm">
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
                <label for="locations" class="col-sm-2 control-label">Lieu</label>
                <div class="col-sm-10">
                    <select class="form-control" name="location">
                        <c:forEach items="${locations}" var="l">

                            <option value="${l}">${l}</option>

                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="countrys" class="col-sm-2 control-label">Pays</label>
                <div class="col-sm-10">
                    <select class="form-control" name="country">
                        <c:forEach items="${countrys}" var="c">

                            <option value="${c}">${c}</option>

                        </c:forEach>
                    </select>
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
            </div>

            <div class="btn-group" role="group" aria-label="...">
                <a href="/user/spots" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Ajouter</button>
            </div>
    </form>
</form:form>             


<%@ include file="../common/footer.jsp" %>
