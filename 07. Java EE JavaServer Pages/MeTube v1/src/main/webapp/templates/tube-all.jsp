<%@ page import="metube.domain.models.view.TubeAllViewModel" %>
<%@ page import="java.util.List" %>
<!doctype html>
<html lang="en">

<head>
    <title>MeTube</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>

<% List<TubeAllViewModel> tubes = (List<TubeAllViewModel>) request.getAttribute("all-tubes"); %>

<body>
<div class="container">
    <div class="jumbotron text-center">
        <h1>All Tubes</h1>
        <hr>
        <% if (tubes.isEmpty()) { %>
        <p>No tubes - <a href="tube/create">Create some</a></p>
        <% } else { %>
        <p>Check out tubes below.</p>
        <hr>
        <div class="d-flex justify-content-center">
            <ul class="text-left">
                <% for (TubeAllViewModel tube : tubes) { %>
                <li><a href="<%= String.format("/tube/details?title=%s", tube.getTitle())%>"><%= tube.getTitle()%>
                </a></li>
                <% } %>
            </ul>
        </div>
        <% } %>
        <hr>

        <a href="/">Back to Home</a>
    </div>

    <footer class="lead text-center">
        &copy; CopyRight Java Web Team 2019. All rights reserved.
    </footer>
</div>
</body>

</html>