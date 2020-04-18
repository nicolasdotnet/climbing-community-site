<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<h1>${userFind.username}</h1>
<c:if test="${!empty msg}"><span class="msg">${msg}</span></c:if> 

<div class="row">
    <div>
        <label>Photo</label>
        
        <img width="100" height="100" src="/getPhoto/<c:out value='${userFind.userId}'/>">
        
    </div> 

    <spring:url value="/user/${userFind.userId}/upload" var="uploadUrl" />
    <form action="${uploadUrl}">
        <button class="btn btn-info" 
                onclick="return confirm('Are you sure?')">Ajouter</button>
    </form>
</div>

<div class="row">
    <h3>Descriptions : </h3>
    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <div>
                <label>Prénom</label>
                <span><c:out value="${userFind.firstname}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Non</label>
                    <span><c:out value="${userFind.lastname}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Identifiant</label>
                    <span><c:out value="${userFind.username}">Valeur par défaut</c:out>  </span>
                </div>
                <div>
                    <label>Mot de passe</label>
                    <span><c:out value="${userFind.password}">Valeur par défaut</c:out>  </span>
                </div>
                <div>
                    <label>Date d'enregistrement</label>
                    <span><c:out value="${userFind.userDate}">Valeur par défaut</c:out></span>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <spring:url value="/user/${userFind.userId}/delete" var="deleteUrl" /> 
            <spring:url value="/user/${userFind.userId}/update" var="updateUrl" />

            <form action="${updateUrl}">
                <button class="btn btn-primary" 
                        onclick="return confirm('Are you sure?')">Modifier</button>
            </form>
            <form action="${deleteUrl}" method="POST">
                <button class="btn btn-danger" 
                        onclick="return confirm('Are you sure?')">Supprimer</button>
            </form>
        </div>
    </div>

</div>

<div> 
    <spring:url value="/user/${userFind.userId}/comments" var="url" htmlEscape="true"/>

    <%@ include file="../common/footer.jsp" %>
