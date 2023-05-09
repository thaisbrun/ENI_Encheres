<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier mon profil</title>
</head>
<body>

<div class="container text-center">
  <div class="row align-items-start">
  <form name="modificationForm" method="post" action="modifierProfil">
<div class="col">
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Pseudo</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.pseudo}" name="pseudo" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Prénom</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.prenom}" name="prenom" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Telephone</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.telephone}" name="telephone" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Code Postal</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.codePostal}" name="codePostal" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mot de passe actuel </label>
    <input type="password" style="width:300px;margin-left:500px;" class="form-control" value="${user.motDePasse}" name="motDePasse" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nouveau mot de passe </label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" name="newMotDePasse" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
</div>
<div class="col">
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nom</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.nom}" name="nom" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>

<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.email}" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Rue</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.rue}" name="rue" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>

<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Ville</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.ville}" name="ville" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Confirmation </label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" name="confNewMotDePasse" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
</div>
<button type="submit" class="btn btn-primary">Enregistrer</button>
</form>
<a href="./supprimerProfil" class="btn btn-primary">Supprimer mon compte</a>
</div>
</div>

</body>
</html>