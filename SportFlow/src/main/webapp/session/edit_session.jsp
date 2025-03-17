<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="models.Session, models.Membre, models.Entraineur, java.util.List" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Modifier Session</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h2 class="text-center mb-4">Modifier Session</h2>
  <%
    Session session = (Session) request.getAttribute("session");
    List<Membre> membres = (List<Membre>) request.getAttribute("membres");
    List<Entraineur> entraineurs = (List<Entraineur>) request.getAttribute("entraineurs");
  %>
  <form action="session?action=update" method="post" class="p-4 shadow rounded bg-light">
    <input type="hidden" name="id" value="<%= session.getId() %>">

    <div class="mb-3">
      <label class="form-label">Date:</label>
      <input type="date" name="date" class="form-control" value="<%= session.getDate() %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Heure:</label>
      <input type="time" name="time" class="form-control" value="<%= session.getTime() %>" required>
    </div>

    <div class="mb-3">
      <label class="form-label">Membre:</label>
      <select name="membre_id" class="form-select" required>
        <% for (Membre m : membres) { %>
        <option value="<%= m.getId() %>" <%= (session.getMembre().getId() == m.getId()) ? "selected" : "" %>>
          <%= m.getNom() %>
        </option>
        <% } %>
      </select>
    </div>

    <div class="mb-3">
      <label class="form-label">Entraîneur:</label>
      <select name="entraineur_id" class="form-select" required>
        <% for (Entraineur e : entraineurs) { %>
        <option value="<%= e.getId() %>" <%= (session.getEntraineur().getId() == e.getId()) ? "selected" : "" %>>
          <%= e.getNom() %>
        </option>
        <% } %>
      </select>
    </div>

    <div class="text-center">
      <button type="submit" class="btn btn-primary">Mettre à Jour</button>
      <a href="session?action=list" class="btn btn-secondary">Annuler</a>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
