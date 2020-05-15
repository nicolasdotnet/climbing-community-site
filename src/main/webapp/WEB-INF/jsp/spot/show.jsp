<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li><a href="/user/spots">Mes sites</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/spots">Les sites</a></li>
        </c:otherwise>  
    </c:choose>
</ol>


<h2>${spotFind.spotName}</h2>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8 hidden-xs"><h3>Informations</h3></div>

        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/spot/${spotFind.spotId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/spot/${spotFind.spotId}/update" var="updateUrl" />

                <form action="${updateUrl}">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('�tes-vous s�r ?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right"
                            onclick="return confirm('�tes-vous s�r ?')">Supprimer</button>
                </form>
            </c:if>
            <secu:authorize access="hasAuthority('membre')">
                <spring:url value="/user/spotstatus/${spotFind.spotId}" var="updateStatusUrl" />
                <form action="${updateStatusUrl}" method="POST">
                    <button class="btn btn-primary x pull-right"
                            onclick="return confirm('�tes-vous s�r ?')">${spotFind.official ? "non officiel" : "officiel" }</button>
                </form>
            </secu:authorize>
        </div>
    </div>
</div>

<div class="panel panel-default t">
    <div class="panel-body">
        <div>
            <label>Auteur :</label>
            <span><c:out value="${spotFind.spotAuthor.username}">Valeur par d�faut</c:out></span>
        </div>
        <div>
            <label>Date d'enregistrement :</label>
            <span><fmt:formatDate pattern="dd/MM/yyyy" value="${spotFind.spotDate}" /></span>
        </div>
        <div>
            <label>Site officiel des Amis : </label>
            <c:choose>                
                <c:when test = "${spotFind.official == true}">
                    <span>Oui</span>
                </c:when>
                <c:when test = "${spotFind.official == false}">
                    <span>Non</span>
                </c:when>
            </c:choose>
        </div>
        <div>
            <div>
                <label>Cotation :</label>
                <span><c:out value="${spotFind.spotRate}">Valeur par d�faut</c:out> </span>
            </div>
            <div>
                <label>Lieu du site :</label>
                <span><c:out value="${spotFind.location}">Valeur par d�faut</c:out>  </span>
            </div>
            <div>
                <label>Pays :</label>
                <span><c:out value="${spotFind.country}">Valeur par d�faut</c:out></span>
            </div>
        </div>
    </div>
</div>

<h3 class="hidden-xs">Informations compl�mentaires</h3>
<div class="panel panel-default">
    <div class="panel-body">
        <div>
            <label>Description :</label>
            <p><c:out value="${spotFind.spotDescription}">Valeur par d�faut</c:out></p>
        </div>
        <div>
            <label>Chemin d'acc�s :</label>
            <p><c:out value="${spotFind.spotAccessPath}">Valeur par d�faut</c:out> </p>
        </div>
        <div>
            <label>Nombre de Secteurs enregistr�s :</label>
            <span><c:out value="${spotFind.sectorCount}">Valeur par d�faut</c:out> </span>
        </div>
        <div>
            <div>
                <label>Nombre de Voies enregistr�es :</label>
                <span><c:out value="${spotFind.componentCount}">Valeur par d�faut</c:out> </span>
            </div>
        </div>
    </div>
</div>

<spring:url value="/spot/${spotFind.spotId}/comments" var="commentUrl"/>
<spring:url value="/user/spot/${spotFind.spotId}/sector/add" var="addUrl"/>  
<spring:url value="/spot/${spotFind.spotId}/sectors" var="sectorUrl"/>

<ul class="nav navbar-nav">
    <li><a href="${commentUrl}"> Consulter les commentaires</a></li>
    <li><a href="${sectorUrl}"> Consulter les secteurs du site</a></li>
</ul> 
<div class="col-sm-3 visible-xs">
    <c:if test="${owner}">
        <spring:url value="/user/spot/${spotFind.spotId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/spot/${spotFind.spotId}/update" var="updateUrl" />
        <form action="${updateUrl}">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('�tes-vous s�r ?')">Modifier</button>
        </form>
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right"
                    onclick="return confirm('�tes-vous s�r ?')">Supprimer</button>
        </form>
    </c:if>
    <secu:authorize access="hasAuthority('membre')">
        <spring:url value="/user/spotstatus/${spotFind.spotId}" var="updateStatusUrl" />
        <form action="${updateStatusUrl}" method="POST">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('�tes-vous s�r ?')">${spotFind.official ? "non officiel" : "officiel" }</button>
        </form>
    </secu:authorize>
</div>

<%@ include file="../common/footer.jsp" %>
