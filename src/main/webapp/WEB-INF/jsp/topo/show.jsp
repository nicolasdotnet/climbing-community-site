<%-- 
    Document   : show
    Created on : 14 mars 2020, 09:10:46
    Author     : nicolasdotnet
--%>
<%@ include file="../common/header.jsp" %>
<h1>${topoFind.topoTitle}</h1>
<h3>${topoFind.topoId}</h3>


<div class="row">
    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <div>
                <label>Site officiel des Amis</label>
                <span><c:out value="${topoFind.topoDate}">Valeur par défaut</c:out> </span>
            </div>
            <div>
                <div>
                    <label>Niveau</label>
                    <span><c:out value="${topoFind.topoArea}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Description</label>
                    <p><c:out value="${topoFind.topoTitle}">Valeur par défaut</c:out></p>
                </div>
                <div>
                    <label>Accès</label>
                    <span><c:out value="${topoFind.topoDescription}">Valeur par défaut</c:out> </span>
                </div>
                <div>
                    <label>Département</label>
                    <span><c:out value="${topoFind.topoStatus}">Valeur par défaut</c:out>  </span>
                </div>
            </div>
        </div>
    </div>

    <div class="panel panel-default col-md-6">
        <div class="panel-body">
            <spring:url value="/user/topo/${topoFind.topoId}/delete" var="deleteUrl" /> 
            <spring:url value="/user/topo/${topoFind.topoId}/update" var="updateUrl" />
            <spring:url value="/user/topo/${topoFind.topoId}/booking" var="bookingUrl" />
            
            <form action="${bookingUrl}" method="POST">
                <button class="btn btn-default" 
                        onclick="return confirm('Are you sure?')">Réserver</button>
            </form>
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

    <c:if test="${!empty msg}"><span>${msg}</span></c:if> 

</div>

<%@ include file="../common/footer.jsp" %>
