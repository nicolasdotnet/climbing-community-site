<%-- 
    Document   : sector
    Created on : 17 mars 2020, 12:52:34
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Id</th>
        <th>Statut</th>
        <th>Demandeur</th>
        <th>Topo</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${bookings}" var="b">

        <spring:url value="/booking/${b.bookingId}" var="bookingUrl" />
        <spring:url value="/booking/${b.bookingId}/available" var="availableUrl" /> 
        <spring:url value="/booking/${b.bookingId}/validate" var="validateUrl" />
        <spring:url value="/booking/${b.bookingId}/cancel" var="deleteUrl" />

        <tr>
            <td><c:out value="${b.bookingDate}">Valeur par défaut</c:out> </td>
        <td><a href="${bookingUrl}"><c:out value="${b.bookingId}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${b.bookingStatus}">Valeur par défaut</c:out> </td>
        <td><c:out value="${b.bookingUser.firstname}">Valeur par défaut</c:out> </td>
        <td><c:out value="${b.bookingTopo.topoTitle}">Valeur par défaut</c:out> </td>

        <td>
            <form action="${validateUrl}" method="POST">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Valider</button>
            </form>
            <form action="${availableUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Refuser</button>
            </form>
                            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Supprimer</button>
            </form>
        </td>
        </tr>

    </c:forEach>
</table>

<%@ include file="../common/footer.jsp" %>