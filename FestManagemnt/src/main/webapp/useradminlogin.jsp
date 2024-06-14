<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
            width: 100%;
        }
        .navbar a {
            float: left;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .container {
            padding: 20px;
            width: 100%;
            max-width: 600px;
            display: flex; /* Added */
            justify-content: space-between; /* Added */
        }
        .login-container {
            background-color: #fff;
            padding: 40px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            width: 45%; /* Added */
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input[type="number"],
        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="navbar">
    <a href="home.jsp" onclick="showHome()">Home</a>
</div>

<div class="container">
    <!-- Admin Login -->
    <div class="login-container">
        <h2>Admin Login</h2> <!-- Added heading -->
        <form action="Adminlogin" method="post">
            Enter the ID: <input type="number" name="id">
            Enter the Password: <input type="password" name="password">
            <input type="submit" value="Login">
        </form>
        <a href="forgot.jsp">Forgot Password?</a> <!-- Added forgot password link -->
    </div>

    <!-- User Login -->
    <div class="login-container">
        <h2>User Login</h2> <!-- Added heading -->
        <form action="userloginJava" method="post">
            Email: <input type="email" name="email" required>
            Password: <input type="password" name="password" required>
            <input type="submit" value="Login">
        </form>
        <a href="userloginupdate.jsp">Forgot Password?</a> <!-- Added forgot password link -->
        <br> <!-- Added line break for spacing -->
        <a href="userregisterhtml.jsp">Register</a> <!-- Moved register link under forgot password -->
    </div>
</div>

</body>
</html>
