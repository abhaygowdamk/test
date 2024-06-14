<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<title>Home</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
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
        }
        h1 {
            color: #4CAF50;
        }
        /* New style for the About content */
        #aboutContent {
            display: none;
        }
    </style>
    <script>
        function showHome() {
            window.location.reload();
        }

        function showAbout() {
            document.getElementById("homeContent").style.display = "none";
            document.getElementById("aboutContent").style.display = "block";
        }
    </script>
</head>
<body>
<div class="navbar">
        <a href="#" onclick="showHome()">Home</a>
        <a href="#" onclick="showAbout()">About</a>
        <a href="useradminlogin.jsp">Login</a>
    </div>
    <div class="container">
        <!-- Home Content -->
        <div id="homeContent">
            <h1>Welcome to Fest Management</h1>
            <p>This is the home page of the Fest Management system.</p>
        </div>
        <!-- About Content (Initially hidden) -->
        <div id="aboutContent">
            <h1>About Fest Management</h1>
            <p>This is where you can find information about the Fest Management system.</p>
        </div>
    </div>

</body>
</html>