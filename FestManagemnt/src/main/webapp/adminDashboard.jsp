<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .container {
        width: 50%;
        margin: auto;
        text-align: center;
    }
    .stat, .create-event {
        margin: 20px 0;
    }
    .create-event a {
        text-decoration: none;
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border-radius: 5px;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Welcome to Admin Dashboard</h1>
    <div class="stat">
        <p>Total Registered Users: ${totalUsers}</p>
    </div>
    <div class="create-event">
        <a href="eventcreationadmin.jsp">Create New Event</a>
    </div>
</div>
</body>
</html>
