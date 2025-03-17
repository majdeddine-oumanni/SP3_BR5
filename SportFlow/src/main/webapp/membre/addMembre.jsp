<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Ajouter un Membre</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
<div class="container mt-5">
  <h2 class="text-center mb-4">Ajouter un Membre</h2>
  <form action="membre?action=add" method="post" class="shadow p-4 bg-white rounded">
    <div class="mb-3">
      <label class="form-label">Nom</label>
      <input type="text" name="nom" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Date de Naissance</label>
      <input type="date" name="naissance" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Sport Pratiqué</label>
      <input type="text" name="sportPratique" class="form-control" required>
    </div>
    <div class="mb-3">
      <label class="form-label">Mot de passe</label>
      <input type="password" name="password" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-success">Ajouter</button>
    <a href="membre?action=list" class="btn btn-secondary">Annuler</a>
  </form>
</div>
</body>
</html>
