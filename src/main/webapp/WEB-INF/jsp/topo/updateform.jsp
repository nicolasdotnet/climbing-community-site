<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

 <form:form method="POST"
               action="/topoUpdate" modelAttribute="topoFind">
        <table>
        
                <td hidden=""><form:input path="topoId" value="${sectorFind.sectorId}"/></td>
            <tr>
                <td><form:label path="topoTitle">Titre</form:label></td>
                <td><form:input path="topoTitle" value="${titleFind.topoTitle}"/></td>
            </tr>
            <tr>
                <td><form:label path="topoDescription">Difficulté</form:label></td>
                <td><form:input path="topoDescription" value="${topoFind.topoDescription}"/></td>
            </tr>
            <tr>
                <td><form:label path="topoStatus">Description</form:label></td>
                <td><form:input path="topoStatus" value="${topoFind.topoStatus}"/></td>
            </tr>
            <tr>
                <td><form:label path="topoArea">Accès</form:label></td>
                <td><form:input path="topoArea" value="${topoFind.topoArea}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Modifier"/></td>
            </tr>
        </table>
    </form:form> 

<c:if test="${!empty error}"><span>${error}</span></c:if> 

<%@ include file="../common/footer.jsp" %>
