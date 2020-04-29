<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/user/account">Mon compte</a></li>
    <li class="active">Les topos de ${userFind.username}</li>
</ol>

<div class="row container">
    <div>
        <img width="150" height="150" src="/getPhoto/<c:out value='${userFind.userId}'/>" alt="Ajouter votre photo !" class="img-thumbnail img-responsive">
    </div>
</div>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div class="col-sm-8">
            <h2>Vos informations :</h2> 
        </div>
        <div class="col-sm-4 hidden-xs">
            <c:if test="${owner}">
                <spring:url value="/user/delete" var="deleteUrl"/> 
                <spring:url value="/user/update" var="updateUrl"/>

                <a href="${updateUrl}" class="btn btn-primary x pull-right" role="button">Modifier</a>

                <form action="${deleteUrl}" method="POST" class="x pull-right">
                    <button class="btn btn-danger" 
                            onclick="return confirm('Are you sure?')">Supprimer</button>
                </form>
            </c:if>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-body">
            <div>
                <label>Date d'enregistrement</label>
                <span><c:out value="${userFind.userDate}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Membre</label>
                <span><c:out value="${userFind.role.roleName}">Valeur par défaut</c:out></span>
            </div>
            <div>
                <label>Email</label>
                <a href="mailto:${userFind.email}"><c:out value="${userFind.email}">Valeur par défaut</c:out></a>
            </div>
        </div>
    </div>
</div>

<c:if test="${!owner}">
    <ul class="nav navbar-nav">
        <li><a href="/user/${userFind.userId}/owner">Consulter les Topos de ${userFind.username}</a></li>
    </ul>
</c:if>


<c:if test="${owner}">
    <ul class="nav navbar-nav">
        <li><a href="/user/bookings/topos">Demande de réservations <span class="badge">14</span></a></li>
        <li><a href="/user/bookings">Mes réservations</a></li>
        <li><a href="/user/topos">Mes topos</a></li>
        <li><a href="/user/spots">Mes sites</a></li>
    </ul>
</c:if>

<div class="col-sm-3 hidden-sm hidden-lg">
    <c:if test="${owner}">
        <spring:url value="/user/delete" var="deleteUrl"/> 
        <spring:url value="/user/update" var="updateUrl"/>

        <a href="${updateUrl}" class="btn btn-primary x pull-right" role="button">Modifier</a>

        <form action="${deleteUrl}" method="POST" class="x pull-right">
            <button class="btn btn-danger" 
                    onclick="return confirm('Are you sure?')">Supprimer</button>
        </form>
    </c:if>
</div>


<%@ include file="../common/footer.jsp" %>
