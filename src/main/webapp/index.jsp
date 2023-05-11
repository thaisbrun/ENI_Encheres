<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="WEB-INF/template/header.jsp" %>
<%@page import="bo.Enchere"%>

<!DOCTYPE html>
<html>
<body>
	<h1>Bienvenue</h1>
<br>
<div class="container">
<div class="row align-items-center">
<form name="rechercheCategorieForm" method="get" action="rechercheCategorie">
<div class="col-6">
  <label for="exampleFormControlInput1" class="form-label">Filtres : </label>
  <input type="text" name="nom_article" class="form-control" id="exampleFormControlInput1" placeholder="Le nom de l'article contient">
  <br>
  <% if(session.getAttribute("user") != null) { %>
  <div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
  <label class="form-check-label" for="inlineRadio1">Achats</label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Enchères ouvertes
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Mes enchères
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" value="" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Mes enchères ouvertes
  </label>
</div>

<div class="form-check form-check-inline">
  <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
  <label class="form-check-label" for="inlineRadio2">Mes ventes</label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" name="ventesEnCours" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Mes ventes en cours
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="checkbox" name="ventesNonDebutees" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Mes ventes non débutées 
  </label>
</div>

<div class="form-check">
  <input class="form-check-input" type="checkbox" name="ventesTerminees" id="defaultCheck1">
  <label class="form-check-label" for="defaultCheck1">
    Mes ventes terminées
  </label>
</div>
<% } %>
<select name="categorie" class="form-select" aria-label="Default select example">
  <option value="0">Toutes</option>
<c:forEach items="${listeCategories}" var="categorie">
  <option value="${categorie.numero }">${categorie.libelle}</option>
</c:forEach>
</select>
</div>
<div class="col-6">
<button type="submit" class="btn btn-primary btn-lg" style="margin-top:20px;">Rechercher</button>
</div>
</form>
</div>
</div>
<div class="container" style="margin-top:50px">

<div class="row">
	<c:forEach items="${listeEncheres}" var="enchere">
	<div class="col-xl-3 col-lg-4 col-md-6 mb-4">
        <div class="bg-white rounded shadow-sm"><img src="https://bootstrapious.com/i/snippets/sn-gallery/img-1.jpg" alt="" class="img-fluid card-img-top"> 
          <div class="p-4">
            <h5>${enchere.getArticle().getNomArticle() }</h5>
            <p style=>Se termine le <strong>${enchere.getDateEnchere() }</strong></p>
            <form name="afficherUtilisateurForm" method="get" action="afficherUtilisateur">
           <input name="no_utilisateur" value="${enchere.getUtilisateur().getNo_utilisateur()}" style="display:none;">
           <button type="submit" class="btn btn-link"value="${enchere.getUtilisateur().getPseudo()}"><i class="bi bi-person-fill"></i>
           ${enchere.getUtilisateur().getPseudo()}</button>
           </form>
            <p class="small text-muted mb-0">${enchere.getArticle().getDescription() }</p>
            <div class="d-flex align-items-center justify-content-between rounded-pill bg-light px-3 py-2 mt-4">
            <c:choose>
            	<c:when test="${enchere.getArticle().getEtatVente().equals('VD')}">
            		<p style="color:red; weight:bold; margin: auto;"><strong>Vendu</strong></p>
            	</c:when>
            	<c:otherwise>
            		<p style="color:red; weight:bold; margin: auto;"><strong>${enchere.getMontant_enchere()} </strong> Pts</p>
            	</c:otherwise>
            </c:choose>
            </div>
            <% if(session.getAttribute("user") != null) { %>
            <form method="get" action="voirEnchere" name="afficherEnchereForm" >
            	<input name="no_utilisateur" value="${enchere.getUtilisateur().getNo_utilisateur()}" type="hidden">
            	<input name="no_article" value="${enchere.getArticle().getNoArticle()}" type="hidden">
            	<input type="submit" style="width:100%; margin-top: 20px;" class="btn btn-info rounded-pill btn-block" value="Détails">
            </form>
            <% } %>
          </div>
        </div>
      </div>
	</c:forEach>
</div>
</div>
</body>
</html>