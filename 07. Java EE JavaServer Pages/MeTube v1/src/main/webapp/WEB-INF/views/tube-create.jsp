<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <h1>Create Tube!</h1>
    <hr class="my-2">

    <form class="form-group" action="#" method="POST">
        <label>Name
            <input type="text" name="title" class="form-control my-2" minlength="1" required>
        </label>
        <hr class="my-2">
        <label>Description
            <textarea cols="18" name="description" rows="3" class="form-control my-2" minlength="1" required></textarea>
        </label>
        <hr class="my-2">
        <label>Youtube Link
            <input type="text" name="youtube-link" class="form-control my-2" minlength="1" required>
        </label>
        <hr class="my-2">
        <label>Uploader
            <input type="text" name="uploader" class="form-control my-2" minlength="1" required>
        </label>
        <hr class="my-2">
        <button type="submit" class="btn btn-primary my-2">Create Tube</button>
        <div class="my-4">
            <a href="/">Back to Home</a>
        </div>
    </form>
</t:layout>