package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ahil.course_registertaskation.DAO.FacultyDAO;
import org.ahil.course_registertaskation.DAO.FacultyDAOimp;
import org.ahil.course_registertaskation.users.Faculty;

import java.io.IOException;

@WebServlet("/facultyLogin")
public class FacultyLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String faculty_id = req.getParameter("faculty_id");
        String password = req.getParameter("password");

        FacultyDAO facultyDAO = new FacultyDAOimp();
        if(facultyDAO.LoginFaculty(faculty_id,password)){
            String faculty_name = facultyDAO.getFacultyName(faculty_id);
            HttpSession session = req.getSession();
            session.setAttribute("name",faculty_name );
            session.setAttribute("faculty_id",faculty_id);
            resp.sendRedirect("faculty_homepage.jsp");
        }else{
            resp.sendRedirect("faculty_login.jsp?error=1");
        }
    }
}
