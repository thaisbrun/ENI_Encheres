<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="WEB-INF/template/header.jsp" %>

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
  <option selected>Toutes</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>
</div>
<div class="bloc-zoneEnchere">
	<div class="zoneEnchere">
		<div class="row">
			<!--Galerie items -->
			<c:forEach var="current" items="${encheres }">
			<div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        		<div class="bg-white rounded shadow-sm"><img src="https://bootstrapious.com/i/snippets/sn-gallery/img-1.jpg" alt="" class="img-fluid card-img-top">
          			<div class="p-4">
            			<h5> <a href="#" class="text-dark">${current.getArticleVendu().getNomArticle()}</a></h5>
            			<p class="small text-muted mb-0">${current.getMontant_enchère()}</p>
            			<div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
              				<p class="small mb-0"><i class="fa fa-picture-o mr-2"></i><span class="font-weight-bold">${current.getArticleVendu().getDateDebutEncheres()}</span></p>
              				<div class="badge badge-danger px-3 rounded-pill font-weight-normal">${current.getUtilisateur().getPseudo()}</div>
            			</div>
          			</div>
        		</div>
      		</div>
      		<form name="profilForm" method="get" action="afficherProfil">
      		  <button type="submit" class="btn btn-primary">Submit</button>
      		  </form>
      		</c:forEach>
			<!-- End -->
		</div>
	</div>
</div>
</body>
</html>