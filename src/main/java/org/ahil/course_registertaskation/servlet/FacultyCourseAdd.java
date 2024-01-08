package org.ahil.course_registertaskation.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ahil.course_registertaskation.DAO.CoursesDAO;
import org.ahil.course_registertaskation.DAO.CoursesDAOimp;
import org.ahil.course_registertaskation.DAO.FacultyDAO;
import org.ahil.course_registertaskation.DAO.FacultyDAOimp;
import org.ahil.course_registertaskation.users.Courses;

import java.io.IOException;

@WebServlet("/faculty_courseAdd")
public class FacultyCourseAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String coursecode = req.getParameter("coursecode");
        String coursename = req.getParameter("coursename");
        String department = req.getParameter("department");
        String description = req.getParameter("description");
        String prerequisites = req.getParameter("prerequisites");
        String slots = req.getParameter("slots");
        String credits = req.getParameter("credits");
        String faculty_id = req.getParameter("faculty_id");

        FacultyDAO d9 = new FacultyDAOimp();
        String teacher = d9.getFacultyName(faculty_id);


        Courses courses = new Courses(coursecode, coursename,department, description, prerequisites, slots, credits, teacher);
        courses.setCourseCode(coursecode);
        courses.setCourseName(coursename);
        courses.setDepartment(department);
        courses.setDescription(description);
        courses.setPrerequisites(prerequisites);
        courses.setSlots(slots);
        courses.setCredits(credits);
        courses.setTeacher(teacher);

        CoursesDAO b = new CoursesDAOimp();
        if(b.addCourse(courses)){
            resp.sendRedirect("faculty_homepage.jsp?succ=1");
        }else {
            resp.sendRedirect("faculty_course_add.jsp?err=1");
        }
    }
}
