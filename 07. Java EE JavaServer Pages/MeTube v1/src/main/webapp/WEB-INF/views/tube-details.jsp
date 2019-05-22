<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:layout>
    <c:choose>
        <c:when test="${tube == null}">
            <hr>
            <h1>Tube not found</h1>
            <hr>
            <a href="/">Back to Home</a>
        </c:when>
        <c:otherwise>
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
        </c:otherwise>
    </c:choose>
</t:layout>