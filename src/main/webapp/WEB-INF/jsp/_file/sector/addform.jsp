<%-- 
    Document   : sectorform
    Created on : 17 mars 2020, 15:35:28
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

    <form:form method="POST"
               action="/sectorSave/${spotId}" modelAttribute="sectorForm">
        <table>
            <tr>
                <td><form:label path="sectorName">Nom</form:label></td>
                <td><form:input path="sectorName"/></td>
            </tr>
            <tr>
                <td><form:label path="sectorRate">Difficulté</form:label></td>
                <td><form:input path="sectorRate"/></td>
            </tr>
            <tr>
                <td><form:label path="sectorDescription">Description</form:label></td>
                <td><form:input path="sectorDescription"/></td>
            </tr>
            <tr>
                <td><form:label path="sectorAccessPath">Accès</form:label></td>
                <td><form:input path="sectorAccessPath"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form> 

<span>if error affiche error message</span> 

<%@ include file="../common/footer.jsp" %>
