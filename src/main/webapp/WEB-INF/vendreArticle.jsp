<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@include file="template/header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vendre un article</title>
</head>
<body style="background-color:#B6DFF6;">
<h1>Mise en vente d'un article</h1>
<div class="container">
<form name="venteform" method="post" action="vendreArticle">
<br>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nom de l'article : </label>
    <input type="text" class="form-control"  name="nom_article" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Description : </label>
    <input type="text" class="form-control"  name="description" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
      <label for="form-select" class="form-label">Catégorie : </label>
  <select name="categorie" class="form-select" aria-label="Default select example">
<c:forEach items="${listeCategories}" var="categorie">
  <option value="${categorie.numero}">${categorie.libelle}</option>
</c:forEach>
</select>
</div>
<div class="input-group mb-3">
  <label class="input-group-text" for="inputGroupFile01">Photo de l'article : </label>
  <input type="file" class="form-control" name="image" id="inputGroupFile01">
</div>
  <label class="form-label" for="exampleInputEmail1">Mise à prix : </label>
<input id="number" type="number" value="1" name="prix_initial">
<br>
<br>
<label for="meeting-time" class="form-label">Date de début d'enchère : </label>
<input type="datetime-local" id="meeting-time" name="date_debut_enchere" min="DateTime.Now()" max="2023-08-24T00:00">
<br>
<br>
<label for="meeting-time" class="form-label">Date de fin d'enchère : </label>
<input type="datetime-local" id="meeting-time" name="date_fin_enchere" min="2018-06-07T00:00" max="2023-08-24T00:00">
<br>
<br>
      <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Rue : </label>
    <input type="text" class="form-control"  name="rue" id="exampleInputEmail1" value="${user.rue }" aria-describedby="emailHelp">
  </div>
      <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Code Postal : </label>
    <input type="text" class="form-control"  name="code_postal" id="exampleInputEmail1" value="${user.codePostal }" aria-describedby="emailHelp">
  </div>
      <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Ville : </label>
    <input type="text" class="form-control"  name="ville" id="exampleInputEmail1" value="${user.ville }" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
<button type="submit" class="btn btn-primary">Enregistrer</button>
  <a href="./" class="btn btn-warning">Annuler</a>
  </div>   
  </form> 
  </div>   
</body>
</html>