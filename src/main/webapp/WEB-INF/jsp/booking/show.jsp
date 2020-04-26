<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<h3>Réservation : </h3>
<div class="row">
    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <div>
                <label>N° de référence : </label>
                <span><c:out value="${bookingFind.bookingId}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <label>Date</label>
                <span><c:out value="${bookingFind.bookingDate}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Statut</label>
                    <span><c:out value="${bookingFind.bookingStatus}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Demandeur</label>
                    <span><c:out value="${bookingFind.bookingUser.username}">Valeur par défaut</c:out></span>
                </div>
                <div>
                    <label>Titre du topo</label>
                    <span><c:out value="${bookingFind.bookingTopo.topoTitle}">Valeur par défaut</c:out> </span>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <spring:url value="/user/booking/${bookingFind.bookingId}/cancel" var="deleteUrl"/>
            <spring:url value="/user/booking/${bookingFind.bookingId}/available" var="availableUrl"/>
            <spring:url value="/user/booking/${bookingFind.bookingId}/validate" var="validateUrl"/> 
            
            <c:if test="${owner}">
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger" 
                            onclick="return confirm('Are you sure?')">Annuler</button>
                </form>
            </c:if>
            <c:choose> 
                <c:when test="${bookingFind.bookingStatus}">
                    <form action="${availableUrl}" method="POST">
                        <button class="btn btn-danger" 
                                onclick="return confirm('Are you sure?')">Refuser</button>
                    </form>
                </c:when>
                <c:when test="${!bookingFind.bookingStatus}">
                    <form action="${validateUrl}" method="POST">
                        <button class="btn btn-danger" 
                                onclick="return confirm('Are you sure?')">Valider</button>
                    </form>
                    </c:when>
            </c:choose> 
        </div>
    </div>

</div>
<%@ include file="../common/footer.jsp" %>
