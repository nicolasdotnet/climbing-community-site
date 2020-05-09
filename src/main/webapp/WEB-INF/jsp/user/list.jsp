<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>

<ol class="breadcrumb">
    <li><a href="/">Acceuil</a></li>
    <li><a href="/admin">Administrations</a></li>
    <li class="active">Membres</li>
</ol>

<c:if test="${!empty error}"><span>${error}</span></c:if>
<c:if test="${!empty msg}"><span>${msg}</span></c:if>

<div class="row container">
    <div class="row vcenter">
        <div  class="col-sm-10">
            <%@ include file="search.jsp" %> 
        </div>

        <secu:authorize access="hasAuthority('admin')">
            <div class="col-sm-2 hidden-xs">
                <spring:url value="/signup" var="addUrl" />

                <form action="${addUrl}">
                    <button class="btn btn-primary x pull-right"
                            >ajouter un menbre</button>
                </form>
            </div>
        </secu:authorize>
    </div>
</div>

<table class="table table-striped">
    <tr>
        <th>Identifiant</th>
        <th>Categorie</th>
        <th>Date de création</th>

    </tr>

    <c:forEach items="${users}" var="u">

        <spring:url value="/user/${u.userId}" var="userUrl"/>
        <spring:url value="/admin/user/desactivate" var="desactivateUrl" />

        <tr>
            <td><a href="${userUrl}"><c:out value="${u.username}">Valeur par défaut</c:out></a> </td>
            <td><c:out value="${u.role.roleName}">Valeur par défaut</c:out> </td>
        <td><c:out value="${u.userDate}">Valeur par défaut</c:out> </td>
        <td>
        </td>
        </tr>
    </c:forEach>
</table>

<div class="col-sm-3 hidden-sm hidden-lg">
    <secu:authorize access="hasAuthority('admin')">
        <spring:url value="/signup" var="addUrl" />

        <form action="${addUrl}">
            <button class="btn btn-primary x pull-right"
                    onclick="return confirm('Are you sure?')">ajouter un site</button>
        </form>
    </secu:authorize>
</div>

<%@ include file="../common/footer.jsp" %>
