<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:layout>
    <h1>All Tubes</h1>
    <hr>
    <c:choose>
        <c:when test="${allTubes.isEmpty()}">
            <p>No tubes - <a href="/tube/create">Create some</a></p>
        </c:when>
        <c:otherwise>
            <p>Check out tubes below.</p>
            <hr>
            <div class="d-flex justify-content-center">
                <ul class="text-left">
                    <c:forEach items="${allTubes}" var="tube">
                        <li><a href="${String.format("/tube/details?title=%s", tube.getTitle())}">${tube.getTitle()}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </c:otherwise>
    </c:choose>
    <hr>

    <a href="/">Back to Home</a>
</t:layout>