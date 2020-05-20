<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb b">
    <li><a href="/">Acceuil</a></li>
    <c:choose>
        <c:when test="${owner}">
            <li><a href="/user/account">Mon compte</a></li>
            <li class="active">Mes sites</li>
        </c:when>
        <c:otherwise>
            <li class="active">Les sites</li>
        </c:otherwise>  
    </c:choose>
</ol>

<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if>
<c:if test="${!empty error}"><span class="error">${error}</span></c:if>

<div class="row container">
    <div class="row vcenter">

        <c:if test="${!owner}">
            <div  class="col-sm-11">
                <%@ include file="multisearch.jsp" %> 
            </div>  
        </c:if>

        <secu:authorize access="isAuthenticated()">
            <c:if test="${!owner}"> 
                <div class="col-sm-1 hidden-xs">
                    <spring:url value="/user/spot/add" var="addUrl" />

                    <form action="${addUrl}">
                        <button class="btn btn-primary x pull-right"
                                >ajouter un site</button>
                    </form>
                </div>
            </c:if>
            <c:if test="${owner}">
                <div class="col-sm-12 hidden-xs">
                    <spring:url value="/user/spot/add" var="addUrl" />

                    <form action="${addUrl}" class=" x pull-right">
                        <button class="btn btn-primary"
                                >ajouter un site</button>
                    </form>
                </div>
            </c:if>
        </secu:authorize>
    </div>
</div>









<table class="table table-striped" style="margin-top: 10px">
    <tr>
        <th>Nom du site</th>
        <th>Cotation</th>
        <th>Lieu du site</th>
        <th>N° secteurs enregistré</th>
        <th class="hidden-xs">Officiel</th>
    <c:if test="${owner}">
        <th class="hidden-xs">Actions</th>
    </c:if>
</tr>

<c:forEach items="${spots}" var="s">

    <spring:url value="/spot/${s.spotId}" var="spotUrl" />
    <spring:url value="/user/spot/${s.spotId}/delete" var="deleteUrl" /> 
    <spring:url value="/user/spot/${s.spotId}/update" var="updateUrl" />
    <spring:url value="/sectors/${s.spotId}/spot" var="sectorsUrl" />
    <spring:url value="/components/${s.spotId}/spot" var="componentsUrl" />
    <spring:url value="/user/spot/${s.spotId}/comments/" var="commentsUrl" />

    <tr>
        <td><a href="${spotUrl}"><c:out value="${s.spotName}">Valeur par défaut</c:out></a> </td>
        <td><c:out value="${s.spotRate}">Valeur par défaut</c:out> </td>
    <td><c:out value="${s.location}">Valeur par défaut</c:out> </td>
    <td><c:out value="${s.sectorCount}">Valeur par défaut</c:out> </td>
    <td class="hidden-xs"><c:choose>                
        <c:when test = "${s.official == true}">
            <span>Oui</span>
        </c:when>
        <c:when test = "${s.official == false}">
            <span>Non</span>
        </c:when>
    </c:choose></td>
    <c:if test="${owner}">
        <td class="hidden-xs">
            <form action="${updateUrl}">
                <button class="btn btn-primary x pull-right"
                        onclick="return confirm('Êtes-vous sûr ?')"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right"
                        onclick="return confirm('Êtes-vous sûr ?')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
            </form>
        </td>
    </c:if>
    </tr>
</c:forEach>
</table>

<div>

    <ul class="nav nav-pills">
        <c:forEach items="${pages}" var="pa" varStatus="status">
            <spring:url value="/spots?page=${status.index}&size=${size}" var="pageUrl" />
            <li>
                <a href="${pageUrl}">
                    <c:choose>
                        <c:when test="${status.first && status.last}">                              
                        </c:when>
                        <c:otherwise> 
                            <c:out value="${status.count}"></c:out></a> 
                        </c:otherwise>
                    </c:choose>
            </li>
        </c:forEach>
    </ul>
    <secu:authorize access="isAuthenticated()">
        <div class="col-sm-3 visible-xs">
            <spring:url value="/user/spot/add" var="addUrl" />

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        >ajouter un site</button>
            </form>
        </div>
    </secu:authorize>

</div>

<%@ include file="../common/footer.jsp" %>
