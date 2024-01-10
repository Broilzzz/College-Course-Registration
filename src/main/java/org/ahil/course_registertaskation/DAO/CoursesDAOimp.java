package org.ahil.course_registertaskation.DAO;

import org.ahil.course_registertaskation.db.DBconnect;
import org.ahil.course_registertaskation.users.Courses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursesDAOimp implements CoursesDAO {
    Connection conn;
    public CoursesDAOimp(){

    }
    public CoursesDAOimp(Connection conn){
        this.conn = DBconnect.getConn();
    }

    @Override
    public boolean addCourse(Courses a) {
        String insertQuery = "INSERT INTO courses (course_id, course_name, department, description, prerequisites, credits, slots, teacher) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = DBconnect.getConn();
            PreparedStatement psm = conn.prepareStatement(insertQuery)){
            psm.setString(1, a.getCourseCode());
            psm.setString(2, a.getCourseName());
            psm.setString(3, a.getDepartment());
            psm.setString(4, a.getDescription());
            psm.setString(5, a.getPrerequisites());
            psm.setString(6, a.getCredits());
            psm.setString(7, a.getSlots());
            psm.setString(8, a.getTeacher());

            int rowsAffected = psm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCourse(String coursecode) {

        try {
            Connection conn = DBconnect.getConn();

            // Delete from student_courses first
            String deleteStudentCoursesQuery = "DELETE FROM student_courses WHERE course_id = ?";
            try (PreparedStatement studentCoursesStatement = conn.prepareStatement(deleteStudentCoursesQuery)) {
                studentCoursesStatement.setString(1, coursecode);
                studentCoursesStatement.executeUpdate();
            }

            // Now delete from courses
            String deleteCourseQuery = "DELETE FROM courses WHERE course_id = ?";
            try (PreparedStatement courseStatement = conn.prepareStatement(deleteCourseQuery)) {
                courseStatement.setString(1, coursecode);
                int rowsAffected = courseStatement.executeUpdate();
                return rowsAffected > 0;
            }

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeCourseFromRegistration(String coursecode) {
        Connection conn = DBconnect.getConn();
        String deleteStudentCoursesQuery = "DELETE FROM student_courses WHERE course_id = ?";
        try (PreparedStatement studentCoursesStatement = conn.prepareStatement(deleteStudentCoursesQuery)) {
            studentCoursesStatement.setString(1, coursecode);
            int rowsAffected = studentCoursesStatement.executeUpdate();
            return rowsAffected > 0;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Courses> printAllCourse() {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        try{
            String query = "select * from courses order by course_id desc";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                d = new Courses();
                d.setCourseCode(rs.getString(2));
                d.setCourseName(rs.getString(3));
                d.setDepartment(rs.getString(4));
                d.setDescription(rs.getString(5));
                d.setPrerequisites(rs.getString(6));
                d.setCredits(rs.getString(7));
                d.setSlots(rs.getString(8));
                d.setTeacher(rs.getString(9));
                list.add(d);

            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }

    }

    @Override
    public boolean editCourse(Courses a) {
        String updateQuery = "UPDATE courses " +
                "SET course_name = ?, description = ?, prerequisites = ?, " +
                "credits = ?, slots = ? " +
                "WHERE course_id = ?";


        try(Connection conn = DBconnect.getConn();
            PreparedStatement psm = conn.prepareStatement(updateQuery)){
            psm.setString(1, a.getCourseName());
            psm.setString(2, a.getDescription());
            psm.setString(3, a.getPrerequisites());
            psm.setString(4, a.getCredits());
            psm.setString(5, a.getSlots());
            psm.setString(6, a.getCourseCode());

            int rowsAffected = psm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean acceptEdit(String course_name, String description, String prerequisites, String credits, String slots, String course_id) {
        String updateCoursesQuery = "UPDATE courses " +
                "SET course_name = ?, description = ?, " +
                "prerequisites = ?, credits = ?, slots = ?, " +
                "WHERE course_id = ?";

        try (Connection conn = DBconnect.getConn();
             PreparedStatement preparedStatement = conn.prepareStatement(updateCoursesQuery)) {

            preparedStatement.setString(1, course_name);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, prerequisites);
            preparedStatement.setString(4, credits);
            preparedStatement.setString(5, slots);
            preparedStatement.setString(6, course_id);


            // Execute the update query
            int coursesRowsAffected = preparedStatement.executeUpdate();

            // Check if the update was successful
            return coursesRowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean declineEdit(String course_id) {
        String updateCoursesQuery = "UPDATE courses " +
                "modification_status = 'declined' " +
                "WHERE course_id = ?";

        try (Connection conn = DBconnect.getConn();
             PreparedStatement preparedStatement = conn.prepareStatement(updateCoursesQuery)) {

            preparedStatement.setString(1, course_id);

            int coursesRowsAffected = preparedStatement.executeUpdate();

            return coursesRowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Courses> printEditCourses() {
        List<Courses> list = new ArrayList<>();
        Courses course = null;
        try {
            String query = "SELECT * FROM courses WHERE modification_status = 'pending' ORDER BY course_id DESC";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                course = new Courses();
                course.setCourseCode(rs.getString(2));
                course.setCourseName(rs.getString(3));
                course.setDepartment(rs.getString(4));
                course.setDescription(rs.getString(5));
                course.setPrerequisites(rs.getString(6));
                course.setCredits(rs.getString(7));
                course.setSlots(rs.getString(8));
                course.setTeacher(rs.getString(9));
                FacultyDAO facultyDAO = new FacultyDAOimp();
                String faculty_id = facultyDAO.getFacultyId(course.getTeacher());
                course.setFaculty_id(faculty_id);
                list.add(course);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
    }
}
