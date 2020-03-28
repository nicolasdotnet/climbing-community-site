<%-- 
    Document   : login
    Created on : 4 mars 2020, 08:42:46
    Author     : nicolasdotnet
--%>
<%@ include file="header.jsp" %>

    <p><c:out value="Bonjour !" /></p>
    <p><c:out value="${user}">Valeur par défaut</c:out></p>

    
    <form:form method="POST"
               action="/test" modelAttribute="user2">
        <table>
            <tr>
                <td><form:label path="lastname">Name</form:label></td>
                <td><form:input path="lastname"/></td>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>
    
    <br>
        <p>Rechercher un site : </p>
    <%@ include file="spotsearch.jsp" %>

<%@ include file="footer.jsp" %>