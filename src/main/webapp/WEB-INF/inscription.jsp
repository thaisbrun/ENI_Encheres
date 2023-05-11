<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription utilisateur</title>
</head>
<body style="background-color:#B6DFF6;">
<div class="container text-center">
<h2>Mon profil</h2>
<br>
  <c:choose>
  	<c:when test="${not empty erreur }">
  		<div class="alert alert-danger" role="alert">
  			<c:out value="${erreur}"/>
  		</div>
  	</c:when>
  </c:choose>
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
    <a href="./" class="btn btn-warning">Annuler</a>
  </div>
    </div>
  </div>
</form>
</div>
</body>
</html>