<%-- 
    Document   : sectorform
    Created on : 17 mars 2020, 15:35:28
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

    <form:form method="POST"
               action="/user/topoSave" modelAttribute="topoForm">
        <table>
            <tr>
                <td><form:label path="topoTitle">Title</form:label></td>
                <td><form:input path="topoTitle"/></td>
            </tr>
            <tr>
                <td><form:label path="topoArea">Lieu</form:label></td>
                <td><form:input path="topoArea"/></td>
            </tr>
            <tr>
                <td><form:label path="topoDescription">Description</form:label></td>
                <td><form:input path="topoDescription"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Enregistrer"/></td>
            </tr>
        </table>
    </form:form> 

<c:if test="${!empty error}"><span>${error}</span></c:if> 

<%@ include file="../common/footer.jsp" %>
