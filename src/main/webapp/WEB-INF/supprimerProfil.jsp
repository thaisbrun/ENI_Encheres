<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Suppression profil</title>
</head>
<body>
<form name="supprimerForm" method="post" action="supprimerProfil">
<h2> Etes vous sûr de vouloir supprimer votre profil ? (pseudo : ${user.pseudo})</h2>
<div class="mb-3">

    <p>No_utilisateur : ${user.no_utilisateur}</p>
      <button type="submit" class="btn btn-success">Supprimer</button>
</div>
</form>
<div class="mb-3">
    <button href="./" class="btn btn-warning">Annuler</button>
</div>
</body>
</html>