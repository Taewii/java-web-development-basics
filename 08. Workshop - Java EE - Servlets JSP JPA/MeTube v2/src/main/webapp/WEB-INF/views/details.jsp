<%@ page import="metube.domain.models.view.TubeDetailsViewModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="templates/head.jsp"/>
</head>

<% TubeDetailsViewModel tube = (TubeDetailsViewModel) request.getAttribute("tube"); %>

<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="container-fluid">
        <% if (tube == null) { %>
        <h2 class="text-center">Tube with such ID doesn't exist.</h2>
        <% } else { %>
        <h2 class="text-center"><%= tube.getTitle()%>
        </h2>
        <div class="row">
            <div class="col-md-6 my-5">
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="https://www.youtube.com/embed/<%= tube.getYoutubeId()%>"
                            frameborder="0"
                            allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
                            allowfullscreen></iframe>
                </div>
            </div>
            <div class="col-md-6 my-5">
                <h1 class="text-center text-info"><%= tube.getAuthor()%>
                </h1>
                <h3 class="text-center text-info"><%= tube.getViews()%> Views</h3>
                <div class="h5 my-5 text-center"><%= tube.getDescription()%>
                </div>
            </div>
        </div>
        <% } %>
    </div>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>