<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<div class="row">
    <h1>${userFind.username}</h1>
    <c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
    <c:if test="${!empty error}"><span class="error">${error}</span></c:if> 

    <div>
        <img width="150" height="150" src="/getPhoto/<c:out value='${userFind.userId}'/>" alt=";)" class="img-thumbnail img-responsive">
    </div>
    <c:if test="${owner}">
        <spring:url value="/user/${userFind.userId}/upload" var="uploadUrl" />
        <form action="${uploadUrl}">
            <button class="btn btn-info" 
                    onclick="return confirm('Are you sure?')">Ajouter</button>
        </form>
    </c:if>
</div>

<div class="row">
    <h3>Descriptions : </h3>
    <div class="panel panel-default col-md-6">
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
    <c:if test="${owner}">
        <div class="panel panel-default col-md-6">
            <div class="panel-body">
                <spring:url value="/user/${userFind.userId}/delete" var="deleteUrl" /> 
                <spring:url value="/user/${userFind.userId}/update" var="updateUrl" />

                <form action="${updateUrl}">
                    <button class="btn btn-primary" 
                            onclick="return confirm('Are you sure?')">Modifier</button>
                </form>
                <form action="${deleteUrl}" method="POST">
                    <button class="btn btn-danger" 
                            onclick="return confirm('Are you sure?')">Supprimer</button>
                </form>
            </div>
        </div>
    </c:if>

</div>

<div> 
    <c:if test="${!owner}">
    <a href="/user/${userFind.userId}/owner">Topos</a>
    </c:if>

    <%@ include file="../common/footer.jsp" %>
