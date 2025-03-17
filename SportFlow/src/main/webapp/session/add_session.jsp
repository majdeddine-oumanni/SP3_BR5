<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Ajouter une Session</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="mb-4">Ajouter une Session</h2>
<form action="session?action=add" method="post">
  <input type="hidden" name="action" value="add">

  <div class="mb-3">
    <label class="form-label">Date</label>
    <input type="date" name="date" class="form-control" required>
  </div>

  <div class="mb-3">
    <label class="form-label">Heure</label>
    <input type="time" name="time" class="form-control" required>
  </div>

  <div class="mb-3">
    <label class="form-label">ID Membre</label>
    <input type="number" name="membre_id" class="form-control" required>
  </div>

  <div class="mb-3">
    <label class="form-label">ID Entraîneur</label>
    <input type="number" name="entraineur_id" class="form-control" required>
  </div>

  <button type="submit" class="btn btn-primary">Ajouter</button>
  <a href="session?action=list" class="btn btn-secondary">Retour</a>
</form>
</body>
</html>
