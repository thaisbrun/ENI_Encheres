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
<div class="container" style="margin-top:50px">

<div class="row">
	<c:forEach items="${listeEncheres}" var="enchere">
	<div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="https://bootstrapious.com/i/snippets/sn-gallery/img-1.jpg" alt="" class="img-fluid card-img-top"> 
          <div class="p-4">
            <h5>${enchere.getArticle().getNomArticle() }</h5>
            <p class="small text-muted mb-0">${enchere.getArticle().getDescription() }</p>
            <p>${enchere.getMontant_enchere() }</p>
            <p>${enchere.getUtilisateur().getPseudo()}</p>
            <p class="small text-muted mb-0">Lorem ipsum dolor sit amet, consectetur adipisicing elit</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              <p style="color:red; weight:bold;">${enchere.getDateEnchere() }</p>
            </div>
          </div>
        </div>
      </div>
	</c:forEach>
</div>
</div>
</body>
</html>