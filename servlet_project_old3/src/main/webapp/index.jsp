<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #f8f9fa, #dceefc);
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        text-align: center;
        background-color: #ffffff;
        padding: 40px 60px;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0,0,0,0.15);
    }

    h2 {
        color: #333;
        margin-bottom: 30px;
    }

    .btn {
        display: block;
        width: 200px;
        margin: 10px auto;
        padding: 12px 0;
        font-size: 16px;
        color: #fff;
        background-color: #4CAF50;
        border: none;
        border-radius: 8px;
        text-decoration: none;
        transition: 0.3s;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1);
    }

    .btn:hover {
        background-color: #45a049;
        transform: translateY(-2px);
        box-shadow: 0 6px 10px rgba(0,0,0,0.15);
    }

    a {
        color: white;
        text-decoration: none;
        display: block;
    }

    @media (max-width: 480px) {
        .container {
            width: 90%;
            padding: 30px 20px;
        }

        .btn {
            width: 100%;
        }
    }
</style>
</head>
<body>
<div class="container">
    <h2>Welcome to SERVLET</h2>
    <a class="btn" href="create.html">Signup</a>
    <a class="btn" href="login.html">Signin</a>
    <a class="btn" href="findbyid.html">Find By ID</a>
    <a class="btn" href="deletebyid.html">Delete By ID</a>
    <a class="btn" href="fall">Fetch All</a>
    <a class="btn" href="dall">Delete All</a>
</div>
</body>
</html>