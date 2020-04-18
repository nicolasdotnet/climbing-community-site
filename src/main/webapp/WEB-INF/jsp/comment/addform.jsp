<%-- 
    Document   : spotcommentaddform
    Created on : 23 mars 2020, 16:36:09
    Author     : nicolasdotnet
--%>
    <form:form method="POST"
               action="/commentSave/${spotId}" modelAttribute="spotCommentForm">
        <table>
            <tr>
                <td><form:input path="commentBody" placeholder="Entrer un message"/></td>
                <td><input type="submit" value="Envoyer"/></td>
            </tr>
        </table>
    </form:form> 
