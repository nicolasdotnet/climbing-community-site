<%-- 
    Document   : topolist
    Created on : 23 mars 2020, 19:44:38
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<spring:url value="/user/topo/add" var="url" htmlEscape="true"/>

<c:if test="${!empty error}"><span>${error}</span></c:if>
<c:if test="${!empty msg}"><span>${msg}</span></c:if>


<h1>Les topos de ${user.username}</h1>


<c:if test="${owner}">
    <div class="nav navbar-right">
        <a href="${url}" class="btn btn-default"> ajouter un topo</a>
    </div>
</c:if>

<table class="table table-striped">
    <tr>
        <th>Titre</th>
        <th>Lieu</th>
        <th>Statut</th>
        <th>Booking</th>
    </tr>

    <c:forEach items="${topos}" var="t">

        <spring:url value="/user/topo/${t.topoId}" var="topoUrl" />
        <spring:url value="/user/topo/${t.topoId}/delete" var="deleteUrl" /> 
        <spring:url value="/user/topo/${t.topoId}/update" var="updateUrl" />
        <spring:url value="/user/topo/${t.topoId}/booking" var="bookingUrl" />

        <tr>
            <td><a href="${topoUrl}"><c:out value="${t.topoTitle}">Valeur par défaut</c:out></a> </td>
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
        </tr>
    </c:forEach>
</table>

<a href="#" class="edit" title="edit"><span class="glyphicon glyphicon-search" aria-hidden="false" ></span></a>

<%@ include file="../common/footer.jsp" %>