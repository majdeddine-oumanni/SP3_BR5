<%@ page import="models.Utilisateur" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Entraîneur</title>
</head>
<body>
<h2>Ajouter un Entraîneur</h2>
<%
    Utilisateur utilisateur = request.setAttribute("utilisateur", utilisateur);
%>
<form action="entraineur" method="post">
    <input type="hidden" name="action" value="add">
    <label>Nom:</label>
    <input type="text" name="nom" required><br>
    <label>Specialité:</label>
    <input type="text" name="speciality" required><br>
    <button type="submit">Ajouter</button>
</form>
<a href="entraineur?action=list">Retour à la liste</a>
</body>
</html>
