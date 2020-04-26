<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<h1>${topoFind.topoTitle}</h1>


<div class="row">
    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <div>
                <label>Titre</label>
                <p><c:out value="${topoFind.topoTitle}">Valeur par défaut</c:out></p>
            </div>
            <div>
                <div>
                    <label>Lieu</label>
                    <span><c:out value="${topoFind.topoArea}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Description</label>
                    <span><c:out value="${topoFind.topoDescription}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Status</label>
                    <c:choose>                
                        <c:when test = "${topoFind.topoStatus == true}">
                            <span>disponible </span>
                        </c:when>
                        <c:when test = "${topoFind.topoStatus == false}">
                            <span>indisponible </span>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <spring:url value="/user/topo/${topoFind.topoId}/delete" var="deleteUrl" /> 
            <spring:url value="/user/topo/${topoFind.topoId}/update" var="updateUrl" />
            <spring:url value="/user/topo/${topoFind.topoId}/booking" var="bookingUrl" />

            <c:if test="${!owner}">
                <c:choose>
                    <c:when test="${topoFind.booking == null}">
                        <form action="${bookingUrl}" method="POST">
                            <button class="btn btn-default" 
                                    onclick="return confirm('Are you sure?')">Réserver</button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default">Réservation impossible</button>
                    </c:otherwise>

                </c:choose>
            </c:if>

            <c:if test="${owner}">
                <form action="${updateUrl}">
                    <button class="btn btn-primary" 
                            onclick="return confirm('Are you sure?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger" 
                            onclick="return confirm('Are you sure?')">Supprimer</button>
                </form>
            </c:if>

        </div>
    </div>

    <c:if test="${!empty msg}"><span>${msg}</span></c:if> 
    <c:if test="${!empty error}"><span>${error}</span></c:if>

</div>

<%@ include file="../common/footer.jsp" %>