<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détails de nomArticle</title>
</head>
<body>
	<div class="container text-center" style="margin-top:25px">
		<h2>Détails de nomArticle</h2>
	</div>
	<c:choose>
  	<c:when test="${not empty erreur }">
  		<div class="alert alert-danger" role="alert">
  			<c:out value="${erreur}"/>
  		</div>
  	</c:when>
  	</c:choose>
  	<form name="afficherEnchere" method="get" action="voirEnchere">
  		<div class="container" style="margin:auto;">
  			<div class="row">
    			<div class="col">
      				<div class="bg-white rounded shadow-sm"><img src="https://bootstrapious.com/i/snippets/sn-gallery/img-1.jpg" alt="" class="img-fluid card-img-top" style="display: block; max-width:100%; height: auto;"> 
    			</div>
    			<div class="col">
      				<p>${enchere.getArticle().getNomArticle() }</p>
      				<p>${enchere.getUtilisateur().getPseudo() }</p>
      				<p>${enchere.getArticle().getDescription() }</p>
      				<p>Catégorie</p>
      				
      				<p>${enchere.getArticle().getMiseAPrix() }</p>
      				<p>${enchere.getMontant_enchere() }</p>
      				
      				<p>Adresse<p>
      				<p>${enchere.getArticle().getDate_debut_enchere() }</p>
      				<p>${enchere.getArticle().getDate_fin_enchere() }</p>
      				
      				<p>${enchere.getArticle().getEtatVente() }</p>
    			</div>
    		</div>
  		</div>
	</form>
	<%if(session.getAttribute("user") != null) { %>
	<form name="payerEnchere" method="post" action="voirEnchere">
			<input name="no_utilisateur" value="${enchere.getUtilisateur().getNo_utilisateur()}" type="hidden">
			<input name="no_article" value="${enchere.getArticle().getNoArticle() }" type="hidden">
			<input name="user" value="${enchere.getArticle().getNoArticle() }" type="hidden">
			<input type="submit" style="width:100%; margin-top: 20px;" class="btn btn-info rounded-pill btn-block" value="Enchérir">
	</form>
</body>
</html>