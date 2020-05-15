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
            <li><a href="/user/topos">Mes topos</a></li>
        </c:when>
        <c:otherwise>
            <li><a href="/topos">Les topos</a></li>
        </c:otherwise>  
    </c:choose>
</ol>
<h2>${topoFind.topoTitle}</h2>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-8"><h3>Informations</h3></div>

        <div class="col-sm-4 hidden-xs">
            <spring:url value="/user/topo/${topoFind.topoId}/delete" var="deleteUrl" /> 
            <spring:url value="/user/topo/${topoFind.topoId}/update" var="updateUrl" />
            <spring:url value="/user/topo/${topoFind.topoId}/booking" var="bookingUrl" />

            <c:if test="${!owner}">
                <c:choose>
                    <c:when test="${topoFind.booking == null && topoFind.topoStatus == true}">
                        <form action="${bookingUrl}" method="POST">
                            <button class="btn btn-primary x pull-right " 
                                    onclick="return confirm('Êtes-vous sûr ?')">Demander une réservation</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-danger x pull-right">Réservation impossible</button>
                    </c:otherwise>

                </c:choose>
            </c:if>

            <c:if test="${owner}">
                <form action="${updateUrl}">
                    <button class="btn btn-primary x pull-right" 
                            onclick="return confirm('Êtes-vous sûr ?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger x pull-right" 
                            onclick="return confirm('Êtes-vous sûr ?')">Supprimer</button>
                </form>
            </c:if>
        </div>
    </div>
</div>

<div class="panel panel-default">
    <div class="panel-body">
        <div>
            <div>
                <label>Lieu : </label>
                <span><c:out value="${topoFind.location}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <label>Date de parution :</label>
                <span><fmt:formatDate pattern="dd/MM/yyyy" value="${topoFind.releaseDate}" /></span>
            </div>
            <div>
                <label>Propriétaire : </label>
                <span><c:out value="${topoFind.topoOwner.username}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <label>Status : </label>
                <c:choose>                
                    <c:when test = "${topoFind.topoStatus == true}">
                        <span>disponible </span>
                    </c:when>
                    <c:when test = "${topoFind.topoStatus == false}">
                        <span>indisponible </span>
                    </c:when>
                </c:choose>
            </div>
            <div>
                <label>Description : </label>
                <p><c:out value="${topoFind.topoDescription}">Valeur par défaut</c:out> </p>
            </div>
        </div>
    </div>
</div>

<div class="col-sm-3 visible-xs">
    <spring:url value="/user/topo/${topoFind.topoId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/topo/${topoFind.topoId}/update" var="updateUrl" />
    <spring:url value="/user/topo/${topoFind.topoId}/booking" var="bookingUrl" />

    <c:if test="${!owner}">
        <c:choose>
            <c:when test="${topoFind.booking == null && topoFind.topoStatus == true}">
                <form action="${bookingUrl}" method="POST">
                    <button class="btn btn-primary x pull-right" 
                            onclick="return confirm('Êtes-vous sûr ?')">Demander une réservation</button>
                </form>
            </c:when>
            <c:otherwise>
                <button class="btn btn-danger x pull-right">Réservation impossible</button>
            </c:otherwise>

        </c:choose>
    </c:if>

    <c:if test="${owner}">
        <form action="${updateUrl}">
            <button class="btn btn-primary x pull-right" 
                    onclick="return confirm('Êtes-vous sûr ?')">Modifier</button>
        </form>
        <form action="${deleteUrl}" method="POST">
            <button class="btn btn-danger x pull-right" 
                    onclick="return confirm('Êtes-vous sûr ?')">Supprimer</button>
        </form>
    </c:if>

</div>


<%@ include file="../common/footer.jsp" %>