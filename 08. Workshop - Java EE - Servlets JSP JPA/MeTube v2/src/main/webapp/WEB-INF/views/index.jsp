<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="jumbotron">
        <p class="h1 display-3">Welcome to MeTube&trade;!</p>
        <p class="h3">The simplest, easiest to use, most comfortable Multimedia Application.</p>
        <hr class="my-3">
        <p><a href="/login">Login</a> if you have an account or <a href="/register">Register</a> now and start tubing.
        </p>
    </div>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>