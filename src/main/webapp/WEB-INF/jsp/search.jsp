<%-- 
    Document   : search
    Created on : 16 mars 2020, 09:51:59
    Author     : nicolasdotnet
--%>

<%@ include file="header.jsp" %>
<div>
    <form action="/searchSpot"> 
        <label for="Name">Nom</label>
        <input type="text" name="spotName"/><br>
                <label for="rate">Difficult�</label>
        <input type="text" name="spotRate"/><br>
                <label for="departement">D�partement</label>
        <input type="text" name="departement"/><br>
        <input type="submit" name="submit">
    </form>
</div>
<%@ include file="footer.jsp" %>
