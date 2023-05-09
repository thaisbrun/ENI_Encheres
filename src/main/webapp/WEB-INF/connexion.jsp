<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion utilisateur</title>
<body>
<div class="container text-center">
<br>
<form name="connexionForm" method="post" action="connexion">    
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Pseudo</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control"  name="pseudo" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
    <input type="password" style="width:300px;margin-left:500px;" class="form-control" name="motDePasse" id="exampleInputPassword1">
  </div>
  <div class="row align-items-center">
   <div class="col">
  <button type="submit" class="btn btn-primary">Connexion</button>
  &nbsp;
   <input class="form-check-input" type="checkbox" id="flexSwitchCheckDefault">
  <label class="form-check-label" for="flexSwitchCheckDefault"> Se souvenir de moi</label>
    <p><a href='./motDePasse'>Mot de passe oublié </a></p> 
    </div>
    </div>
</br>      		  
</br>
</br>
<a href="./inscription" class="btn btn-outline-info btn-lg">Créer un compte</a>
      		 
</form>
</div>
</body>
</html>