package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Locale;

@WebServlet("/adminLogin")
public class Admin_login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("email");
        String password = req.getParameter("password");

        if(name.equals("admin@gmail.com") && password.equals("admin")){
            resp.sendRedirect("admin/index.jsp");
        }else{
            resp.sendRedirect("admin_login.jsp?error=1");
        }

    }
}
