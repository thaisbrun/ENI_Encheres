<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="bo.Utilisateur"%>
    <%@include file="template/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher un profil</title>
</head>
<body>
</br>
<p>Pseudo : ${user.pseudo }
</br>
	Nom : ${user.nom }
</br>
	Pr�nom : ${user.prenom } 
</br>
	Email : ${user.email } 
</br>
    T�l�phone : ${user.telephone } 
</br>
    Rue : ${user.rue }
</br>
    Code Postal : ${user.codePostal } </p>

</body>
</html>