<%--
  Created by IntelliJ IDEA.
  User: MAJDEDDINE OUMANNI
  Date: 3/12/2025
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Login</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f8f9fa;
    }
    .login-container {
      background: white;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 400px;
    }
    .user-btn{
      margin-top: 4px;
      background-color: rgb(255, 0, 136);
      border: none;
    }
    .user-btn:hover{
      background-color: rgb(255, 0, 81);
    }
  </style>
</head>
<body>
<div class="login-container">
  <h3 class="text-center mb-4">Admin Login</h3>
  <form action="AdminLoginServlet" method="post">
    <div class="mb-3">
      <label for="name" class="form-label">Nom</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Mot de passe</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <button type="submit" class="btn btn-primary w-100">Se connecter</button>
  </form>
  <button class="btn btn-primary w-100 user-btn">ajouter un utilisateur</button>
</div>
</body>
</html>

