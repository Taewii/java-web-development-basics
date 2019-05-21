<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <h1>Welcome to MeTube!</h1>
    <hr class="my-4">
    <p class="lead">Cool app in beta version</p>
    <hr class="my-4">
    <div class="row">
        <div class="col">
            <a class="btn btn-primary btn-lg" href="tube/create" role="button">Create Tube</a>
        </div>
        <div class="col">
            <a class="btn btn-primary btn-lg" href="tube/all" role="button">All Tubes</a>
        </div>
    </div>
</t:layout>