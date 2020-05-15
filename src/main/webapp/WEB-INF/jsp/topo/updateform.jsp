<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li><a href="/user/topos">Mes topos</a></li>
    <li><a href="/user/topo/${topoFind.topoId}">${topoFind.topoTitle}</a></li>
    <li class="active">Modifier</li>
</ol>
<h2>${topoFind.topoTitle}</h2>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/topoUpdate" modelAttribute="topoFind">

    <form:hidden path="topoId"/>

    <form class="form-horizontal">
        <h3>Renseignements obligatoires</h3>

        <div class="panel panel-default">
            <div class="panel-body">

                <div class="form-group p">
                    <label for="topoTitle" class="col-sm-4 control-label">Titre du topo</label>
                    <div class="col-sm-8">
                        <form:input class="form-control" path="topoTitle" autofocus="true" value="${topoFind.topoTitle}" placeholder="Titre"/>
                        <form:errors path="topoTitle"/>
                    </div>
                </div>
                <div class="form-group p">
                    <label for="locations" class="col-sm-4 control-label">Lieu</label>
                    <div class="col-sm-8">
                        <select class="form-control" name="location">
                            <c:forEach items="${locations}" var="l">
                                <c:choose>
                                    <c:when test="${l == topoFind.location}">
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
                    <label for="releaseDate" class="col-sm-4 control-label">Date de parution</label>
                    <div class="col-sm-8">
                        <form:input type ="date" class="form-control" path="releaseDate"/>
                        <form:errors path="releaseDate" class="error"/>
                    </div>
                </div>
                <div class="form-group p">
                    <label for="topoStatus" class="col-sm-4 control-label">Je prête le topo</label>
                    <div class="col-sm-8">
                        <form:checkbox path="topoStatus" value="${topoFind.topoStatus}"/>
                        <form:errors path="topoStatus"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="topoDescription" class="col-sm-4 control-label">Description</label>
                    <div class="col-sm-8">
                        <form:textarea rows="5" class="form-control" path="topoDescription" value="${topoFind.topoDescription}" placeholder="Desciption"/>
                        <form:errors path="topoDescription"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/topo/${topoFind.topoId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div> 
    </form>
</form:form> 


<%@ include file="../common/footer.jsp" %>
