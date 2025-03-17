<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter Entraîneur</title>
    <!-- Link to Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 50px;
        }
        .container {
            max-width: 600px;
        }
        .form-group {
            margin-bottom: 1.5rem;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">Ajouter un Entraîneur</h2>
    <form action="entraineur?action=add" method="post">
        <div class="form-group">
            <label for="nom">Nom:</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="speciality">Specialité:</label>
            <input type="text" class="form-control" id="speciality" name="speciality" required>
        </div>
        <div class="form-group">
            <label for="password">Mot de Passe:</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Ajouter</button>
    </form>
    <br>
    <a href="entraineur?action=list" class="btn btn-secondary btn-block">Retour à la liste</a>
</div>

<!-- Link to Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
