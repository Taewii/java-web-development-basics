<%@ page import="metube.domain.entities.User" %>
<%@ page import="metube.domain.models.view.TubeHomeViewModel" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="templates/head.jsp"/>
</head>

<% User user = (User) request.getSession().getAttribute("user"); %>
<% List<TubeHomeViewModel> tubes = (List<TubeHomeViewModel>) request.getAttribute("tubes"); %>

<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="text-center mt-3">
        <h4 class="h4 text-info">Welcome, <%= user.getUsername() %>
        </h4>
    </div>
    <hr class="my-4">
    <div class="container">
        <% if (tubes != null && !tubes.isEmpty()) { %>
        <div class="d-flex justify-content-around flex-wrap">
            <% for (TubeHomeViewModel tube : tubes) { %>
            <div class="p-2 text-center">
                <a href="/details/<%= tube.getId()%>">
                    <img class="thumbnail" src="https://img.youtube.com/vi/<%= tube.getYoutubeId()%>/default.jpg" alt="thumbnail">
                </a>
                <p><%= tube.getTitle()%></p>
                <p><%= tube.getUploader().getUsername()%></p>
            </div>
            <% } %>
        </div>
        <% } else { %>
        <div class="text-center">
            <p>No tubes found. <a href="/upload">Upload tube.</a></p>
        </div>
        <% } %>
        <c:import url="templates/footer.jsp"/>
    </div>
</body>
</html>