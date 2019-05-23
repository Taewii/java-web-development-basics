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
        <h4 class="text-info text-center">@Pesho</h4>
        <h4 class="text-info text-center">(pesho@gmail.com)</h4>
    </div>
    <hr>
    <div class="container-fluid">
        <div class="row d-flex flex-column">
            <table class="table table-hover table-dark">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Author</th>
                    <th scope="col">Actions</th>
                </tr>
                </thead>
                <tbody>
                ${myTubes}
                </tbody>
            </table>
        </div>
    </div>
    <c:import url="templates/footer.jsp"/>
</div>
</body>
</html>