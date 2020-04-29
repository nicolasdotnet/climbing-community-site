<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<form:form method="POST"
           action="/userUpload" enctype="multipart/form-data">
            <div class="form-group">
                <label for="exampleInputFile">File input</label>
                    <input name="profile" type="file" required />
                    <p class="help-block">Example block-level help text here.</p>
                </div>
            <span hidden><input name="id" value="${userFind.userId}"/></span>

            <div class="btn-group" role="group" aria-label="...">
                <a href="/user/update" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Ajouter</button>
            </div>
</form:form> 

        <c:if test="${!empty error}"><span>${error}</span></c:if> 
        
        required="required"

        <%@ include file="../common/footer.jsp" %>