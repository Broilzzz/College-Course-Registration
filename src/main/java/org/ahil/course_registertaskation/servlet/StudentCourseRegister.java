package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.StudentDAO;
import org.ahil.course_registertaskation.DAO.StudentDAOimp;

import java.io.IOException;

@WebServlet("/applyCourse")
public class StudentCourseRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        String course_id = req.getParameter("course_id");
        String faculty_id = req.getParameter("faculty_id");
        StudentDAO studentDAO = new StudentDAOimp();
        if(studentDAO.applyCourse(student_id,course_id, faculty_id)){
            resp.sendRedirect("student_home.jsp?added=1");
        }else {
            resp.sendRedirect("studentCourseAdd.jsp?error=1");
        }

    }
}
