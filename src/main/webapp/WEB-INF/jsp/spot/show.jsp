<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<h1>${spotFind.spotName}</h1>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if> 

<h3>Descriptions : </h3>
<div class="row">
    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <div>
                <label>Site officiel des Amis</label>
                <span><c:out value="${spotFind.official}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Niveau</label>
                    <span><c:out value="${spotFind.spotRate}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Département</label>
                    <span><c:out value="${spotFind.departement}">Valeur par défaut</c:out>  </span>
                </div>
                <div>
                    <label>Pays</label>
                    <span><c:out value="${spotFind.country}">Valeur par défaut</c:out>  </span>
                </div>
                <div>
                    <label>Date d'enregistrement</label>
                    <span><c:out value="${spotFind.spotDate}">Valeur par défaut</c:out></span>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <spring:url value="/user/spot/${spotFind.spotId}/delete" var="deleteUrl" /> 
            <spring:url value="/user/spot/${spotFind.spotId}/update" var="updateUrl" />

            <form action="${updateUrl}">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Modifier</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Supprimer</button>
            </form>
        </div>
    </div>

</div>

<div> 
    <spring:url value="/user/spot/${spotFind.spotId}/comments" var="url" htmlEscape="true"/>

    <p><a href="${url}"> Consulter les commentaires</a></p>

</div>
    
    <h3>Informations complémentaires : </h3>
    <div class="panel panel-default">
        <div class="panel-body">
            <div>
                    <label>Description</label>
                    <p><c:out value="${spotFind.spotDescription}">Valeur par défaut</c:out></p>
                </div>
                <div>
                    <label>Accès</label>
                    <span><c:out value="${spotFind.spotAccessPath}">Valeur par défaut</c:out> </span>
                </div>
            <div>
                <label>Nombre de Secteurs : </label>
                <span><c:out value="${spotFind.sectorCount}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Description</label>
                    <p><c:out value="${spotFind.sectorDescription}">Valeur par défaut</c:out></p>
                </div>
                <div>
                    <label>Nombre de Voie : </label>
                    <span><c:out value="${spotFind.routeCount}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Description</label>
                    <p><c:out value="${spotFind.routeDescription}">Valeur par défaut</c:out></p>
                </div>
            </div>
        </div>
    </div>

<%@ include file="../common/footer.jsp" %>
