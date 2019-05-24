<%@ page import="metube.domain.entities.User" %>
<%@ page import="metube.domain.models.view.TubeProfileViewModel" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="templates/head.jsp"/>
</head>

<% User user = (User) request.getSession().getAttribute("user"); %>
<% List<TubeProfileViewModel> tubes = (List<TubeProfileViewModel>) request.getAttribute("tubes"); %>

<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="text-center mt-3">
        <h4 class="text-info text-center"><%= user.getUsername()%>
        </h4>
        <h4 class="text-info text-center"><%= user.getEmail()%>
        </h4>
    </div>
    <hr>
    <% if (tubes != null && !tubes.isEmpty()) { %>
    <div class="container-fluid">
        <div class="row d-flex flex-column">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (int i = 0; i < tubes.size(); i++) { %>
                <% TubeProfileViewModel tube = tubes.get(i); %>
                <tr>
                    <td><%= i + 1%></td>
                    <td><%= tube.getTitle()%></td>
                    <td><%= tube.getAuthor()%></td>
                    <td><a href="/details/<%= tube.getId()%>">Details</a></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <% } else { %>
    <p class="text-center">You don't have any videos. Would you like to <a href="/upload">upload</a> some?</p>
    <% } %>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>