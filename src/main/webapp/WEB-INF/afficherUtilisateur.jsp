<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profil de ${utilisateur.pseudo}</title>
</head>
<body style="background-color:#B6DFF6;">
<br>
<div class="container text-center">
<h1>Informations de profil</h1>
<br>
<div class="mb-3">
    <p><i>Pseudo : </i>${utilisateur.pseudo }</p>
</div>

<div class="mb-3">
    <p><i>Nom : </i>${utilisateur.nom }</p>
 </div>

<div class="mb-3">
    <p><i>Prénom : </i>${utilisateur.prenom}</p>
</div>
<div class="mb-3">
    <p><i>Email : </i>${utilisateur.email}</p>
</div>
<div class="mb-3">
    <p><i>Telephone : </i>${utilisateur.telephone}</p>
</div>
<div class="mb-3">
    <p><i>Rue : </i>${utilisateur.rue}</p>
</div>
<div class="mb-3">
    <p><i>Code Postal : </i>${utilisateur.codePostal}</p>
</div>
<div class="mb-3">
    <p><i>Ville : </i>${utilisateur.ville}</p>
</div>
</div>
</body>
</html>