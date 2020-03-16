<%-- 
    Document   : formSpot
    Created on : 12 mars 2020, 08:24:26
    Author     : nicolasdotnet
--%>


<%@ include file="header.jsp" %>

    <form:form method="POST"
               action="/spots" modelAttribute="spotForm">
        <table>
            <tr>
                <td><form:label path="spotName">Nom</form:label></td>
                <td><form:input path="spotName"/></td>
            </tr>
            <tr>
                <td><form:label path="spotRate">Difficulté</form:label></td>
                <td><form:input path="spotRate"/></td>
            </tr>
            <tr>
                <td><form:label path="spotDescription">Description</form:label></td>
                <td><form:input path="spotDescription"/></td>
            </tr>
            <tr>
                <td><form:label path="spotAccessPath">Accès</form:label></td>
                <td><form:input path="spotAccessPath"/></td>
            </tr>
            <tr>
                <td><form:label path="departement">département</form:label></td>
                <td><form:input path="departement"/></td>
            </tr>
            <tr>
                <td><form:label path="country">country</form:label></td>
                <td><form:input path="country"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form> 

<span>if error affiche error message</span> 

<%@ include file="footer.jsp" %>
