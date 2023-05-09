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
<body>
<div class="container">
<br>
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Article</label>
    <input type="text" class="form-control"  name="nom_article" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
    <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Description</label>
    <input type="text" class="form-control"  name="description" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-3">
  <select class="form-select" aria-label="Default select example">
<c:forEach items="${listeCategories}" var="categorie">
  <option value="${categorie.numero }">${categorie.libelle}</option>
</c:forEach>
</select>
</div>
<div class="input-group mb-3">
  <label class="input-group-text" for="inputGroupFile01">Photo de l'article</label>
  <input type="file" class="form-control" id="inputGroupFile01">
</div>
      <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Rue</label>
    <input type="text" class="form-control"  name="rue" id="exampleInputEmail1" value="${utilisateur.rue }" aria-describedby="emailHelp">
  </div>
      <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Description</label>
    <input type="text" class="form-control"  name="code_postal" id="exampleInputEmail1" value="${utilisateur.codePostal }" aria-describedby="emailHelp">
  </div>
      <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Ville</label>
    <input type="text" class="form-control"  name="ville" id="exampleInputEmail1" value="${utilisateur.ville }" aria-describedby="emailHelp">
  </div>
  </div>
</body>
</html>