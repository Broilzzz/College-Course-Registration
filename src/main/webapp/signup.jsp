<<%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 01-Jan-24
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Register Page</title>
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
    .form select{
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
        background: linear-gradient(90deg, rgba(141,194,111,1) 0%, rgba(118,184,82,1) 50%);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
    }
</style>

<body>
<%@include file="components/navbar.jsp"%>

<div class="login-page">
    <div class="form">
        <h2>Student Register</h2>

        <%
            String error = request.getParameter("error");
            if (error != null && error.equals("1")) {
        %>
        <p style="color: red">Invalid username or registration failed. Please try again</p>
        <%
            }
        %>


        <form class="login-form" action="student_register" method="post">
            <input type="text" name="name" placeholder="username"/>
            <input type="text" name="email" placeholder="email"/>
            <input type="password" name="password" placeholder="password"/>
            <select class="drop1" name="department" id="department">
                <option value="CS">CS</option>
                <option value="IT">IT</option>
                <option value="AI">AI</option>
                <option value="CDS">CDS</option>
                <option value="EEE">EEE</option>
                <option value="ECE">ECE</option>
                <option value="MECH">MECH</option>
                <option value="CIVIL">CIVIL</option>
                <option value="CHEM">CHEM</option>
            </select>

            <select class="drop2" name="degree" id="degree">
                <option value="Btech">Btech</option>
                <option value="Mtech">Mtech</option>
            </select>
            <input type="text" name="studentid" placeholder="student id"/>
            <button type="submit">Register</button>
        </form>
        <p class="message">Already registered? <a href="student_login.jsp" class="text-decoration-none">Login</a></p>
    </div>
</div>

</body>
</html>