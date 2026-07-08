<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login | Lost & Found</title>
    <link rel="stylesheet" href="login.css">
    <script src="https://unpkg.com/typed.js@2.1.0/dist/typed.umd.js"></script>
</head>

<body>
<%
    String error = request.getParameter("error");
    if("invalid".equals(error)){
%>
    <script>
        alert("Invalid Email or Password");
    </script>
<%
    }
%>
    <nav class="navbar">
        <div class="nav-logo">
            <img src="L.png" alt="logo">
        </div>
    </nav>

    <main class="container">
        <div class="hero-text">
            <h1>WELCOME TO</h1>
            <h1 class="dynamic-text"><span id="typed-text"></span></h1>
            <h1>ITEM PORTAL</h1>
        </div>

        <div class="login-card">
            <h2>LOGIN</h2>
            <form action="login" method="post">
                <div class="input-group">
                    <label for="email">E-Mail</label>
                    <input type="email" id="email" name="email" placeholder="Enter Your E-Mail" required>
                </div>

                <div class="input-group">
                    <label for="password">Password</label>
                    <div class="password-wrapper">
                        <input type="password" id="password" name="password" placeholder="Enter your Password" required>
                        <span id="togglePassword" class="eye-icon">seen</span>
                    </div>
                    <div class="forgot-pass">
                        <a href="/forgot-password">Forgot Password?</a>
                    </div>
                </div>

                <button type="submit" class="login-submit">LOGIN</button>
            </form>

            <div class="login-footer">
                <p>Don't have an account? <a href="Signup.jsp">Sign Up</a></p>

            </div>
        </div>
    </main>

    <script>
        var typed = new Typed("#typed-text", {
            strings: ["LOST", "FOUND"],
            typeSpeed: 100,
            backSpeed: 60,
            loop: true,
            color: '#DE1819'
        });
    </script>
</body>

</html>



