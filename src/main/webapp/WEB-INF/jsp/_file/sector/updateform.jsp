<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

 <form:form method="POST"
               action="/sector/update" modelAttribute="sectorFind">
        <table>
        
                <td hidden=""><form:input path="sectorId" value="${sectorFind.sectorId}"/></td>
            <tr>
                <td><form:label path="sectorName">Nom</form:label></td>
                <td><form:input path="sectorName" value="${sectorFind.sectorName}"/></td>
            </tr>
            <tr>
                <td><form:label path="sectorRate">Difficulté</form:label></td>
                <td><form:input path="sectorRate" value="${sectorFind.sectorRate}"/></td>
            </tr>
            <tr>
                <td><form:label path="sectorDescription">Description</form:label></td>
                <td><form:input path="sectorDescription" value="${sectorFind.sectorDescription}"/></td>
            </tr>
            <tr>
                <td><form:label path="sectorAccessPath">Accès</form:label></td>
                <td><form:input path="sectorAccessPath" value="${sectorFind.sectorAccessPath}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form> 

<%@ include file="../common/footer.jsp" %>
