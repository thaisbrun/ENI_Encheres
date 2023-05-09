<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher un profil</title>
</head>
<body>
</br>

<div class="container text-center">
<div class="mb-3">
    <p>Pseudo : ${user.pseudo }</p>
</div>

<div class="mb-3">
    <p>Nom : ${user.nom }</p>
 </div>

<div class="mb-3">
    <p>Prénom : ${user.prenom}</p>
</div>
<div class="mb-3">
    <p>Email : ${user.email}</p>
</div>
<div class="mb-3">
    <p>Telephone : ${user.telephone}</p>
</div>
<div class="mb-3">
    <p>Rue : ${user.rue}</p>
</div>
<div class="mb-3">
    <p>Code Postal : ${user.codePostal}</p>
</div>
<div class="mb-3">
    <p>Ville : ${user.ville}</p>
</div>
<a href="./modifierProfil" class="btn btn-primary">Modifier mon profil</a>
</div>
</body>
</html>