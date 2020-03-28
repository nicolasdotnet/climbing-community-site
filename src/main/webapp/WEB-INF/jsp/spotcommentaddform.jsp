<%-- 
    Document   : spotcommentaddform
    Created on : 23 mars 2020, 16:36:09
    Author     : nicolasdotnet
--%>

<%@ include file="header.jsp" %>

    <form:form method="POST"
               action="/spotcommentsave/${spotId}" modelAttribute="spotCommentForm">
        <table>
            <tr>
                <td><form:label path="commentBody">Commentaire</form:label></td>
                <td><form:input path="commentBody"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form> 

<span>if error affiche error message</span> 

<%@ include file="footer.jsp" %>

