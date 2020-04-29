<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:45:35
    Author     : nicolasdotnet
--%>


<%@ include file="../common/header.jsp" %>

<c:if test="${!empty error}"><span>${error}</span></c:if>
<c:if test="${!empty msg}"><span>${msg}</span></c:if>

<%@ include file="search.jsp" %>

<table class="table table-striped">
    <tr>
        <th>Identifiant</th>
        <th>Pr�nom</th>
        <th>Nom</th>
        <th>Categorie</th>
        <th>Date de cr�ation</th>
        <th>Actions</th>
    </tr>

    <c:forEach items="${users}" var="u">

        <spring:url value="/user/${u.userId}" var="userUrl"/>
        <spring:url value="/admin/user/desactivate" var="desactivateUrl" />

        <tr>
            <td><a href="${userUrl}"><c:out value="${u.username}">Valeur par d�faut</c:out></a> </td>
            <td><c:out value="${u.firstname}">Valeur par d�faut</c:out> </td>
        <td><c:out value="${u.lastname}">Valeur par d�faut</c:out> </td>
        <td><c:out value="${u.role.roleName}">Valeur par d�faut</c:out> </td>
        <td><c:out value="${u.userDate}">Valeur par d�faut</c:out> </td>
        <td>
            <form action="${desactivateUrl}" method="POST">
                <input hidden name="id" value="${u.userId}"/>
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Desactiver</button>
            </form>
        </td>
        </tr>
    </c:forEach>
</table>

<%@ include file="../common/footer.jsp" %>
