<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Détails de nomArticle</title>
</head>
<body style="background-color:#B6DFF6;">
	<div class="container text-center" style="margin-top:25px">

		<h2>Détails de ${enchere.getArticle().getNomArticle()} </h2>
		<br>
	</div>
	<c:choose>
  	<c:when test="${not empty erreur }">
  		<div class="alert alert-danger" role="alert">
  			<c:out value="${erreur}"/>
  		</div>
  	</c:when>
  	</c:choose>
  	<form name="afficherEnchere" method="get" action="voirEnchere">
  			<div class="row">
    			<div class="col">
      				<img src="./img/image.jpg" class="img-fluid card-img-top" style="margin-left:50px;width:50%;"> 
    			</div>
    			<div class="col">
    			<br>
      				<h3>${enchere.getArticle().getNomArticle() }</h3>
      				<h4> Vendu par : ${enchere.getUtilisateur().getPseudo() }</h4>
      				<h4>${enchere.getArticle().getDescription() }</h4>
      				
      				<h4> Prix initial : ${enchere.getArticle().getMiseAPrix() }</h4>
      				<h4> Montant de la dernière enchère : ${enchere.getMontant_enchere() }</h4>
      				
      				<h3><i>Adresse de retrait : </i><h3>
      				<h4>Date de début de l'enchère: ${enchere.getArticle().getDate_debut_enchere() }</h4>
      				<h4>Date de fin de l'enchère: ${enchere.getArticle().getDate_fin_enchere() }</h4>
      				
      				<h4> Etat de la vente : ${enchere.getArticle().getEtatVente() }</h4>
    			</div>
    		</div>
  		</div>
	</form>
	<%if(session.getAttribute("user") != null) { %>
		<form name="payerEnchere" method="post" action="voirEnchere">
			<input name="no_utilisateur" value="${enchere.getUtilisateur().getNo_utilisateur()}" type="hidden">
			<input name="no_article" value="${enchere.getArticle().getNoArticle() }" type="hidden">
			<input name="user" value="${enchere.getArticle().getNoArticle() }" type="hidden">
			<input type="submit" style="width:100%; margin-top: 20px;margin-bottom: 50px;" class="btn btn-info rounded-pill btn-block" value="Edition">
		</form>
	<%}%>
</body>
</html>