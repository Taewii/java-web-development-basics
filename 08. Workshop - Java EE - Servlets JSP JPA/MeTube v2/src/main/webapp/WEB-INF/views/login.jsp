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
        <h1>Login</h1>
    </div>
    <hr class="my-2">
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="form-holder text-center">
                <form class="form-inline" action="/login" method="POST">
                    <fieldset>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="username">Username</label>
                            <div class="controls">
                                <input type="text" id="username" name="username" placeholder="" class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <label class="control-label h3 mb-2" for="password">Password</label>
                            <div class="controls">
                                <input type="password" id="password" name="password" placeholder=""
                                       class="input-xlarge">
                            </div>
                        </div>
                        <br/>
                        <div class="control-group">
                            <div class="controls">
                                <button class="btn btn-info">Login</button>
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