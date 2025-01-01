<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register | E-Commerce</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles2.css" rel="stylesheet">

</head>
<body>

<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="form-container">
        <h2 class="text-center">Register</h2>
        
        <form action="register" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" class="form-control" name="username" id="name" placeholder="Enter your name" required>
            </div>
            <div class="form-group">
                <label for="email">Email address</label>
                <input type="email" class="form-control" name="email" id="email" placeholder="Enter your email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" required>
            </div>
            <input type="submit" value="register" class="btn btn-primary btn-block" name="register">
        </form>
        <p class="text-center mt-3">Already have an account? <a href="login.jsp">Login here</a></p>
    </div>
</div>

</body>
</html>
