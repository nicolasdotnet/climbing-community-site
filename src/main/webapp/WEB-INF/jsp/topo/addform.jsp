<%-- 
    Document   : sectorform
    Created on : 17 mars 2020, 15:35:28
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li><a href="/user/topos">Mes topos</a></li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/topoSave" modelAttribute="topoForm">
    <form class="form-horizontal">
        <h3>Ajouter un topo</h3>

        <div class="panel panel-default">
            <div class="panel-body">

                <div class="form-group p">
                    <label for="topoTitle" class="col-sm-4 control-label">Titre du topo</label>
                    <div class="col-sm-8">
                        <form:input class="form-control" path="topoTitle" autofocus="true" value="${topoForm.topoTitle}"/>
                        <form:errors path="topoTitle" class="error"/>
                    </div>
                </div>


                <div class="form-group p">
                    <label for="location" class="col-sm-4 control-label">Lieu</label>
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
                    <label for="releaseDate" class="col-sm-4 control-label">Date de parution</label>
                    <div class="col-sm-8">
                        <form:input type ="date" class="form-control" path="releaseDate"/>
                        <form:errors path="releaseDate" class="error"/>
                    </div>
                </div>

                <div class="form-group p">
                    <label for="topoDescription" class="col-sm-4 control-label">Description</label>
                    <div class="col-sm-8">
                        <form:textarea rows="5" class="form-control" path="topoDescription" value="${topoForm.topoDescription}"/>
                        <form:errors path="topoDescription" class="error"/>
                    </div>
                </div>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/topos" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-info">Ajouter</button>
        </div>
    </form>
</form:form>

<%@ include file="../common/footer.jsp" %>
