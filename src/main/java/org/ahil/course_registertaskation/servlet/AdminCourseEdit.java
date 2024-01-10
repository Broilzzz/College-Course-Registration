package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.CoursesDAO;
import org.ahil.course_registertaskation.DAO.CoursesDAOimp;
import org.ahil.course_registertaskation.users.Courses;

import java.io.IOException;

@WebServlet("/admin_course_edit")
public class AdminCourseEdit extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String course_id = req.getParameter("course_id");
        String course_name = req.getParameter("coursename");
        String description = req.getParameter("description");
        String credits = req.getParameter("credits");
        String prerequisites = req.getParameter("prerequisites");
        String slots = req.getParameter("slots");
        Courses a = new Courses();
        a.setCourseCode(course_id);
        a.setCourseName(course_name);
        a.setDescription(description);
        a.setCredits(credits);
        a.setPrerequisites(prerequisites);
        a.setSlots(slots);
        CoursesDAO coursesDAO = new CoursesDAOimp();
        if(coursesDAO.editCourse(a)){
            resp.sendRedirect("admin/coursestemplate.jsp?edit=1");
        }else {
            resp.sendRedirect("admin/edit_course.jsp?erro=1");
        }
    }
}
