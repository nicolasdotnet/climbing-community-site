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
    <li><a href="/spot/${spotFind.spotId}">${spotFind.spotName}</a></li>
    <li class="active">Modifier</li>
</ol>
<h2>${spotFind.spotName}</h2>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>


<form:form method="POST"
           action="/user/spotUpdate" modelAttribute="spotFind">

    <form:hidden path="spotId"/>

    <form class="form-horizontal">

        <div class="row container">

            <h3 class="hidden-xs">Renseignements obligatoires</h3>

            <div class="panel panel-default t">
                <div class="panel-body">

                    <div class="form-group p">
                        <label for="spotName" class="col-sm-2 control-label">Nom</label>
                        <div class="col-sm-10">
                            <form:input class="form-control" path="spotName" value="${spotFind.spotName}"/>
                        </div>
                    </div>

                    <div class="form-group p">
                        <label for="spotRate" class="col-sm-2 control-label">Cotation</label>
                        <div class="col-sm-10">
                            <form:input path="spotRate" class="form-control" type="text" value="${spotFind.spotRate}"/>
                        </div>
                    </div>

                    <div class="form-group p">
                        <label for="locations" class="col-sm-2 control-label">Lieu</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="location">
                                <c:forEach items="${locations}" var="l">
                                    <c:choose>
                                        <c:when test="${l == spotFind.location}">
                                            <option value="${l}" selected>${l}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${l}">${l}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                    <div class="form-group p">
                        <label for="countrys" class="col-sm-2 control-label">Pays</label>
                        <div class="col-sm-10">
                            <select class="form-control" name="country">

                                <c:forEach items="${countrys}" var="c">
                                    <c:choose>
                                        <c:when test="${c == spotFind.country}">
                                            <option value="${c}" selected>${c}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${c}">${c}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="row container">
            <h3 class="hidden-xs">Informations complémentaires</h3>

            <div class="panel panel-default">
                <div class="panel-body">

                    <div class="form-group p">
                        <label for="spotDescription" class="col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <form:textarea rows="5" path="spotDescription" class="form-control" type="text" value="${spotFind.spotDescription}"/>
                        </div>
                    </div>

                    <div class="form-group p">
                        <label for="spotAccessPath" class="col-sm-2 control-label">Chemin d'accès</label>
                        <div class="col-sm-10">
                            <form:textarea rows="2" path="spotAccessPath" class="form-control" type="text" value="${spotFind.spotAccessPath}"/>
                        </div>
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
