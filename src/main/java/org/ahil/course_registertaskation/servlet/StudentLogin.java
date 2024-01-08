package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.ahil.course_registertaskation.DAO.StudentDAO;
import org.ahil.course_registertaskation.DAO.StudentDAOimp;
import org.ahil.course_registertaskation.users.Student;

import java.io.IOException;
@WebServlet("/studentlogin")
public class StudentLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("studentid");
        String password = req.getParameter("password");

        StudentDAO st = new StudentDAOimp();
        if(st.Login(id, password)){
            String studentName = st.getStudentName(id);
            String department = st.getDepartment(id);
            HttpSession session = req.getSession();
            session.setAttribute("name",studentName );
            session.setAttribute("department",department);
            session.setAttribute("student_id",id);
            resp.sendRedirect("student_home.jsp");
        }else{
            resp.sendRedirect("student_login.jsp?error=1");
        }
    }
}
