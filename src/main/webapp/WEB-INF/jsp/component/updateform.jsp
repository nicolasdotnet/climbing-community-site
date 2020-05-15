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
    <li><a href="/spot/${componentFind.sector.spot.spotId}">${componentFind.sector.spot.spotName}</a></li>
    <li><a href="/spot/${componentFind.sector.spot.spotId}/sectors">Secteurs de ${componentFind.sector.spot.spotName}</a></li>
    <li><a href="/sector/${componentFind.sector.sectorId}">${componentFind.sector.sectorName}</a></li>
    <li><a href="/sector/${componentFind.sector.sectorId}/components">Voie de ${componentFind.sector.sectorName}</a></li>
    <li><a href="/component/${componentFind.componentId}">${componentFind.componentName}</a></li>
    <li class="active">Modifier</li>
</ol>

<h2>${componentFind.componentName}</h2>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/component/update" modelAttribute="componentFind">

    <form:hidden path="componentId"/>

    <form class="form-horizontal">
        <div class="panel panel-default t">
            <div class="panel-body">

                <div class="form-group p">
                    <label for="componentName" class="col-sm-4 control-label">Nom de la voie</label>
                    <div class="col-sm-8">
                        <form:input path="componentName" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="componentCategory" class="col-sm-4 control-label">Catégorie</label>
                    <div class="col-sm-8">
                        <select class="form-control" name="componentCategory">
                            <c:forEach items="${componentCategorys}" var="c">
                                <c:choose>
                                    <c:when test="${c == componentFind.componentCategory}">
                                        <option value="${c.componentCategoryId}" selected>${c.componentCategoryLabel}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${c.componentCategoryId}">${c.componentCategoryLabel}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="componentHeight" class="col-sm-4 control-label">Hauteur</label>
                    <div class="col-sm-8">
                        <form:input path="componentHeight" class="form-control" type="text"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="componentRate" class="col-sm-4 control-label">Cotation</label>
                    <div class="col-sm-8">
                        <form:input path="componentRate" class="form-control" type="text"/>
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
                    <label for="componentCode" class="col-sm-4 control-label">Code du bloc</label>
                    <div class="col-sm-8">
                        <form:input path="componentCode" class="form-control" type="text"/>
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

        <div class="btn-group" role="group" aria-label="...">
            <a href="/component/${componentFind.componentId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div>

    </form>  
</form:form> 

<%@ include file="../common/footer.jsp" %>
