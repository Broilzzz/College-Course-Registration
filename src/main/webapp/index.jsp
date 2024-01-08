<%@ page import="java.sql.Connection" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %><%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 01-Jan-24
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <%@include file="components/allcss.jsp"%>
</head>
<style>
    body {
        background: url('img/green4.jfif') no-repeat center center fixed;
        background-size: cover;
    }
    h1 {
        font-family: 'Raleway', sans-serif;
        color: white;
        text-align: center;
    }
</style>

<body>
<%@include file="components/navbar.jsp"%>

<div class="container" >
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Raleway:ital,wght@1,800&display=swap" rel="stylesheet">
    <h1 style="font-size: 90px;display: flex; justify-content: center; align-items: center; margin-top: 60px">Welcome to Course Register Taskation</h1>
    <h1 style="font-size: 70px;margin-top: 40px">By: Ahil Ahmed </h1>
    <h1 style="font-size: 70px;"> 221EE103 </h1>
</div>
</body>
</html>
