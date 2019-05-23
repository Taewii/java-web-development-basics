<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <c:import url="templates/head.jsp"/>
</head>
<body>
<div class="container-fluid">
    <c:import url="templates/header.jsp"/>
    <div class="text-center mt-3">
        <h4 class="h4 text-info">Welcome, ${username}</h4>
    </div>
    <hr class="my-4">
    <div class="container">
        ${allTubes}
    </div>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>