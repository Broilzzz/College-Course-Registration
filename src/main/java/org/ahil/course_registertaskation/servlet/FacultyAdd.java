package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.FacultyDAO;
import org.ahil.course_registertaskation.DAO.FacultyDAOimp;
import org.ahil.course_registertaskation.users.Faculty;

import java.io.IOException;

@WebServlet("/facultyAdd")
public class FacultyAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String faculty_id = req.getParameter("faculty_id");
        String department = req.getParameter("department");

        Faculty faculty = new Faculty(name, email, password, faculty_id, department);
        faculty.setName(name);
        faculty.setEmail(email);
        faculty.setPassword(password);
        faculty.setFaculty_id(faculty_id);
        faculty.setDepartment(department);

        FacultyDAO d = new FacultyDAOimp();
        if(d.addFaculty(faculty)){
            resp.sendRedirect("admin/facultyTemplate.jsp?added=success");
        }else{
            resp.sendRedirect("admin/facultymodify.jsp?error=1");
        }
    }
}
