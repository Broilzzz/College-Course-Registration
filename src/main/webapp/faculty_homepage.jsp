<%@ page import="org.ahil.course_registertaskation.DAO.FacultyDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.FacultyDAOimp" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %>
<%@ page import="org.ahil.course_registertaskation.users.Courses" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 07-Jan-24
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Faculty Homepage</title>
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
<%@include file="faculty_navbar.jsp"%>




<%
    HttpSession sess = request.getSession();
    String faculty_id = (String) sess.getAttribute("faculty_id");
    FacultyDAO d = new FacultyDAOimp();
    String department = d.getFacultyDepartment(faculty_id);
    String faculty_name1 = d.getFacultyName(faculty_id);
%>

<h1 style="display: flex; justify-content: center; margin-top: 50px; font-size: 60px; font-weight: bold">Welcome <%=faculty_name1%></h1>

<%
    String edit = request.getParameter("edit");
    if (edit != null && edit.equals("1")) {
%>
<p style="color: green; display: flex; justify-content: center; font-weight: bold; font-size: 20px">Course has been edited</p>
<%
    }
%>

<%
    String succ = request.getParameter("succ");
    if (succ != null && succ.equals("1")) {
%>
<p style="color: green; display: flex; justify-content: center; font-weight: bold; font-size: 20px">Course Added Successfully</p>
<%
    }
%>

<div style="display: flex;margin-top: 20px; justify-content: center">
    <a class="btn btn-primary" href="faculty_course_add.jsp?department=<%=department%>&faculty_id=<%=faculty_id%>" role="button" style="width: 130px; background-color: #198754;border-color: #198754">ADD COURSES</a>
</div>

<div style="display: flex;margin-top: 20px; justify-content: center">
    <a class="btn btn-primary" href="edit_course.jsp" role="button" style="width: 130px; background-color: #198754;border-color: #198754">EDIT COURSE</a>
</div>

<h4 style="display: flex; justify-content: center;align-items: center;font-weight: bold;margin-top: 50px">Student under your course</h4>
<table style="display: flex; justify-content: center;align-items: center">
    <tr>
        <th >Student Id</th>
        <th >Student Name</th>
        <th >Course Id</th>
        <th>Course name </th>
        <th>Department</th>
        <th>Description</th>
        <th>Credits </th>
        <th>Slots </th>
    </tr>
    <tr>
        <%
            FacultyDAO facultyDAO2 = new FacultyDAOimp(DBconnect.getConn());
            List<Courses> appliedCourses2 = facultyDAO2.printAllStudents(faculty_id);
            for(Courses course3 : appliedCourses2){%>
        <td><%=course3.getStudent_id_apply()%></td>
        <td><%=course3.getStudent_name_apply()%></td>
        <td><%=course3.getCourseCode()%></td>
        <td><%=course3.getCourseName()%> </td>
        <td><%=course3.getDepartment()%> </td>
        <td><%=course3.getDescription()%> </td>
        <td><%=course3.getCredits()%> </td>
        <td><%=course3.getSlots()%> </td>
    </tr>
    <%
        }
    %>


</table>






<div >
    <h4 style="display: flex; justify-content: center;align-items: center;font-weight: bold;margin-top: 50px">Student Applied Courses</h4>
    <%
        String error = request.getParameter("error");
        if (error != null && error.equals("1")) {
    %>
    <p style="color: red;display: flex; justify-content: center; font-weight: bold; font-size: 20px">There was some error. Please try again</p>
    <%
        }
    %>

    <%
        String allow = request.getParameter("allow");
        if (allow != null && allow.equals("2")) {
    %>
    <p style="color: green;display: flex; justify-content: center; font-weight: bold; font-size: 20px">Student has been applied</p>
    <%
        }
    %>

    <%
        String no = request.getParameter("no");
        if (no != null && no.equals("3")) {
    %>
    <p style="color: green;display: flex; justify-content: center; font-weight: bold; font-size: 20px">Student has been declined</p>
    <%
        }
    %>
    <table style="display: flex; justify-content: center;align-items: center">
        <tr>
            <th >Student Id</th>
            <th >Student Name</th>
            <th >Course Id</th>
            <th>Course name </th>
            <th>Department</th>
            <th>Description</th>
            <th>Credits </th>
            <th>Slots </th>
        </tr>
        <tr>
            <%
                FacultyDAO facultyDAO = new FacultyDAOimp(DBconnect.getConn());
                List<Courses> appliedCourses = facultyDAO.printAllAppliedCourses(faculty_id);
                for(Courses course : appliedCourses){%>
            <td><%=course.getStudent_id_apply()%></td>
            <td><%=course.getStudent_name_apply()%></td>
            <td><%=course.getCourseCode()%></td>
            <td><%=course.getCourseName()%> </td>
            <td><%=course.getDepartment()%> </td>
            <td><%=course.getDescription()%> </td>
            <td><%=course.getCredits()%> </td>
            <td><%=course.getSlots()%> </td>
            <td>
                <form style="display: inline-block; margin-right: 5px;" action="allow_student" method="post">
                    <input type="hidden" name="student_id" value="<%=course.getStudent_id_apply()%>">
                    <input type="hidden" name="course_id" value="<%=course.getCourseCode()%>">
                    <button type="submit" class="btn btn-success">Accept</button>
                </form>
                <form style="display: inline-block;" action="decline_student" method="post">
                    <input type="hidden" name="student_id" value="<%=course.getStudent_id_apply()%>">
                    <input type="hidden" name="course_id" value="<%=course.getCourseCode()%>">
                    <button type="submit" class="btn btn-danger">Reject</button>
                </form>
            </td>

        </tr>
        <%
            }
        %>

    </table>
</div>

</body>
</html>
