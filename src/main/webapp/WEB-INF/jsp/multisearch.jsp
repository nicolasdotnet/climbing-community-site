<%-- 
    Document   : search
    Created on : 16 mars 2020, 09:51:59
    Author     : nicolasdotnet
--%>

<%@ include file="header.jsp" %>
<form class="form-horizontal" action="/findSpots"> 
    <div class="form-group">
        <label class="control-label " for="Name">Nom</label>
        <input class="form-control" type="text" name="spotName"/>
    </div>

    <div class="form-group">
        <label class="control-label " for="rate">Difficulté</label>
        <input class="form-control" type="text" name="spotRate"/>
    </div>

    <div class="form-group">
        <label  class="control-label " for="departement">Département</label>
        <input class="form-control" type="text" name="departement"/>
    </div>

    <div class="form-group">
        <label class="control-label " for="sector">Nombre de secteur</label>
        <input class="form-control" type="text" name="sector"/>
    </div>
    <input type="submit" name="submit">
</form>
<%@ include file="footer.jsp" %>
