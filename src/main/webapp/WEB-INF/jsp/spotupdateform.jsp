<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="header.jsp" %>

 <form:form method="POST"
               action="/spots/update" modelAttribute="spotFind">
        <table>
            <tr>
                <td><form:label path="spotName">Nom</form:label></td>
                <td><form:input path="spotName" value="${spotFind.spotName}"/></td>
            </tr>
            <tr>
                <td><form:label path="spotRate">Difficulté</form:label></td>
                <td><form:input path="spotRate" value="${spotFind.spotRate}"/></td>
            </tr>
            <tr>
                <td><form:label path="spotDescription">Description</form:label></td>
                <td><form:input path="spotDescription" value="${spotFind.spotDescription}"/></td>
            </tr>
            <tr>
                <td><form:label path="spotAccessPath">Accès</form:label></td>
                <td><form:input path="spotAccessPath" value="${spotFind.spotAccessPath}"/></td>
            </tr>
            <tr>
                <td><form:label path="departement">département</form:label></td>
                <td><form:input path="departement" value="${spotFind.departement}"/></td>
            </tr>
            <tr>
                <td><form:label path="country">country</form:label></td>
                <td><form:input path="country" value="${spotFind.country}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form> 

<%@ include file="footer.jsp" %>
