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

<body>
<div class="container">
    <div class="jumbotron text-center">
        <h1>Create Tube!</h1>
        <hr class="my-2">

        <form class="form-group" action="#" method="POST">
            <label>Name
                <input type="text" name="title" class="form-control my-2">
            </label>
            <hr class="my-2">
            <label>Description
                <textarea cols="18" name="description" rows="3"
                          class="form-control my-2"></textarea>
            </label>
            <hr class="my-2">
            <label>Youtube Link
                <input type="text" name="youtube-link" class="form-control my-2">
            </label>
            <hr class="my-2">
            <label>Uploader
                <input type="text" name="uploader" class="form-control my-2">
            </label>
            <hr class="my-2">
            <button type="submit" class="btn btn-primary my-2">Create Tube</button>
            <div class="my-4">
                <a href="/">Back to Home</a>
            </div>
        </form>
    </div>

    <footer class="lead text-center">
        &copy; CopyRight Java Web Team 2019. All rights reserved.
    </footer>
</div>
</body>

</html>