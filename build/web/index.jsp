<%-- 
    Document   : index
    Created on : Oct 4, 2017, 8:46:36 PM
    Author     : 687159
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remember Me Login Page</title>
    </head>
    <body>
        <h1>Remember Me Login Page</h1>
            <form action = "login" method="post">
                Username: <input type="text" name="user"><br>
                Password: <input type="password" name="pass"><br>
                <input type="checkbox" name="remember"> Remember me
                <input type="submit" value="Submit">
            </form>
        ${wrongValues}
    </body>
</html>
