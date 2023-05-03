<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link href="./styles/style.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">ENI-Enchères </a>
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
	<h1>Bienvenue</h1>
<br>
<div class="mb-3">
  <label for="exampleFormControlInput1" class="form-label">Filtres : </label>
  <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="Le nom de l'article contient">
<button type="button" class="btn btn-primary">Rechercher</button>
</div>
<div class="mb-3">
<select class="form-select" aria-label="Default select example">
  <option selected>Toutes</option>
  <option value="1">One</option>
  <option value="2">Two</option>
  <option value="3">Three</option>
</select>
</div>
</body>
</html>