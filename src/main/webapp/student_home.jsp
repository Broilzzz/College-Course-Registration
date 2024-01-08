<%@ page import="org.ahil.course_registertaskation.DAO.StudentDAO" %>
<%@ page import="org.ahil.course_registertaskation.DAO.StudentDAOimp" %>
<%@ page import="org.ahil.course_registertaskation.db.DBconnect" %>
<%@ page import="org.ahil.course_registertaskation.users.Courses" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ahila
  Date: 02-Jan-24
  Time: 8:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Home Page</title>
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
<%
    HttpSession session1 = request.getSession();
    String studentName = (String) session1.getAttribute("name");
    if(studentName==null){studentName= "name not added";}
%>
<%@include file="student_navbar.jsp"%>
<div style="display: flex;margin-top: 20px;justify-content: center">
    <%
        String department = (String) session1.getAttribute("department");
        String student_id = (String) session1.getAttribute("student_id");%>
    <a class="btn btn-primary" href="studentCourseAdd.jsp?department=<%=department%>&student_id=<%=student_id%>" role="button" style="width: 130px; display: flex; justify-content: center; align-items: center; background-color: #198754;border-color: #198754">Add Courses</a>
</div>
<h1 style="display: flex; justify-content: center; margin-top: 50px; font-size: 60px; font-weight: bold">Welcome <%=studentName%></h1>

<%
    String added = request.getParameter("added");
    if (added != null && added.equals("1")) {
%>
<p style="color: green;display: flex; justify-content: center; font-weight: bold; font-size: 20px">Course Added Successfully</p>
<%
    }
%>
<br>
<br>

<%--<div style="display: flex; justify-content: space-evenly">--%>
<%--    <div class="card1" style="width: 18rem;">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">Applied Courses</h5>--%>
<%--            <p class="card-text"></p>--%>
<%--            &lt;%&ndash;        <a href="#" class="btn btn-primary">Create and Manage Templates</a>&ndash;%&gt;--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="card2" style="width: 18rem;">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">Previous Courses</h5>--%>
<%--            <p class="card-text"></p>--%>
<%--            &lt;%&ndash;        <a href="#" class="btn btn-primary">Manage Students</a>&ndash;%&gt;--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <div class="card3" style="width: 18rem;">--%>
<%--        <div class="card-body">--%>
<%--            <h5 class="card-title">Apply to New Courses</h5>--%>
<%--            <p class="card-text"></p>--%>
<%--            <a href="#" class="btn btn-primary">Click Here</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div >
    <h4 style="display: flex; justify-content: center;align-items: center;font-weight: bold;">Current Courses</h4>
    <table style="display: flex; justify-content: center;align-items: center">
        <tr>
            <th >Course Id</th>
            <th>Course name </th>
            <th>Department </th>
            <th>Description </th>
            <th>Credits </th>
            <th>Slots </th>
            <th>Teachers </th>
        </tr>
        <tr>
            <%
                StudentDAO studentDAO2 = new StudentDAOimp(DBconnect.getConn());
                List<Courses> appliedCourses2 = studentDAO2.printAllCurrentCourses(student_id);
                for(Courses course2 : appliedCourses2){%>
                <td><%=course2.getCourseCode()%></td>
                <td><%=course2.getCourseName()%> </td>
                <td><%=department%> </td>
                <td><%=course2.getDescription()%> </td>
                <td><%=course2.getCredits()%> </td>
                <td><%=course2.getSlots()%> </td>
                <td><%=course2.getTeacher()%> </td>
        </tr>
        <%
            }
        %>

    </table>
</div>
<br>
<br>
<div>
    <h4 style="display: flex; justify-content: center;align-items: center; font-weight: bold;">Applied Courses</h4>
    <table style="display: flex; justify-content: center;align-items: center">
        <tr>
            <th >Course Id</th>
            <th>Course name </th>
            <th>Department </th>
            <th>Description </th>
            <th>Credits </th>
            <th>Slots </th>
            <th>Teachers </th>
            <th>Status </th>
        </tr>
        <tr>
            <%
                StudentDAO studentDAO = new StudentDAOimp(DBconnect.getConn());
                List<Courses> appliedCourses = studentDAO.printAllAppliedCourses(student_id);
                for(Courses course : appliedCourses){%>
            <td><%=course.getCourseCode()%></td>
            <td><%=course.getCourseName()%> </td>
            <td><%=department%> </td>
            <td><%=course.getDescription()%> </td>
            <td><%=course.getCredits()%> </td>
            <td><%=course.getSlots()%> </td>
            <td><%=course.getTeacher()%> </td>
            <td style="font-size: 17px; color: darkblue"><%=course.getStatus()%></td>

        </tr>
        <%
            }
        %>


    </table>
</div>


</body>
</html>
