<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="WEB-INF/template/header.jsp" %>
<%@page import="bo.Enchere"%>

<!DOCTYPE html>
<html>
<body>
	<h1>Bienvenue</h1>
<br>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Filtres : </label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Le nom de l'article contient">
<button type="button" class="btn btn-primary">Rechercher</button>
</div>
<div class="mb-3">

<select class="form-select" aria-label="Default select example">
<c:forEach items="${listeCategories}" var="categorie">
  <option value="${categorie.numero }">${categorie.libelle}</option>
</c:forEach>
</select>
</div>
<c:forEach items="${listeEncheres}" var="enchere">
<p>${enchere.no_utilisateur}</p>
<p>${enchere.no_article }</p>
<p>${enchere.dateEnchere}</p>
<p>${enchere.montant_enchere}</p>
</c:forEach>
</body>
</html>