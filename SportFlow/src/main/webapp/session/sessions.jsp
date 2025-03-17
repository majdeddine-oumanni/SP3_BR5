<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, models.Session" %>
<!DOCTYPE html>
<html>
<head>
  <title>Liste des Sessions</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="container mt-5">
<h2 class="text-center mb-4">Liste des Sessions</h2>
<a href="session?action=add" class="btn btn-primary mb-3">Ajouter une Session</a>
<table class="table table-bordered table-striped">
  <thead class="table-dark">
  <tr>
    <th>ID</th>
    <th>Date</th>
    <th>Heure</th>
    <th>Membre</th>
    <th>Entraîneur</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <% List<Session> sessions = (List<Session>) request.getAttribute("sessions");
    if (sessions != null) {
      for (Session s : sessions) { %>
  <tr>
    <td><%= s.getId() %></td>
    <td><%= s.getDate() %></td>
    <td><%= s.getTime() %></td>
    <td><%= s.getMembre().getNom() %></td>
    <td><%= s.getEntraineur().getNom() %></td>
    <td>
      <a href="session?action=edit&id=<%= s.getId() %>" class="btn btn-warning btn-sm">Modifier</a>
      <a href="session?action=delete&id=<%= s.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Voulez-vous supprimer cette session ?');">Supprimer</a>
    </td>
  </tr>
  <% } } %>
  </tbody>
</table>
</body>
</html>
