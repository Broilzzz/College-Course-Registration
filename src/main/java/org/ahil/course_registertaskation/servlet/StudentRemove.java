package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.StudentDAO;
import org.ahil.course_registertaskation.DAO.StudentDAOimp;
import org.ahil.course_registertaskation.db.DBconnect;

import java.io.IOException;

@WebServlet("/removeStudent")
public class StudentRemove extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentid = req.getParameter("studentid");
        StudentDAO dao = new StudentDAOimp(DBconnect.getConn());
        if(dao.removeStudent(studentid)){
            resp.sendRedirect("admin/studentmodify.jsp?remove=success");
        }else {
            resp.sendRedirect("admin/studentmodify.jsp?error=1");
        }
    }
}
