<%--
  Created by IntelliJ IDEA.
  User: MAJDEDDINE OUMANNI
  Date: 3/13/2025
  Time: 1:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>

        body {
            background: linear-gradient(135deg, #2c3e50, #34495e);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .container {
            text-align: center;
        }
        .card {
            width: 250px;
            height: 250px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s;
            background: white;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        .card:hover {
            transform: scale(1.1);
        }
        .icon {
            font-size: 50px;
            margin-bottom: 10px;
            color: #2980b9;
        }
    </style>
</head>
<body>
<div class="container">
    <h2 class="text-white mb-4">bienvenue à Sport Flow</h2>
    <div class="d-flex justify-content-center gap-4">
        <a href="?action=session" class="text-decoration-none">
            <div class="card">
                <i class="fas fa-user-shield icon"></i>
                <h5>Session</h5>
            </div>
        </a>
        <a href="?action=membre" class="text-decoration-none">
            <div class="card">
                <i class="fas fa-user icon"></i>
                <h5>Member</h5>
            </div>
        </a>
        <a href="?action=entraineur" class="text-decoration-none">
            <div class="card">
                <i class="fas fa-dumbbell icon"></i>
                <h5>Entraineur</h5>
            </div>
        </a>
    </div>
</div>
</body>
</html>
