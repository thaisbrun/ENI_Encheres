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
    <p>Pseudo : ${utilisateur.pseudo }</p>
</div>

<div class="mb-3">
    <p>Nom : ${utilisateur.nom }</p>
 </div>

<div class="mb-3">
    <p>${utilisateur.prenom}</p>
</div>
<div class="mb-3">
    <p>Email : ${utilisateur.email}</p>
</div>
<div class="mb-3">
    <p>Telephone : ${utilisateur.telephone}</p>
</div>
<div class="mb-3">
    <p>Rue : ${utilisateur.rue}</p>
</div>
<div class="mb-3">
    <p>Code Postal : ${utilisateur.codePostal}</p>
</div>
<div class="mb-3">
    <p>Ville : ${utilisateur.ville}</p>
</div>
<a href="./modifierProfil" class="btn btn-primary">Modifier mon profil</a>
</div>
</body>
</html>