<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up | Lost & Found</title>
    <link rel="stylesheet" href="signup.css">
</head>

<body>

<nav class="navbar">
    <div class="nav-logo">
        <img src="L.png" alt="logo">
    </div>
</nav>

<main class="container">

    <div class="hero-text">
        <h1>JOIN THE</h1>
        <h1><span class="highlight">LOST & FOUND</span></h1>
        <h1>COMMUNITY</h1>
    </div>

    <div class="signup-card">
        <h2>SIGN UP</h2>

        <form action="signup" method="post">

            <div class="input-group">
                <label>Full Name</label>
                <input type="text" name="name" required>
            </div>

            <div class="input-group">
                <label>Email</label>
                <input type="email" name="email" required>
            </div>

            <div class="input-group">
                <label>Phone</label>
                <input type="number" name="phone" required>
            </div>

            <div class="input-group">
                <label>Student ID</label>
                <input type="text" name="studentId">
            </div>

            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" required>
            </div>

            <div class="input-group">
                <label>Confirm Password</label>
                <input type="password" name="confirmPassword" required>
            </div>

            <button type="submit" class="signup-btn">CREATE ACCOUNT</button>
        </form>

        <div class="footer">
            <p>Already have an account? <a href="Login.jsp">Login</a></p>
        </div>
    </div>

</main>

</body>
</html>