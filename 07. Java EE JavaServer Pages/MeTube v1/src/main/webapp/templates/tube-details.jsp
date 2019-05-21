<%@ page import="metube.domain.models.view.TubeDetailsViewModel" %>
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

<% TubeDetailsViewModel tube = (TubeDetailsViewModel) (request.getAttribute("tube")); %>

<body>
<div class="container">
    <div class="jumbotron text-center">
        <h1><%= tube.getTitle() %>
        </h1>
        <hr class="my-4">
        <p class="lead"><%= tube.getDescription()%>
        </p>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <a href="<%= tube.getYoutubeLink()%>" role="button">Link to Video</a>
            </div>
            <div class="col">
                <p><%= tube.getUploader()%></p>
            </div>
        </div>
        <hr>
        <a href="/">Back to Home</a>
    </div>

    <footer class="lead text-center">
        &copy; CopyRight Java Web Team 2019. All rights reserved.
    </footer>
</div>
</body>

</html>