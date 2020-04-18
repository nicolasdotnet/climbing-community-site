<%-- 
    Document   : sector
    Created on : 17 mars 2020, 12:52:34
    Author     : nicolasdotnet
--%>

<spring:url value="/components/${spotFind.spotId}/add" var="url" htmlEscape="true"/>

<p><a href="${url}"> ajouter un composant avec un spot</a></p>

<table class="table table-striped">
    <tr>
        <th>Date</th>
        <th>Name</th>
        <th>Rate</th>
        <th>Description</th>
        <th>Code</th>
         <th>Spot</th>
    </tr>
    
    <c:forEach items="${components}" var="c">
        <tr>
            <td><c:out value="${c.componentDate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.componentName}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.componentRate}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.componentDescription}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.componentCode}">Valeur par défaut</c:out> </td>
            <td><c:out value="${c.spot}">Valeur par défaut</c:out> </td>
            </tr>
            
            <td>
            <spring:url value="/component/${c.componentId}" var="componentUrl" />
            <spring:url value="/component/${c.componentId}/delete" var="deleteUrl" /> 
            <spring:url value="/component/${c.componentId}/update" var="updateUrl" />

            <form action="${componentUrl}">
                <button class="btn btn-info">Query</button>
            </form> 
            <form action="${updateUrl}">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Update</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Delete</button>
            </form>
        </td>
            
    </c:forEach>
</table>