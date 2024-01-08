<%@ page import="org.ahil.course_registertaskation.users.Courses" %>
<%@ page import="org.ahil.course_registertaskation.DAO.CoursesDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.CoursesDAOimp" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %>
<%--

  Created by IntelliJ IDEA.
  User: ahila
  Date: 05-Jan-24
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses Template</title>
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
    <a class="btn btn-primary" href="coursesmodify.jsp" role="button" style="width: 130px; display: flex; justify-content: center; align-items: center; background-color: #198754;border-color: #198754">ADD/REMOVE COURSES</a>
</div>
<h2 style="display: flex; justify-content: center; font-size: 80px; font-weight: bold">All Courses</h2>
<%
    String success = request.getParameter("success");
    if (success != null && success.equals("success")) {
%>
<p style="color: green; display: flex; justify-content: center; font-weight: bold; font-size: 20px">Course Added Successfully</p>
<%
    }
%>

<%
    String delete = request.getParameter("delete");
    if (delete != null && delete.equals("success")) {
%>
<p style="color: green; display: flex; justify-content: center; font-weight: bold; font-size: 20px">Course Removed Successfully</p>
<%
    }
%>



<table>
    <tr>
        <th >Course Id </th>
        <th>Course name </th>
        <th>Department </th>
        <th>Description </th>
        <th>Prerequisites </th>
        <th>Credits </th>
        <th>Slots </th>
        <th>Teachers </th>
    </tr>
    <%
    CoursesDAO d2 = new CoursesDAOimp(DBconnect.getConn());
    List<Courses> list1 = d2.printAllCourse();
    for(Courses d: list1){%>
        <tr>
            <td><%=d.getCourseCode()%> </td>
            <td><%=d.getCourseName()%> </td>
            <td><%=d.getDepartment()%> </td>
            <td><%=d.getDescription()%> </td>
            <td><%=d.getPrerequisites()%> </td>
            <td><%=d.getCredits()%> </td>
            <td><%=d.getSlots()%> </td>
            <td><%=d.getTeacher()%> </td>
        </tr>
    <%}
    %>


</table>

</body>
</html>
