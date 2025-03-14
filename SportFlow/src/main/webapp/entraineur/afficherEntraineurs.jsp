<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, models.Entraineur" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Entraîneurs</title>
</head>
<body>
<h2>Liste des Entraîneurs</h2>
<a href="EntraineurServlet?action=add">Ajouter un Entraîneur</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Spécialité</th>
        <th>Actions</th>
    </tr>
    <%
        List<Entraineur> entraineurs = (List<Entraineur>) request.getAttribute("entraineurs");
        if (entraineurs != null) {
            for (Entraineur e : entraineurs) {
    %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getNom() %></td>
        <td><%= e.getSpeciality() %></td>
        <td>
            <a href="entraineur?action=edit&id=<%= e.getId() %>">Modifier</a> |
            <a href="entraineur?action=delete&id=<%= e.getId() %>" onclick="return confirm('Voulez-vous supprimer cet entraîneur ?');">Supprimer</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
