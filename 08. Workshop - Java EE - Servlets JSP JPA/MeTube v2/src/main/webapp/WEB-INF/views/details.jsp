<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="container-fluid">
        <h2 class="text-center">${title}</h2>
        <div class="row">
            <div class="col-md-6 my-5">
                <div class="embed-responsive embed-responsive-16by9">
                    <iframe class="embed-responsive-item" src="${iFrameUrl}" allowfullscreen frameborder="0"></iframe>
                </div>
            </div>
            <div class="col-md-6 my-5">
                <h1 class="text-center text-info">${author}</h1>
                <h3 class="text-center text-info">${views} Views</h3>
                <div class="h5 my-5 text-center">${description}</div>
            </div>
        </div>
    </div>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>