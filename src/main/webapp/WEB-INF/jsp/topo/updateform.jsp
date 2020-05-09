<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/allspots">Sites</a></li>
    <li><a href="/topo/+${topoFind.topoId}">${topoFind.topoTitle}</a></li>
    <li class="active">modifié</li>
</ol>

<h1>${topoFind.topoTitle}</h1>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<form:form method="POST"
           action="/user/topoUpdate" modelAttribute="topoFind">

    <form:hidden path="topoId"/>
    
    <form class="form-horizontal">
        <h2> Informations obligatoires</h2>

        <div class="form-group">
            <label for="official" class="col-sm-2 control-label">Titre</label>
            <div class="col-sm-10">
                <form:input class="form-control" path="topoTitle" autofocus="true" value="${titleFind.topoTitle}" placeholder="Titre"/>
                <form:errors path="topoTitle"/>
            </div>
        </div>
        <div class="form-group">
            <label for="official" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
                <form:input class="form-control" path="topoDescription" value="${topoFind.topoDescription}" placeholder="Desciption"/>
                <form:errors path="topoDescription"/>
            </div>
        </div>

        <div class="form-group">
            <label for="official" class="col-sm-2 control-label">Accès</label>
            <div class="col-sm-10">
                <form:input class="form-control" path="topoArea" value="${topoFind.topoArea}" placeholder="Accès"/>
                <form:errors path="topoArea"/>
            </div>
        </div>

        <div class="form-group">
            <label for="official" class="col-sm-2 control-label">Statut du topo</label>
            <div class="col-sm-10">
                <form:checkbox path="topoStatus" value="${topoFind.topoStatus}"/>
                <form:errors path="topoStatus"/>
            </div>
        </div>

        <div class="btn-group" role="group" aria-label="...">
            <a href="/user/topo/${topoFind.topoId}" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
            <button type="submit" class="btn btn-danger">Modifier</button>
        </div> 
    </form>
</form:form> 


<%@ include file="../common/footer.jsp" %>
