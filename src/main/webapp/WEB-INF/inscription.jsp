
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription utilisateur</title>
<link href="./styles/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>
<div class="container text-center">
<h2>Mon profil</h2>
<br>
<form name="inscriptionForm" method="post" action="inscription">
  <div class="row align-items-start">
    <div class="col">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Pseudo</label>
    <input type="text" class="form-control"  name="pseudo" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Prénom</label>
    <input type="text" class="form-control"  name="prenom" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>  
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Telephone</label>
    <input type="text" class="form-control" name="telephone" id="exampleInputPassword1">
  </div>
  
      <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Code Postal</label>
    <input type="text" class="form-control" name="codePostal" id="exampleInputPassword1">
  </div>   
  
      <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
    <input type="password" class="form-control" name="motDePasse" id="exampleInputPassword1">
  </div>
  
  <div class="mb-3">
      <button type="submit" class="btn btn-success">Créer</button>
  </div>
  
  </div>
  <div class="col">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nom</label>
    <input type="text" class="form-control"  name="nom" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>  
 <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Email</label>
    <input type="email" class="form-control"  name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
    <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Rue</label>
    <input type="text" class="form-control" name="rue" id="exampleInputPassword1">
  </div> 
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Ville</label>
    <input type="text" class="form-control" name="ville" id="exampleInputPassword1">
  </div>
        <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Confirmation mot de passe</label>
    <input type="password" class="form-control" name="motDePasse2" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <button href="./" class="btn btn-warning">Annuler</button>
    </div>
    </div>
  </div>
</form>
</div>
</body>
</html>