<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="./styles/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>
<% if(session.getAttribute("user") != null) { %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./"><img src="./img/enchere.jpg" width="40px;"> </a>
        </li>
      </ul>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./">Encheres</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="./vendreArticle">Vendre un article</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./afficherProfil">Mon profil</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./deconnexion">Deconnexion</a>
        </li>
      </ul>
      </div>
      </div>
      </nav>
      <%} else{ %>
      <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          ENI-Enchères
        </li>
      </ul>
      <form class="d-flex" role="search">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="./inscription">S'inscrire</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="./connexion">Se connecter</a>
        </li>
      </ul>
      </form>

    </div>
  </div>
</nav>     
<% } %>
</body>
</html>