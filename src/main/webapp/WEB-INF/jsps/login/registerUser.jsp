<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register User</title>
</head>
<body>
<pre>
<form action="registerUser" method="post">
    <h2>Registro de usuario</h2>
    First Name: <input type="text" name="firstName"/>
    Last Name: <input type="text" name="lastName"/>
    User Name: <input type="text" name="email"/>
    Password: <input type="password" name="password"/>
    Confirm Password: <input type="password" name="confirmPassword"/>
    <input type="submit" value="register"/>
</form>
</pre>

</body>
</html>