<%@ page import="metube.domain.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<nav class="navbar navbar-expand-sm navbar-dark bg-color-dark">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand h4" href="/">MeTube&trade;</a>

    <% User user = (User) request.getSession().getAttribute("user"); %>

    <div class="collapse navbar-collapse justify-content-center row" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <% if (user == null) { %>
            <li class="nav-item active col-md-4">
                <a class="nav-link h5" href="/home">Home</a>
            </li>
            <li class="nav-item active col-md-4">
                <a class="nav-link h5" href="/login">Login</a>
            </li>
            <li class="nav-item active col-md-4">
                <a class="nav-link h5" href="/register">Register</a>
            </li>
            <% } else { %>
            <li class="nav-item active col-md-3">
                <a class="nav-link h5" href="/home">Home</a>
            </li>
            <li class="nav-item active col-md-3">
                <a class="nav-link h5" href="/profile">Profile</a>
            </li>
            <li class="nav-item active col-md-3">
                <a class="nav-link h5" href="/upload">Upload</a>
            </li>
            <li class="nav-item active col-md-3">
                <a class="nav-link h5" href="/logout">Logout</a>
            </li>
            <% } %>
        </ul>
    </div>
</nav>
<hr class="my-3"/>

