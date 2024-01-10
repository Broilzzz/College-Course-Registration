<%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 08-Jan-24
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faculty Course Add</title>
    <%@include file="components/allcss.jsp"%>
</head>

<style>
    @import url(https://fonts.googleapis.com/css?family=Roboto:300);

    .login-page {
        width: 360px;
        padding: 8% 0 0;
        margin: auto;
    }
    .form {
        position: relative;
        z-index: 1;
        background: #FFFFFF;
        max-width: 360px;
        margin: 0 auto 100px;
        padding: 45px;
        text-align: center;
        box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }
    .form input {
        font-family: "Roboto", sans-serif;
        outline: 0;
        background: #f2f2f2;
        width: 100%;
        border: 0;
        margin: 0 0 15px;
        padding: 15px;
        box-sizing: border-box;
        font-size: 14px;
    }
    .form button {
        font-family: "Roboto", sans-serif;
        text-transform: uppercase;
        outline: 0;
        background: #4CAF50;
        width: 100%;
        border: 0;
        padding: 15px;
        color: #FFFFFF;
        font-size: 14px;
        cursor: pointer;
    }
    .form button:hover,.form button:active,.form button:focus {
        background: #43A047;
    }
    .form .message {
        margin: 15px 0 0;
        color: #b3b3b3;
        font-size: 12px;
    }
    .form .message a {
        color: #4CAF50;
        text-decoration: none;
    }
    .form .register-form {
        display: none;
    }
    .container {
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }
    .container:before, .container:after {
        content: "";
        display: block;
        clear: both;
    }
    .container .info {
        margin: 50px auto;
        text-align: center;
    }
    .container .info h1 {
        margin: 0 0 15px;
        padding: 0;
        font-size: 36px;
        font-weight: 300;
        color: #1a1a1a;
    }
    .container .info span {
        color: #4d4d4d;
        font-size: 12px;
    }
    .container .info span a {
        color: #000000;
        text-decoration: none;
    }
    .container .info span .fa {
        color: #EF3B3A;
    }
    body {
        background: #deffd6; /* fallback for old browsers */
        background: rgb(209, 241, 190);
        background: linear-gradient(90deg, rgb(1 41 28) 0%, rgb(1 41 28) 50%);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>

<body>
<%@include file="faculty_navbar.jsp"%>

<div style="display: flex;margin-top: 20px">
    <a class="btn btn-primary" href="faculty_homepage.jsp" role="button" style="width: 60px; margin-right: 600px;padding-bottom: 26px; background-color: #198754; border-color: #198754">Back</a>
</div>


<div class="login-page">
    <div class="form">
        <h2>Add Courses</h2>
        <h5>to remove courses contact admin</h5>

        <%
            String err = request.getParameter("err");
            if (err != null && err.equals("1")) {
        %>
        <p style="color: red">There was some error. please try again</p>
        <%
            }
        %>

        <form class="login-form" action="faculty_courseAdd" method="post">
            <input type="text" name="coursecode" placeholder="course code"/>
            <input type="text" name="coursename" placeholder="course name"/>
            <input type="hidden" name="department" value="<%=request.getParameter("department")%>"/>
            <input type="text" name="description" placeholder="description (if none type none)"/>
            <input type="text" name="credits" placeholder="credits"/>
            <input type="text" name="prerequisites" placeholder="prerequisites (if none type none)"/>
            <input type="hidden" name="faculty_id" value="<%=request.getParameter("faculty_id")%>"/>
            <input type="text" name="slots" placeholder="slots"/>

            <button>ADD</button>
        </form>
    </div>
</div>
</body>
</html>
