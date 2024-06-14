<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Event</title>
<style>
    body {
        font-family: Arial, sans-serif;
    }
    .container {
        width: 50%;
        margin: auto;
        text-align: center;
    }
    .form-group {
        margin: 20px 0;
    }
    input[type="text"], input[type="date"], input[type="time"], input[type="number"] {
        padding: 10px;
        width: 100%;
        box-sizing: border-box;
    }
    input[type="submit"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Create Event</h1>
    <form action="CreateEventServlet" method="post">
    <div class="form-group">
            <label for="id">Event id:</label>
            <input type="text" id="id" name="id" required>
        </div>
        <div class="form-group">
            <label for="name">Event Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div class="form-group">
            <label for="date">Event Date:</label>
            <input type="date" id="date" name="date" required>
        </div>
        <div class="form-group">
            <label for="time">Event Time:</label>
            <input type="time" id="time" name="time" required>
        </div>
        <div class="form-group">
            <label for="venue">Event Venue:</label>
            <input type="text" id="venue" name="venue" required>
        </div>
        <div class="form-group">
            <label for="price">Event Price:</label>
            <input type="number" id="price" name="price" step="0.01" required>
        </div>
        <input type="submit" value="Create Event">
    </form>
</div>
</body>
</html>
