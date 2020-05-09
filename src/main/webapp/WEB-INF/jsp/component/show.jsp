<%-- 
    Document   : snowsector
    Created on : 21 mars 2020, 08:55:41
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
            <li><a href="/sector/${componentFind.sector.sectorId}">${componentFind.sector.sectorName}</a></li>
            <li class="active">${componentFind.componentName}</li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
            <li><a href="/sector/${componentFind.sector.sectorId}">${componentFind.sector.sectorName}</a></li>
            <li class="active">${componentFind.componentName}</li>
        </c:otherwise>  
    </c:choose>
</ol>


<h1>${componentFind.componentName}</h1>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Descriptions : </h3></div>

        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/component/${componentFind.componentId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/component/${componentFind.componentId}/update" var="updateUrl" />

                <form action="${updateUrl}">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('Are you sure?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right"
                            onclick="return confirm('Are you sure?')">Supprimer</button>
                </form>
            </c:if>
        </div>
    </div>
</div>


<div class="panel panel-default">
    <div class="panel-body">
        <div>
            <label>Date</label>
            <span><c:out value="${componentFind.componentDate}">Valeur par défaut</c:out> </span>
        </div>
        <div>
            <div>
                <label>Nom du secteur</label>
                <span><c:out value="${componentFind.componentName}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <label>Niveau</label>
                <span><c:out value="${componentFind.componentRate}">Valeur par défaut</c:out>  </span>
            </div>
            <div>
                <label>Description</label>
                <span><c:out value="${componentFind.componentDescription}">Valeur par défaut</c:out>  </span>
            </div>
            <div>
                <label>Code</label>
                <span><c:out value="${componentFind.componentCode}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Catégorie</label>
                <span><c:out value="${componentFind.componentCategory.componentCategoryLabel}">Valeur par défaut</c:out></span>
            </div>
        </div>
    </div>
</div>

<ul class="nav navbar-nav">
    <c:choose>
        <c:when test="${spotFind.sectorCount >0}">
            <li><a href="${componentUrl}"> Consulter les composants du secteur</a></li>
            <c:if test="${owner}">
                <li><a href="${addUrl}"> Ajouter un autre composant au secteur</a></li>
            </c:if>
        </c:when>
        <c:otherwise> 
            <c:if test="${owner}">
                <li><a href="${addUrl}"> Ajouter un composant au secteur</a></li>
            </c:if>
        </c:otherwise>
    </c:choose>
</ul> 
<div class="col-sm-3 hidden-sm hidden-lg">
    <c:if test="${owner}">
        <spring:url value="/user/component/${componentFind.componentId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/component/${componentFind.componentId}/update" var="updateUrl" />
        <form action="${updateUrl}">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('Are you sure?')">Modifier</button>
        </form>
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right"
                    onclick="return confirm('Are you sure?')">Supprimer</button>
        </form>
    </c:if>
</div>

<%@ include file="../common/footer.jsp" %>
