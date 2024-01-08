<%@ page import="org.ahil.course_registertaskation.DAO.StudentDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.StudentDAOimp" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %>
<%@ page import="org.ahil.course_registertaskation.users.Student" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 06-Jan-24
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students Template</title>
    <%@include file="../components/allcss.jsp"%>
</head>

<style>
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }

    th, td {
        padding: 10px;
        text-align: left;
        border: 1px solid #a3e1b2;
    }

    th {
        background-color: #a3e1b2;
    }
</style>

<body>
<%@include file="navbar.jsp"%>

<h2 style="display: flex; justify-content: center; font-size: 80px; font-weight: bold">All Students</h2>
<%
    String remove = request.getParameter("remove");
    if (remove != null && remove.equals("success")) {
%>
<p style="color: green; display: flex; justify-content: center; font-weight: bold; font-size: 20px">Student Removed Successfully</p>
<%
    }
%>
<%
    String error = request.getParameter("error");
    if (error != null && error.equals("1")) {
%>
<p style="color: red; display: flex; justify-content: center; font-weight: bold; font-size: 20px">There was some error. Please try again</p>
<%
    }
%>

<table>
    <tr>
        <th >Student Name</th>
        <th>Department</th>
        <th>Email</th>
        <th>password</th>
        <th>Degree</th>
        <th>Student Id</th>
    </tr>
    <%
        StudentDAO d4 = new StudentDAOimp(DBconnect.getConn());
        List<Student> list4 = d4.printAllStudents();
        for(Student d1: list4){%>
    <tr>
        <td><%=d1.getName()%> </td>
        <td><%=d1.getDepartment()%> </td>
        <td><%=d1.getEmail()%> </td>
        <td><%=d1.getPassword()%> </td>
        <td><%=d1.getDegree()%> </td>
        <td><%=d1.getStudentId()%> </td>
        <td>
            <form action="/Course_RegisterTaskation_war_exploded/removeStudent" method="post">
                <input type="hidden" name="studentid" value="<%=d1.getStudentId()%>">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </td>
    </tr>
    <%}
    %>


</table>

</body>
</html>
