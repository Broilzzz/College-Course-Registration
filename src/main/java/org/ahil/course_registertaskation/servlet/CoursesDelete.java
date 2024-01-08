package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.CoursesDAO;
import org.ahil.course_registertaskation.DAO.CoursesDAOimp;
import org.ahil.course_registertaskation.db.DBconnect;
import org.ahil.course_registertaskation.users.Courses;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/admin/deletecourse")
public class CoursesDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseCode = req.getParameter("coursecode");
        CoursesDAO b = new CoursesDAOimp();
        if(b.removeCourse(courseCode)){
            resp.sendRedirect("coursestemplate.jsp?delete=success");
        }else {
            resp.sendRedirect("coursesmodify.jsp?error=1");
        }
    }
}
