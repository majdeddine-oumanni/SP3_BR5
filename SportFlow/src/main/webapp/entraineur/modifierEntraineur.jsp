<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.Entraineur" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Entraîneur</title>
</head>
<body>
<h2>Modifier Entraîneur</h2>
<jsp:useBean id="entraineur" class="models.Entraineur" scope="request" />
<form action="entraineur" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%= entraineur.getId() %>">
    <label>Nom:</label>
    <input type="text" name="nom" value="<%= entraineur.getNom() %>" required><br>
    <label>Specialité:</label>
    <input type="text" name="speciality" value="<%= entraineur.getSpeciality() %>" required><br>
    <button type="submit">Mettre à jour</button>
</form>
<a href="entraineur?action=list">Retour à la liste</a>
</body>
</html>
