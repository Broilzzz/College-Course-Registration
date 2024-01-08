package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.FacultyDAO;
import org.ahil.course_registertaskation.DAO.FacultyDAOimp;

import java.io.IOException;

@WebServlet("/decline_student")
public class FacultyStudentRemove extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        String course_id = req.getParameter("course_id");
        FacultyDAO facultyDAO = new FacultyDAOimp();
        if(facultyDAO.declineStudent(student_id,course_id)){
            resp.sendRedirect("faculty_homepage.jsp?no=3");
        }else{
            resp.sendRedirect("faculty_homepage.jsp?error=1");
        }
    }
}
