<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:24:26
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>
<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li><a href="/user/spots">Mes sites</a></li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/spotSave" modelAttribute="spotForm">
    <form class="form-horizontal">
        <h3>Ajouter un site</h3>
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <div class="container">

                        <div class="form-group p">
                            <label for="spotName" class="col-sm-3 control-label">Nom du site</label>
                            <div class="col-sm-8">
                                <form:input class="form-control" path="spotName" value="${spotForm.spotName}"/>
                            </div>
                        </div>

                        <div class="form-group p">
                            <label for="spotRate" class="col-sm-3 control-label">Sa cotation</label>
                            <div class="col-sm-8">
                                <form:input path="spotRate" class="form-control" type="text" value="${spotForm.spotRate}"/>
                            </div>
                        </div>

                        <div class="form-group p">
                            <label for="locations" class="col-sm-3 control-label">Lieu</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="location">
                                    <option value="default"></option>
                                    <c:forEach items="${locations}" var="l">

                                        <option value="${l}">${l}</option>

                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                        <div class="form-group p">
                            <label for="countrys" class="col-sm-3 control-label">Pays</label>
                            <div class="col-sm-8">
                                <select class="form-control" name="country">
                                    <option value="default"></option>
                                    <c:forEach items="${countrys}" var="c">

                                        <option value="${c}">${c}</option>

                                    </c:forEach>
                                </select>
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>

        <h4>Informations complémentaires</h4>

        <div class="panel panel-default">
            <div class="panel-body">
                <div class="row">
                    <div class="container">
                        
                        <div class="form-group p">
                            <label for="spotDescription" class="col-sm-3 control-label">Description</label>
                            <div class="col-sm-8">
                                <form:textarea rows="5" path="spotDescription" class="form-control" type="text" value="${spotForm.spotDescription}"/>
                            </div> 
                        </div>
                        <div class="form-group p">
                            <label for="spotAccessPath" class="col-sm-3 control-label">Chemin d'accès</label>
                            <div class="col-sm-8">
                                <form:textarea rows="2" path="spotAccessPath" class="form-control" type="text" value="${spotForm.spotAccessPath}"/>
                            </div>
                        </div>
                    </div>
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
