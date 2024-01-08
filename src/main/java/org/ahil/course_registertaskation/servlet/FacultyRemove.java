package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.FacultyDAO;
import org.ahil.course_registertaskation.DAO.FacultyDAOimp;
import org.ahil.course_registertaskation.DAO.StudentDAO;
import org.ahil.course_registertaskation.DAO.StudentDAOimp;
import org.ahil.course_registertaskation.db.DBconnect;

import java.io.IOException;

@WebServlet("/facultyRemove")
public class FacultyRemove extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String faculty_id = req.getParameter("faculty_id");
        FacultyDAO dao = new FacultyDAOimp(DBconnect.getConn());
        if(dao.removeFaculty(faculty_id)){
            resp.sendRedirect("admin/facultyTemplate.jsp?remove=2");
        }else {
            resp.sendRedirect("admin/facultyTemplate.jsp?error=1");
        }
    }
}
