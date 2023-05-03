<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bo.Categorie" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Historique</title>

<%
	List<Categorie> listeCategories = (List<Categorie>) request.getAttribute("listeCategories");
%>
</head>
<body>
	<h1>Historique</h1>
	
	<table>
		<thead>
			<tr>
				<th>Date</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<br>
			<% for (Categorie categorie : listeCategories) { %>
				<tr>
					
							<p><%= categorie.getNumero() %></p>
				</tr>
				<tr>
							<p><%= categorie.getLibelle()%></p>
				</tr>
			<% } %>
		</tbody>
	</table>
	
	
	<a href="ajouter">Ajouter un nouveau repas</a>
	<a href="index.jsp">Retour à l'accueil</a>
</body>
</html>