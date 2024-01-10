package org.ahil.course_registertaskation.DAO;

import org.ahil.course_registertaskation.db.DBconnect;
import org.ahil.course_registertaskation.users.Courses;
import org.ahil.course_registertaskation.users.Faculty;
import org.ahil.course_registertaskation.users.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOimp implements  FacultyDAO{
    Connection conn;
    public FacultyDAOimp(Connection conn){
        this.conn = conn;
    }
    public FacultyDAOimp(){

    }
    @Override
    public boolean addFaculty(Faculty a) {
        String query = "INSERT INTO teachers (name, email, password, faculty_id, department) VALUES (?, ?, ?, ?, ?)";
        try(Connection conn = DBconnect.getConn();
            PreparedStatement psm = conn.prepareStatement(query)){
            psm.setString(1, a.getName());
            psm.setString(2, a.getEmail());
            psm.setString(3, a.getPassword());
            psm.setString(4, a.getFaculty_id());
            psm.setString(5, a.getDepartment());


            int rowsAffected = psm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeFaculty(String faculty_id) {
        boolean f = false;
        try {
            // Delete from student_courses first
            String deleteStudentCoursesQuery = "DELETE FROM student_courses WHERE faculty_id = ?";
            try (PreparedStatement studentCoursesStatement = conn.prepareStatement(deleteStudentCoursesQuery)) {
                studentCoursesStatement.setString(1, faculty_id);
                studentCoursesStatement.executeUpdate();
            }

            // Now delete from teachers
            String deleteTeacherQuery = "DELETE FROM teachers WHERE faculty_id = ?";
            try (PreparedStatement teacherStatement = conn.prepareStatement(deleteTeacherQuery)) {
                teacherStatement.setString(1, faculty_id);
                int rowsAffected = teacherStatement.executeUpdate();
                f = rowsAffected > 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean LoginFaculty(String faculty_id, String password) {
        String query = "SELECT * FROM teachers WHERE faculty_id = ? AND password = ?";
        try (Connection connection = DBconnect.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, faculty_id);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Faculty> printAllFaculty() {
        List<Faculty> list = new ArrayList<>();
        Faculty d = null;
        try{
            String query = "select * from teachers order by id desc";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                d = new Faculty();
                d.setName(rs.getString(2));
                d.setEmail(rs.getString(3));
                d.setPassword(rs.getString(4));
                d.setFaculty_id(rs.getString(5));
                d.setDepartment(rs.getString(6));
                list.add(d);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }

    @Override
    public String getFacultyName(String id) {
        String query = "SELECT name FROM teachers WHERE faculty_id = ?";
        try(Connection conn = DBconnect.getConn()){
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return rs.getString("name");
            }else{
                return null;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getFacultyId(String faculty_name) {
        String query = "SELECT faculty_id FROM teachers WHERE name = ?";
        try(Connection conn = DBconnect.getConn()){
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,faculty_name);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return rs.getString("faculty_id");
            }else{
                return null;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getFacultyDepartment(String id) {
        String query = "SELECT department FROM teachers WHERE faculty_id = ?";
        try(Connection conn = DBconnect.getConn()){
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,id);
            ResultSet rs = preparedStatement.executeQuery();

            if(rs.next()){
                return rs.getString("department");
            }else{
                return null;
            }

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Courses> printAllAppliedCourses(String faculty_id) {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        try{
            String query = "SELECT * FROM student_courses " +
                    "INNER JOIN courses ON student_courses.course_id = courses.course_id " +
                    "INNER JOIN students ON student_courses.student_id = students.studentid " +
                    "WHERE student_courses.faculty_id = ? AND student_courses.status = 'pending'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(query);
            preparedStatement1.setString(1,faculty_id);
            ResultSet rs = preparedStatement1.executeQuery();
            while(rs.next()){
                d = new Courses();
                d.setCourseCode(rs.getString("course_id"));
                d.setCourseName(rs.getString("course_name"));
                d.setDepartment(rs.getString("department"));
                d.setDescription(rs.getString("description"));
                d.setPrerequisites(rs.getString("prerequisites"));
                d.setCredits(rs.getString("credits"));
                d.setSlots(rs.getString("slots"));
                d.setTeacher(rs.getString("teacher"));
                d.setStudent_id_apply(rs.getString("student_id"));
                d.setStudent_name_apply(rs.getString("name"));

                list.add(d);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }

    @Override
    public List<Courses> printAllStudents(String faculty_id) {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        try{
            String query = "SELECT * FROM student_courses " +
                    "INNER JOIN courses ON student_courses.course_id = courses.course_id " +
                    "INNER JOIN students ON student_courses.student_id = students.studentid " +
                    "WHERE student_courses.faculty_id = ? AND student_courses.status = 'approved'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(query);
            preparedStatement1.setString(1,faculty_id);
            ResultSet rs = preparedStatement1.executeQuery();
            while(rs.next()){
                d = new Courses();
                d.setCourseCode(rs.getString("course_id"));
                d.setCourseName(rs.getString("course_name"));
                d.setDepartment(rs.getString("department"));
                d.setDescription(rs.getString("description"));
                d.setPrerequisites(rs.getString("prerequisites"));
                d.setCredits(rs.getString("credits"));
                d.setSlots(rs.getString("slots"));
                d.setTeacher(rs.getString("teacher"));
                d.setStudent_id_apply(rs.getString("student_id"));
                d.setStudent_name_apply(rs.getString("name"));

                list.add(d);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }

    @Override
    public List<Courses> printAllEditReq(String faculty_id) {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        FacultyDAO facultyDAO = new FacultyDAOimp();
        String teacher = facultyDAO.getFacultyName(faculty_id);
        try {
            String query = "SELECT * FROM courses " +
                    "WHERE teacher = ? AND modification_status != 'none'";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, teacher);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                d = new Courses();
                d.setCourseCode(rs.getString("course_id"));
                d.setCourseName(rs.getString("course_name"));
                d.setDepartment(rs.getString("department"));
                d.setDescription(rs.getString("description"));
                d.setPrerequisites(rs.getString("prerequisites"));
                d.setCredits(rs.getString("credits"));
                d.setSlots(rs.getString("slots"));
                d.setModification_status("modification_status");
                list.add(d);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }

    }

    @Override
    public boolean allowStudent(String student_id,String course_id) {
        boolean f = false;
        String query = "UPDATE student_courses SET status = 'approved' WHERE student_id = ? AND course_id = ?";
        try(Connection conn = DBconnect.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1,student_id);
            preparedStatement.setString(2,course_id);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("im in allowStudent FacultyDAOimp, rows affected: "+rowsAffected);
            if(rowsAffected>0){
                f = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean declineStudent(String student_id, String course_id) {
        boolean f = false;
        String query = "UPDATE student_courses SET status = 'declined' WHERE student_id = ? AND course_id = ?";
        try(Connection conn = DBconnect.getConn();
            PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1,student_id);
            preparedStatement.setString(2,course_id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                f = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
