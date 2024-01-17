
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Page</title>
    <%@include file="../components/allcss.jsp"%>
</head>

<body>
<%@include file="navbar.jsp"%>

<%
    HttpSession session2 = request.getSession();
    Object adminAuthenticated = session2.getAttribute("adminAuthenticated");

    // Check if the user is authenticated as admin
    if (adminAuthenticated == null || !(Boolean)adminAuthenticated) {
        // Redirect to the login page if not authenticated
        response.sendRedirect(request.getContextPath() + "/admin_logout");

    }
%>

<h1 style="display: flex; justify-content: center; margin-top: 50px; font-size: 60px; font-weight: bold" >Admin Dashboard</h1>
<div class="container" style="display: flex; justify-content: space-evenly; margin-top: 100px">
    <div class="card1" style="width: 18rem; display: flex; justify-content: center; align-items: center">
        <i class="fa-solid fa-hammer" style="font-size: 50px; display: flex ; justify-content: center"></i>
        <div class="card-body">
            <h5 class="card-title">Courses</h5>
            <p class="card-text"></p>
            <a href="coursestemplate.jsp" class="btn btn-primary">Create and Manage Courses</a>
        </div>
    </div>
    <div class="card2" style="width: 18rem; display: flex; justify-content: center; align-items: center">
        <i class="fa-solid fa-user" style="font-size: 50px; display: flex ; justify-content: center"></i>
        <div class="card-body">
            <h5 class="card-title">Students</h5>
            <p class="card-text"></p>
            <a href="studentmodify.jsp" class="btn btn-primary">Manage Students</a>
        </div>
    </div>
    <div class="card3" style="width: 18rem; display: flex; justify-content: center; align-items: center">
        <i class="fa-solid fa-chalkboard-user" style="font-size: 50px; display: flex ; justify-content: center"></i>
        <div class="card-body">
            <h5 class="card-title">Faculty</h5>
            <p class="card-text"></p>
            <a href="facultyTemplate.jsp" class="btn btn-primary">Add and Manage Faculty</a>
        </div>
    </div>

</div>

</body>
</html>
