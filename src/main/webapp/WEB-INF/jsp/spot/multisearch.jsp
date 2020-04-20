<%-- 
    Document   : search
    Created on : 16 mars 2020, 09:51:59
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>
<form class="form-horizontal" action="/spot/findSpots"> 
    <div class="form-group">
        <input class="form-control" type="text" name="spotRate" placeholder="Difficulté"/>
    </div>

    <div class="form-group">
        <input class="form-control" type="text" name="departement" placeholder="Département"/>
    </div>

    <div class="form-group">
        <input class="form-control" type="text" name="sectorCount" placeholder="Nombre de secteur"/>
    </div>
    <div class="form-group">
    <button type="submit" name="submit">Rechercher</button>
    </div>
</form>
<%@ include file="../common/footer.jsp" %>
