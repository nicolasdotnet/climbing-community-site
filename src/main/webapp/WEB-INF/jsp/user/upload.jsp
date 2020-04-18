<%-- 
    Document   : register
    Created on : 14 avr. 2020, 10:06:25
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>

<form:form method="POST"
           action="/userUpload" enctype="multipart/form-data">
    <form class="form-horizontal">

        <div class="row">

            <h2>Select a file to upload</h2>
            <div class="form-group">
                <label for="profile" class="col-sm-2 control-label">Photo</label>
                <div class="col-sm-10">
                    <input name="profile" type="file"/>
                </div>
            </div>
            <span hidden><input name="id" value="${userFind.userId}"/></span>
            
            <div class="btn-group" role="group" aria-label="...">
                <a href="/users" id="cancel" name="cancel" class="btn btn-default">Annuler</a>
                <button type="submit" class="btn btn-info">Ajouter</button>
            </div>
    </form>
</form:form> 

        <c:if test="${!empty error}"><span>${error}</span></c:if> 

        <%@ include file="../common/footer.jsp" %>
        
        
        
        
        <div class="upload-content">
                <div class="single-upload">
                    <h3>Upload Single File</h3>
                    <form id="singleUploadForm" name="singleUploadForm">
                        <input id="singleFileUploadInput" type="file" name="file" class="file-input" required />
                        <button type="submit" class="primary submit-btn">Submit</button>
                    </form>
                    <div class="upload-response">
                        <div id="singleFileUploadError"></div>
                        <div id="singleFileUploadSuccess"></div>
                    </div>
                </div>
