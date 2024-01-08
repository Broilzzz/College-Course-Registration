<%@ page import="org.ahil.course_registertaskation.DAO.StudentDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.StudentDAOimp" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %>
<%@ page import="org.ahil.course_registertaskation.users.Courses" %>
<%@ page import="java.util.List" %>
<%@ page import="org.ahil.course_registertaskation.DAO.FacultyDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.FacultyDAOimp" %><%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 07-Jan-24
  Time: 12:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Course Add</title>
    <%@include file="components/allcss.jsp"%>
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
<%@include file="student_navbar.jsp"%>
<div style="display: flex;margin-top: 20px">
    <a class="btn btn-primary" href="student_home.jsp" role="button" style="width: 60px; margin-right: 600px;padding-bottom: 0; background-color: #198754; border-color: #198754">Back</a>
</div>
<h4 style="display: flex; justify-content: center;align-items: center; font-weight: bold;">Course Register</h4>

<%
    String error = request.getParameter("error");
    if (error != null && error.equals("1")) {
%>
<p style="color: red;display: flex; justify-content: center; font-weight: bold; font-size: 20px">There was an error. Please try again</p>
<%
    }
%>

<table style="display: flex; justify-content: center;align-items: center">
    <tr>
        <th>Course Id</th>
        <th>Course name </th>
        <th>Department </th>
        <th>Description </th>
        <th>Prerequisites </th>
        <th>Credits </th>
        <th>Slots </th>
        <th>Teachers</th>
    </tr>
    <%
        StudentDAO d2 = new StudentDAOimp(DBconnect.getConn());
        List<Courses> list1 = d2.printAllDepartmentCourses(request.getParameter("department"));
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
        <td>
            <form action="applyCourse" method="post">
                <%
                    HttpSession session2 = request.getSession();
                    String student_id = (String) session2.getAttribute("student_id");
                    FacultyDAO d8 = new FacultyDAOimp();
                    String faculty_id = d8.getFacultyId(d.getTeacher());
                %>
                <input type="hidden" name="student_id" value="<%=student_id%>">
                <input type="hidden" name="course_id" value="<%=d.getCourseCode()%>">
                <input type="hidden" name="faculty_id" value="<%=faculty_id%>">
                <button type="submit" class="btn btn-success">Apply</button>
            </form>
        </td>
    </tr>
    <%}
    %>


</table>

</body>
</html>
