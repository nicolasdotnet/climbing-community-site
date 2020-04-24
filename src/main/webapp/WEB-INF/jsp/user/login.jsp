<%-- 
    Document   : login
    Created on : 17 avr. 2020, 09:39:40
    Author     : nicolasdotnet
--%>

<%@ include file="../common/header.jsp" %>
<form class="form-signin" method="post" action="/login">
    <h2 class="form-signin-heading">Authentification</h2>
    <p>
        <label for="username" class="sr-only">Identifiant</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Identifiant" required autofocus>
    </p>
    <p>
        <label for="password" class="sr-only">Mot de passe</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Mot de passe" required>
    </p>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>

<a class="btn btn-default" href="/signup" role="button">Créer un compte</a>

<%@ include file="../common/footer.jsp" %>
