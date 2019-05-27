<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="text-center mb-3">
        <h1>Upload</h1>
    </div>
    <hr class="my-2">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="form-holder text-center">
                <form class="form-inline" action="/upload" method="POST">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="title">Title</label>
                            <div class="controls">
                                <input type="text" id="title" name="title" placeholder="" class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="author">Author</label>
                            <div class="controls">
                                <input type="text" id="author" name="author" placeholder=""
                                       class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="youtube-link">Youtube Link</label>
                            <div class="controls">
                                <input type="text" id="youtube-link" name="youtubeId" placeholder=""
                                       class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="description">Description</label>
                            <div class="controls">
                                <textarea id="description" name="description" placeholder=""
                                          class="input-xlarge" style="resize: none;" cols="75" rows="4"></textarea>
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <div class="controls">
                                <button class="btn btn-info">Upload</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>