<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
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
  	<form name="afficherEnchere" method="get" action="voirEnchere">
  		<div class="container" style="margin:auto;">
  			<div class="row">
    			<div class="col">
      				<div class="bg-white rounded shadow-sm"><img src="https://bootstrapious.com/i/snippets/sn-gallery/img-1.jpg" alt="" class="img-fluid card-img-top" style="display: block; max-width:100%; height: auto;"> 
    			</div>
    			<div class="col">
      				<p>NomArticle</p>
      				<p>NomVendeur</p>
      				<p>DescriptionArticle</p>
      				<p>Catégorie</p>
      				
      				<p>MiseAPrixEnchere</p>
      				<p>MeilleurOffreEnchere</p>
      				
      				<p>AdresseRetrait<p>
      				<p>DateDebutEnchere</p>
      				<p>DateFinEnchere</p>
      				
      				<p>EtatEnchere</p>
    			</div>
    		</div>
  		</div>
	</form>
</body>
</html>