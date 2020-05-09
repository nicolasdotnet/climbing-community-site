<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
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
        <c:if test="${!owner}">
            <div  class="col-sm-10">
                <%@ include file="multisearch.jsp" %> 
            </div>
        </c:if>
        <c:if test="${owner}">
            <div class="col-sm-14 hidden-xs">
                <spring:url value="/user/spot/add" var="addUrl" />

                <form action="${addUrl}">
                    <button class="btn btn-primary x pull-right"
                            >ajouter un site</button>
                </form>
            </div>
        </c:if>
    </div>

<table class="table table-striped">
    <tr>
        <th>Name</th>
        <th>Rate</th>
        <th>Secteurs</th>
        <th>Officiel</th>
        <th>Lieu</th>
        <th>Pays</th>
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
    <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
    <td><c:out value="${s.official}">Valeur par défaut</c:out> </td>
    <td><c:out value="${s.location}">Valeur par défaut</c:out> </td>
    <td><c:out value="${s.country}">Valeur par défaut</c:out> </td>
    <c:if test="${owner}">
        <td class="hidden-xs">
            <form action="${updateUrl}">
                <button class="btn btn-primary x pull-right"
                        onclick="return confirm('Are you sure?')">Modifier</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger x pull-right"
                        onclick="return confirm('Are you sure?')">Supprimer</button>
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
                <a href="${pageUrl}"> <c:out value="${status.index}"></c:out> </a>

            </li>

        </c:forEach>

    </ul>

    <div class="col-sm-3 hidden-sm hidden-lg">
        <c:if test="${owner}">
            <spring:url value="/user/spot/add" var="addUrl" />

            <form action="${addUrl}">
                <button class="btn btn-primary x pull-right"
                        onclick="return confirm('Are you sure?')">ajouter un site</button>
            </form>
        </c:if>
    </div>


</div>

<%@ include file="../common/footer.jsp" %>
