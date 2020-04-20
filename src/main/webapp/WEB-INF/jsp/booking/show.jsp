<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<h3>R�servation : </h3>
<div class="row">
    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <div>
                <label>N� de r�f�rence : </label>
                <span><c:out value="${bookingFind.bookingId}">Valeur par d�faut</c:out> </span>
            </div>
            <div>
                <label>Date</label>
                <span><c:out value="${bookingFind.bookingDate}">Valeur par d�faut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Statut</label>
                    <span><c:out value="${bookingFind.bookingStatus}">Valeur par d�faut</c:out> </span>
                </div>
                <div>
                    <label>Demandeur</label>
                    <span><c:out value="${bookingFind.bookingUser.username}">Valeur par d�faut</c:out></span>
                </div>
                <div>
                    <label>Titre du topo</label>
                    <span><c:out value="${bookingFind.bookingTopo.topoTitle}">Valeur par d�faut</c:out> </span>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <spring:url value="/user/booking/${bookingFind.bookingId}/cancel" var="deleteUrl"/> 

            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Annuler</button>
            </form>
        </div>
    </div>

</div>
<%@ include file="../common/footer.jsp" %>
