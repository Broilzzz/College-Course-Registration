package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.StudentDAO;
import org.ahil.course_registertaskation.DAO.StudentDAOimp;
import org.ahil.course_registertaskation.users.Student;

import java.io.IOException;

@WebServlet("/student_register")
public class StudentRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String department = req.getParameter("department");
            String degree = req.getParameter("degree");
            String studentid = req.getParameter("studentid");

            Student student = new Student(name, department, email, password, degree, studentid);

            student.setName(name);
            student.setDepartment(department);
            student.setEmail(email);
            student.setPassword(password);
            student.setDegree(degree);
            student.setStudentId(studentid);

            StudentDAO b = new StudentDAOimp();
            if(b.addStudent(student)){
                resp.sendRedirect("student_login.jsp?registration=success");
            }else{
                resp.sendRedirect("signup.jsp?error=1");
            }





        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}