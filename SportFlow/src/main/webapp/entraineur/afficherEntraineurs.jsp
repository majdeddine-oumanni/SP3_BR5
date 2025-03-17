<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, models.Entraineur" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liste des Entraîneurs</title>
    <!-- Link to Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
        }
        .container {
            max-width: 1200px;
        }
        table th, table td {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center">Liste des Entraîneurs</h2>
    <div class="mb-4">
        <a href="entraineur?action=add" class="btn btn-primary">Ajouter un Entraîneur</a>
    </div>
    <table class="table table-bordered table-striped table-hover">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Specialité</th>
            <th>Password</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Entraineur> entraineurs = (List<Entraineur>) request.getAttribute("entraineurs");
            if (entraineurs != null) {
                for (Entraineur e : entraineurs) {
        %>
        <tr>
            <td><%= e.getId() %></td>
            <td><%= e.getNom() %></td>
            <td><%= e.getSpeciality() %></td>
            <td><%= e.getPassword() %></td>
            <td>
                <a href="entraineur?action=edit&&id=<%= e.getId() %>" class="btn btn-warning btn-sm">Modifier</a> |
                <a href="entraineur?action=delete&&id=<%= e.getId() %>" onclick="return confirm('Voulez-vous supprimer cet entraîneur ?');" class="btn btn-danger btn-sm">Supprimer</a>
            </td>
        </tr>
        <%
                }
            }
        %>
        </tbody>
    </table>
</div>

<!-- Link to Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
