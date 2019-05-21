<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <h1>${tube.getTitle()}</h1>
    <hr class="my-4">
    <p class="lead">${tube.getDescription()}</p>
    <hr class="my-4">
    <div class="row">
        <div class="col">
            <a href="${tube.getYoutubeLink()}" role="button">Link to Video</a>
        </div>
        <div class="col">
            <p>${tube.getUploader()}</p>
        </div>
    </div>
    <hr>
    <a href="/">Back to Home</a>
</t:layout>