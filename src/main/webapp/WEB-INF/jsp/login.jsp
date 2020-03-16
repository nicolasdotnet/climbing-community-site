<%-- 
    Document   : login
    Created on : 4 mars 2020, 08:42:46
    Author     : nicolasdotnet
--%>
<%@ include file="header.jsp" %>

    <p><c:out value="Bonjour !" /></p>

    <div class="starter-template">
        <h1>Spring Boot Web JSP Example</h1>
        <h2>Hello ${user}</h2>
    </div>

    <form:form method="POST"
               action="/test" modelAttribute="user2">
        <table>
            <tr>
                <td><form:label path="lastname">Name</form:label></td>
                <td><form:input path="lastname"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>

    <p><c:out value="${user2.lastname}">Valeur par défaut</c:out></p>

<%@ include file="footer.jsp" %>