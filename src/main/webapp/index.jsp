<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="WEB-INF/template/header.jsp" %>
<%@page import="bo.Enchere"%>

<!DOCTYPE html>
<html>
<body>
	<h1>Bienvenue</h1>
<br>
<div class="container text-center">
<div class="row align-items-center">
<div class="col-6">
  <label for="exampleFormControlInput1" class="form-label">Filtres : </label>
  <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="Le nom de l'article contient">
  <br>
<select class="form-select" aria-label="Default select example">
<c:forEach items="${listeCategories}" var="categorie">
  <option value="${categorie.numero }">${categorie.libelle}</option>
</c:forEach>
</select>
</div>
<div class="col-6">
<button type="button" class="btn btn-primary btn-lg" style="margin-top:20px;">Rechercher</button>
</div>
</div>
</div>
<div class="container">
<c:forEach items="${listeEncheres}" var="enchere">
<p>${enchere.no_utilisateur}</p>
<p>${enchere.no_article }</p>
<p>${enchere.dateEnchere}</p>
<p>${enchere.montant_enchere}</p>
</c:forEach>

</body>
</html>