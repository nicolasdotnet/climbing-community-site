<%-- 
    Document   : askbookinglist
    Created on : 25 avr. 2020, 11:25:15
    Author     : nicolasdotnet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<spring:url value="/user/topo/add" var="url" htmlEscape="true"/>

<c:if test="${!empty error}"><span>${error}</span></c:if>


<h1>Demande de réservation pour ${user.username}</h1>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Id</th>
        <th>Statut de la réservation</th>
        <th>Demandeur</th>
        <th>Topo</th>
        <th>Statut du topo</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${topos}" var="t">

        <spring:url value="/user/booking/${t.booking.bookingId}" var="bookingUrl" />
        <spring:url value="/user/booking/${t.booking.bookingId}/available" var="availableUrl" /> 
        <spring:url value="/user/booking/${t.booking.bookingId}/validate" var="validateUrl" />
        <spring:url value="/user/booking/${t.booking.bookingId}/cancel" var="deleteUrl" />
        <spring:url value="/user/${t.booking.bookingUser.userId}" var="userUrl" />

        <c:choose>                
            <c:when test = "${t.booking == null}"></c:when>
            <c:otherwise>
                <tr>
                    <td><c:out value="${t.booking.bookingDate}">Valeur par défaut</c:out></td>
                <td><a href="${bookingUrl}"><c:out value="${t.booking.bookingId}">Valeur par défaut</c:out></a></td>
                <c:choose>                
                    <c:when test = "${t.booking.bookingStatus == true}">
                        <td>demande validée</td>
                    </c:when>
                    <c:when test = "${t.booking.bookingStatus == false}">
                        <td>demande en attente</td>
                    </c:when>
                </c:choose>
                <td><a href="${userUrl}"><c:out value="${t.booking.bookingUser.username}">Valeur par défaut</c:out></a></td>
                <td><c:out value="${t.topoTitle}">Valeur par défaut</c:out></td>
                <c:choose>                
                    <c:when test = "${t.topoStatus == true}">
                        <td>réservation possible</td>
                    </c:when>
                    <c:when test = "${t.topoStatus == false}">
                        <td>réservation impossible</td>
                    </c:when>
                </c:choose>
                <td>    
                    <form class="x" action="${validateUrl}" method="POST">
                        <button class="btn btn-primary" 
                                onclick="return confirm('Are you sure?')">Valider</button>
                    </form>
                    <form class="x" action="${availableUrl}" method="POST">
                        <button class="btn btn-danger" 
                                onclick="return confirm('Are you sure?')">Refuser</button>
                    </form>
                    <form class="x" action="${deleteUrl}" method="POST">
                        <button class="btn btn-danger" 
                                onclick="return confirm('Are you sure?')">Annuler</button>
                    </form>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</table>

<a href="#" class="edit" title="edit"><span class="glyphicon glyphicon-search" aria-hidden="false" ></span></a>

<%@ include file="../common/footer.jsp" %> 