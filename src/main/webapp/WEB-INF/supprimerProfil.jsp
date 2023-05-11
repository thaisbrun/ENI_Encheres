<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suppression profil</title>
</head>
<body style="background-color:#B6DFF6;">
<div class="container text-center">
<br>
<form name="supprimerForm" method="post" action="supprimerProfil">
<br>
<h3> Etes vous sûr de vouloir supprimer votre profil et de quitter notre plateforme ? (pseudo : ${user.pseudo})</h3>
<br>
<div class="mb-3">
    <p style="display:none;">No_utilisateur : ${user.no_utilisateur}</p>
      <button type="submit" class="btn btn-success">Supprimer</button>
    <button href="./" class="btn btn-warning">Annuler</button>
</div>
</form>
</div>
</body>
</html>