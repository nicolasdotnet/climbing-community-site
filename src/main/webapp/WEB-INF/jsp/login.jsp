<%-- 
    Document   : login
    Created on : 4 mars 2020, 08:42:46
    Author     : nicolasdotnet
--%>
<!DOCTYPE html>
<html lang="en">
    <head>

    </head>
    <body>

        <%@ include file="header.jsp" %>

        <div >

            <div>
                <h1>Spring Boot Web JSP Example</h1>
                <h2>Hello ${user}</h2>
            </div>

            <form method="post" action="test">

                <label for="nom">Nom : </label>
                <input type="text" name="${lastname}" id="nom" />

                <input type="submit"/>

            </form>

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

        </div>
        <%@ include file="footer.jsp" %>
    </body>

</html>
