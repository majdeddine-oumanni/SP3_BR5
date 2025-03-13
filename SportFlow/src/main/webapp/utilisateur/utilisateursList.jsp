<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Utilisateur" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Utilisateurs</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        button, input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            cursor: pointer;
            margin-top: 10px;
        }
        button:hover, input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>Liste des Membres</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
    </tr>
    <%
        List<Utilisateur> membres = (List<Utilisateur>) request.getAttribute("membres");
        for (Utilisateur membre : membres) {
    %>
    <tr>
        <td><%= membre.getId() %></td>
        <td><%= membre.getNom() %></td>
    </tr>
    <%
        }
    %>
</table>

<h2>Liste des Entraîneurs</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Nom</th>
    </tr>
    <%
        List<Utilisateur> entraineurs = (List<Utilisateur>) request.getAttribute("entraineurs");
        for (Utilisateur entraineur : entraineurs) {
    %>
    <tr>
        <td><%= entraineur.getId() %></td>
        <td><%= entraineur.getNom() %></td>
    </tr>
    <%
        }
    %>
</table>

<h2>Ajouter un Utilisateur</h2>
<form action="UserServlet" method="post">
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required>

    <label for="type">Type:</label>
    <select id="type" name="type">
        <option value="membre">Membre</option>
        <option value="entraineur">Entraîneur</option>
    </select>

    <input type="submit" value="Ajouter">
</form>

</body>
</html>
