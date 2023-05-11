<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier mon profil</title>
</head>
<body style="background-color:#B6DFF6;">
<div class="container text-center">
  <form name="modificationForm" method="post" action="modifierProfil">
  <div class="row align-items-start">
<div class="col">
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon pseudo</label>
    <input type="text" class="form-control" value="${user.pseudo}" name="pseudo" id="exampleInputEmail1" aria-describedby="emailHelp">
</div> 
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon prénom</label>
    <input type="text" class="form-control" value="${user.prenom}" name="prenom" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon numéro de télephone</label>
    <input type="text" class="form-control" value="${user.telephone}" name="telephone" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon code Postal</label>
    <input type="text"  class="form-control" value="${user.codePostal}" name="codePostal" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon mot de passe actuel </label>
    <input type="password" class="form-control" value="${user.motDePasse}" name="motDePasse" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon nouveau mot de passe </label>
    <input type="text" class="form-control" name="newMotDePasse" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
<button type="submit" class="btn btn-primary">Enregistrer</button>
</div>
</div>
<div class="col">
 <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon nom</label>
    <input type="text" class="form-control" value="${user.nom}" name="nom" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Mon email</label>
    <input type="text" class="form-control" value="${user.email}" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Ma rue</label>
    <input type="text" class="form-control" value="${user.rue}" name="rue" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Ma ville</label>
    <input type="text" class="form-control" value="${user.ville}" name="ville" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<br>
<br>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Confirmation </label>
    <input type="text" class="form-control" name="confNewMotDePasse" id="exampleInputEmail1" aria-describedby="emailHelp">
</div> 
<br>
<div class="mb-3">
<a href="./supprimerProfil" class="btn btn-danger">Supprimer mon compte</a>
</div>
</div>
</div>
</form>
</div>
</body>
</html>