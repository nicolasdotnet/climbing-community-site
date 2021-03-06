<%-- 
    Document   : sector
    Created on : 17 mars 2020, 12:52:34
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb b">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/user/account">Mon compte</a></li>
    <li>Mes r�servations</li>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Id</th>
        <th>Statut de la r�servation</th>
        <th>Topo</th>
        <th>Contact</th>
    </tr>

    <c:forEach items="${bookings}" var="b">

        <spring:url value="/user/booking/${b.bookingId}" var="bookingUrl" />
        <spring:url value="/user/booking/${b.bookingId}/available" var="availableUrl" /> 
        <spring:url value="/user/booking/${b.bookingId}/validate" var="validateUrl" />
        <spring:url value="/user/booking/${b.bookingId}/cancel" var="deleteUrl" />
        <spring:url value="/user/${b.bookingTopo.topoOwner.userId}" var="userUrl" />

        <tr>
            <td><c:out value="${b.bookingDate}">Valeur par d�faut</c:out> </td>
        <td><a href="${bookingUrl}"><c:out value="${b.bookingId}">Valeur par d�faut</c:out></a></td>
        <c:choose>                
            <c:when test = "${b.bookingStatus == true}">
                <td>Demande valid�e</td>
            </c:when>
            <c:when test = "${b.bookingStatus == false}">
                <td>Votre demande est en attente</td>
            </c:when>
        </c:choose>
        <td><c:out value="${b.bookingTopo.topoTitle}">Valeur par d�faut</c:out> </td>
        <c:choose>
            <c:when test="${b.bookingStatus}">
                <td><a href="mailto:${b.bookingTopo.topoOwner.email}"><c:out value="${b.bookingTopo.topoOwner.email}">Valeur par d�faut</c:out></a></td>
            </c:when>
            <c:otherwise>
                <td><c:out value="${b.bookingTopo.topoOwner.username}">Valeur par d�faut</c:out></td>
            </c:otherwise>
        </c:choose>
        </tr>
    </c:forEach>
</table>

<%@ include file="../common/footer.jsp" %>