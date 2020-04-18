<%-- 
    Document   : updateSpotForm
    Created on : 17 mars 2020, 12:18:11
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>

 <form:form method="POST"
               action="/commentUpdate" modelAttribute="spotCommentFind">
        <table>
        
                <td hidden=""><form:input path="commentId" value="${spotCommentFind.commentId}"/></td>
            <tr>
                <td><form:label path="commentBody">Commentaire</form:label></td>
                <td><form:input path="commentBody" value="${spotCommentFind.commentBody}"/></td>
            </tr>
                <td><input type="submit" value="Modifier"/></td>
            </tr>
        </table>
    </form:form> 
            
            <c:if test="${!empty error}"><span>${error}</span></c:if>

<%@ include file="../common/footer.jsp" %>
