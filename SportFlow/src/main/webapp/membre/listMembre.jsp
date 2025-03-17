<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, models.Membre" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Liste des Membres</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="text-center mb-4">Liste des Membres</h2>
    <a href="membre?action=add" class="btn btn-success mb-3">Ajouter un Membre</a>
    <table class="table table-bordered table-hover shadow-sm">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Date de Naissance</th>
            <th>Sport Pratiqué</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Membre> membres = (List<Membre>) request.getAttribute("membres");
            if (membres != null) {
                for (Membre m : membres) {
        %>
        <tr>
            <td><%= m.getId() %></td>
            <td><%= m.getNom() %></td>
            <td><%= m.getDateDeNaissance() %></td>
            <td><%= m.getSportPratique() %></td>
            <td>
                <a href="membre?action=edit&id=<%= m.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
                <a href="membre?action=delete&id=<%= m.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Voulez-vous supprimer ce membre ?');">Supprimer</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>
</body>
</html>
