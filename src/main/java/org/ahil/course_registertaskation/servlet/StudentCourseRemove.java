package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.CoursesDAO;
import org.ahil.course_registertaskation.DAO.CoursesDAOimp;

import java.io.IOException;

@WebServlet("/register_remove")
public class StudentCourseRemove extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseCode = req.getParameter("coursecode");
        CoursesDAO b = new CoursesDAOimp();
        if(b.removeCourseFromRegistration(courseCode)){
            resp.sendRedirect("student_home.jsp?rr=1");
        }else {
            resp.sendRedirect("student_home.jsp?err=1");
        }
    }
}
