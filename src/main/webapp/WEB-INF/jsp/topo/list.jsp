<%-- 
    Document   : topolist
    Created on : 23 mars 2020, 19:44:38
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>
<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li>Mes topos</li>
        </c:when>
        <c:when test="${user.username!= null && !owner}">
            <li><a href="/user/${user.userId}">Le compte de ${user.username}</a></li>
            <li>Ses topos</li>
        </c:when>
        <c:otherwise>
            <li>Les topos</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty error}"><span>${error}</span></c:if>
<c:if test="${!empty msg}"><span>${msg}</span></c:if>


<div class="row container">
    <c:if test="${owner}">
        <div class="col-sm-14 hidden-xs">
            <spring:url value="/user/topo/add" var="url"/>

            <form action="${url}">
                <button class="btn btn-primary x pull-right"
                        >ajouter un topo</button>
            </form>
        </div>
    </c:if>
</div>
<table class="table table-striped">
    <tr>
        <th>Titre</th>
        <th>Lieu</th>
        <th>Statut</th>
        <th>Booking</th>
    <c:if test="${!owner}">
        <th>Propriétaire</th>
    </c:if>
    <c:if test="${owner}">
        <th class="hidden-xs">Actions</th>
    </c:if>
</tr>

<c:forEach items="${topos}" var="t">

    <spring:url value="/user/topo/${t.topoId}" var="topoUrl" />
    <spring:url value="/user/topo/${t.topoId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/topo/${t.topoId}/update" var="updateUrl" />
    <spring:url value="/user/topo/${t.topoId}/booking" var="bookingUrl" />
    <spring:url value="/user/${t.topoOwner.userId}" var="userUrl" />

    <tr>
        <td><a href="${topoUrl}"><c:out value="${t.topoTitle}">Valeur par défaut</c:out></a></td>
        <td><c:out value="${t.topoArea}">Valeur par défaut</c:out> </td>
    <c:choose>                
        <c:when test = "${t.topoStatus == true}">
            <td>réservation possible</td>
        </c:when>
        <c:when test = "${t.topoStatus == false}">
            <td>réservation impossible</td>
        </c:when>
    </c:choose> 
    <c:choose>                
        <c:when test = "${t.booking.bookingStatus == true}">
            <td>demande validée</td>
        </c:when>
        <c:when test = "${t.booking.bookingStatus == false}">
            <td>demande en attente</td>
        </c:when>
        <c:otherwise>
            <td>pas de demande</td>
        </c:otherwise>
    </c:choose>
    <c:if test="${!owner}">
        <td><a href="${userUrl}"><c:out value="${t.topoOwner.username}">Valeur par défaut</c:out></a></td>
    </c:if>

    <c:if test="${owner}">
        <td class="hidden-xs">
            <form action="${updateUrl}">
                <button class="btn btn-primary x pull-right"
                        onclick="return confirm('Are you sure?')">Modifier</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right"
                        onclick="return confirm('Are you sure?')">Supprimer</button>
            </form>
        </td>
    </c:if>
    </tr>
</c:forEach>
</table>

<div>

    <ul class="nav nav-pills">

        <c:forEach items="${pages}" var="pa" varStatus="status">

            <spring:url value="/topos?page=${status.index}&size=${size}" var="pageUrl" />

            <li>
                <a href="${pageUrl}"> <c:out value="${status.index}"></c:out> </a>

            </li>

        </c:forEach>

    </ul>


</div>

<div class="col-sm-3 hidden-sm hidden-lg">
    <c:if test="${owner}">
        <spring:url value="/user/topo/add" var="url"/>

        <form action="${url}">
            <button class="btn btn-primary x pull-right"
                    >ajouter un topo</button>
        </form>
    </c:if>
</div>

<a href="#" class="edit" title="edit"><span class="glyphicon glyphicon-search" aria-hidden="false" ></span></a>

<%@ include file="../common/footer.jsp" %>