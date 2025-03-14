<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Utilisateur" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Utilisateurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        a{
            text-decoration: none;
            color: white;
        }
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .container {
            max-width: 1200px;
        }
        .table-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .table thead th {
            background-color: #007bff;
            color: white;
        }
        button {
            border: none;
            padding: 8px 12px;
            border-radius: 5px;
            cursor: pointer;
            background-color: #007bff;
            color: white;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 mb-3">
            <div class="table-container">
                <h2>Liste des Membres</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% List<Utilisateur> membres = (List<Utilisateur>) request.getAttribute("membres");
                        for (Utilisateur membre : membres) { %>
                    <tr>
                        <td><%= membre.getId() %></td>
                        <td><%= membre.getNom() %></td>
                        <td><button>Ajouter Membre</button></td>
                        <td><button type="button" class="btn btn-danger">
                            <a href="UserServlet?action=suprimer&&id=<%=membre.getId()%>">Suprimer</a>
                        </button></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col-md-6 mb-3">
            <div class="table-container">
                <h2>Liste des Entraîneurs</h2>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Action</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% List<Utilisateur> entraineurs = (List<Utilisateur>) request.getAttribute("entraineurs");
                        for (Utilisateur entraineur : entraineurs) { %>
                    <tr>
                        <td><%= entraineur.getId() %></td>
                        <td><%= entraineur.getNom() %></td>
                        <td><button>Ajouter Entraîneur</button></td>
                        <td><button type="button" class="btn btn-danger">
                            <a href="UserServlet?action=suprimer&&id=<%=entraineur.getId()%>">Suprimer</a>
                        </button></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="text-center mt-4">
        <a href="utilisateur/ajouter.jsp" class="btn btn-primary">Ajouter un utilisateur</a>
    </div>
</div>

</body>
</html>
