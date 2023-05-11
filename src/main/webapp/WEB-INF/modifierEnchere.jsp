<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@include file="template/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification de l'enchere</title>
</head>
<body>
<div class="container text-center">
  <div class="row align-items-start">
  <form name="modificationForm" method="post" action="modifierProfil">
<div class="col">
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Pseudo</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${enchere.getUtilisateur().getPseudo()}" name="pseudo" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date Debut Enchere</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.prenom}" name="prenom" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Date Fin Enchere</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.prenom}" name="prenom" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
<div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Telephone</label>
    <input type="text" style="width:300px;margin-left:500px;" class="form-control" value="${user.telephone}" name="telephone" id="exampleInputEmail1" aria-describedby="emailHelp">
</div>
</div>
<button type="submit" class="btn btn-primary">Enregistrer</button>
</form>
<a href="" class="btn btn-primary">Supprimer l'enchere</a>
</div>
</div>

</body>
</html>