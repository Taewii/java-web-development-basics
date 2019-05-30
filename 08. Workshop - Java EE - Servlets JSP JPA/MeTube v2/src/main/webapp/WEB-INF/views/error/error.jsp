<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="error-head.jsp"/>
</head>

<body>
<div class="container-fluid">
    <c:import url="../templates/header.jsp"/>
    <div class="error-content">
        <div class="container">
            <div class="row">
                <div class="col-md-12 ">
                    <div class="error-text">
                        <h1 class="error">${pageContext.errorData.statusCode} Error</h1>
                        <div class="im-sheep">
                            <div class="top">
                                <div class="body"></div>
                                <div class="head">
                                    <div class="im-eye one"></div>
                                    <div class="im-eye two"></div>
                                    <div class="im-ear one"></div>
                                    <div class="im-ear two"></div>
                                </div>
                            </div>
                            <div class="im-legs">
                                <div class="im-leg"></div>
                                <div class="im-leg"></div>
                                <div class="im-leg"></div>
                                <div class="im-leg"></div>
                            </div>
                        </div>
                        <h4>${pageContext.exception.message}</h4>
                        <a href="/" class="btn btn-primary btn-round">Go to homepage</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:import url="../templates/footer.jsp"/>
</div>
</body>
</html>