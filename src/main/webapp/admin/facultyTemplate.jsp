<%@ page import="org.ahil.course_registertaskation.DAO.FacultyDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.FacultyDAOimp" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %>
<%@ page import="org.ahil.course_registertaskation.users.Faculty" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 06-Jan-24
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Faculty Modify</title>
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

<div style="display: flex;margin-top: 20px">
    <a class="btn btn-primary" href="index.jsp" role="button" style="width: 60px; margin-right: 600px;padding-bottom: 0; background-color: #198754; border-color: #198754">Back</a>
    <a class="btn btn-primary" href="facultymodify.jsp" role="button" style="width: 130px; display: flex; justify-content: center; align-items: center; background-color: #198754;border-color: #198754">ADD Faculty</a>
</div>

<h2 style="display: flex; justify-content: center; font-size: 80px; font-weight: bold">All Faculty</h2>

<%
    String added = request.getParameter("added");
    if (added != null && added.equals("success")) {
%>
<p style="color: green;display: flex; justify-content: center; font-weight: bold; font-size: 20px">Faculty has been Added</p>
<%
    }
%>
<%
    String remove = request.getParameter("remove");
    if (remove != null && remove.equals("2")) {
%>
<p style="color: green; display: flex; justify-content: center; font-weight: bold; font-size: 20px">Faculty has been Removed</p>
<%
    }
%>
<%
    String error = request.getParameter("error");
    if (error != null && error.equals("1")) {
%>
<p style="color: red">There was some error. please try again</p>
<%
    }
%>


<table>
    <tr>
        <th >Name</th>
        <th>Email</th>
        <th>Password</th>
        <th>Faculty Id</th>
        <th>Department</th>
    </tr>
    <%
        FacultyDAO d2 = new FacultyDAOimp(DBconnect.getConn());
        List<Faculty> list1 = d2.printAllFaculty();
        for(Faculty d: list1){%>
    <tr>
        <td><%=d.getName()%> </td>
        <td><%=d.getEmail()%> </td>
        <td><%=d.getPassword()%> </td>
        <td><%=d.getFaculty_id()%> </td>
        <td><%=d.getDepartment()%> </td>
        <td>
            <form action="/Course_RegisterTaskation_war_exploded/facultyRemove" method="post">
                <input type="hidden" name="faculty_id" value="<%=d.getFaculty_id()%>">
                <button type="submit" class="btn btn-danger">Delete</button>
            </form>
        </td>
    </tr>
    <%}
    %>


</table>

</body>
</html>
