<%-- 
    Document   : askbookinglist
    Created on : 25 avr. 2020, 11:25:15
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb b">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li>Mes demandes de réservation</li>
</ol>

<c:if test="${!empty error}"><span>${error}</span></c:if>
<c:if test="${!empty msg}"><span>${msg}</span></c:if>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Id</th>
        <th>Statut de la réservation</th>
        <th>Demandeur</th>
        <th>Topo</th>
        <th>Statut du topo</th>
        <th class="hidden-xs">Actions</th>
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
                <td class="hidden-xs"><c:out value="${t.booking.bookingId}">Valeur par défaut</c:out></td>
                <td class="hidden-sm hidden-lg"><a href="${bookingUrl}"><c:out value="${t.booking.bookingId}">Valeur par défaut</c:out></a></td>
                <c:choose>                
                    <c:when test = "${t.booking.bookingStatus == true}">
                        <td>demande validée</td>
                    </c:when>
                    <c:when test = "${t.booking.bookingStatus == false}">
                        <td>demande en attente</td>
                    </c:when>
                </c:choose>
                <td><c:out value="${t.booking.bookingUser.username}">Valeur par défaut</c:out></td>
                <td><c:out value="${t.topoTitle}">Valeur par défaut</c:out></td>
                <c:choose>                
                    <c:when test = "${t.topoStatus == true}">
                        <td>réservation possible</td>
                    </c:when>
                    <c:when test = "${t.topoStatus == false}">
                        <td>réservation impossible</td>
                    </c:when>
                </c:choose>
                <td class="hidden-xs"> 

                <spring:url value="/user/booking/${t.booking.bookingId}/available" var="availableUrl"/>
                <spring:url value="/user/booking/${t.booking.bookingId}/validate" var="validateUrl"/> 

                <c:choose> 
                    <c:when test="${t.booking.bookingStatus}">
                        <form action="${availableUrl}" method="POST" class="x">
                            <button class="btn btn-primary" 
                                    onclick="return confirm('Êtes-vous sûr ?')">Refuser</button>
                        </form>
                    </c:when>
                    <c:when test="${!t.booking.bookingStatus}">
                        <form action="${validateUrl}" method="POST" class="x">
                            <button class="btn btn-primary" 
                                    onclick="return confirm('Êtes-vous sûr ?')">Valider</button>
                        </form>
                    </c:when>
                </c:choose> 

                <form action="${deleteUrl}" method="POST" class="x" >
                    <button class="btn btn-danger" 
                            onclick="return confirm('Êtes-vous sûr ?')">Annuler</button>
                </form>
                </td>
                </tr>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</table>

<%@ include file="../common/footer.jsp" %> 