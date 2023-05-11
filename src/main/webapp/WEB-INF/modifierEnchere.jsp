<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification de l'enchere</title>
</head>
<body>
<div class="container text-center">
  <div class="row align-items-start">
  <form name="modificationEnchereForm" method="post" action="modifierEnchere">
<div class="col">
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Nom Article</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${enchere.getArticle().getNomArticle()}" name="nomArticle" id="exampleInputNom" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Description</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${enchere.getArticle().getDescription()}" name="descriptionArticle" id="exampleInputDescription" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date Debut Enchere</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${enchere.getArticle().getDate_debut_enchere()}" name="dateDebutArticle" id="exampleInputDebut" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date Fin Enchere</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${enchere.getArticle().getDate_fin_enchere()}" name="dateFinArticle" id="exampleInputFin" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Prix Initial</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${enchere.getArticle().getMiseAPrix()}" name="prixArticle" id="exampleInputPrix" aria-describedby="emailHelp">
</div>
</div>
<input name="no_article" value="${enchere.getArticle().getNoArticle()}" type="hidden">
<button type="submit" class="btn btn-primary">Enregistrer</button>
</form>
<a href="" class="btn btn-primary">Supprimer l'enchere</a>
</div>
</div>

</body>
</html>