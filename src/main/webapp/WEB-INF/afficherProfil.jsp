<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon profil</title>
</head>
<body style="background-color:#B6DFF6;">
</br>
<div class="container text-center">
<h1>Mes informations de profil</h1>
<br>
<div class="mb-3">
    <p><i>Mon pseudo :</i> ${user.pseudo }</p>
</div>
<div class="mb-3">
    <p><i>Mon nom :</i> ${user.nom }</p>
 </div>

<div class="mb-3">
    <p><i>Mon prénom :</i> ${user.prenom}</p>
</div>
<div class="mb-3">
    <p><i>Mon email :</i> ${user.email}</p>
</div>
<div class="mb-3">
    <p><i>Mon numéro de téléphone :</i> ${user.telephone}</p>
</div>
<div class="mb-3">
    <p><i>Mon adresse :</i> ${user.rue} ${user.ville} ${user.codePostal}</p>
</div>
<br>
<a href="./modifierProfil" class="btn btn-primary">Modifier mon profil</a>
</div>
</body>
</html>