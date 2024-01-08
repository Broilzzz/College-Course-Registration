package org.ahil.course_registertaskation.DAO;

import com.mysql.cj.jdbc.exceptions.ConnectionFeatureNotAvailableException;
import org.ahil.course_registertaskation.db.DBconnect;
import org.ahil.course_registertaskation.users.Courses;
import org.ahil.course_registertaskation.users.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOimp implements  StudentDAO {
    Connection conn;
    public StudentDAOimp(Connection conn){
        this.conn = conn;
    }
    public StudentDAOimp(){

    }
    @Override
    public boolean addStudent(Student a) {
        String query = "INSERT INTO students (name, department, email, password, degree, studentid) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conn = DBconnect.getConn();
            PreparedStatement psm = conn.prepareStatement(query)){
            psm.setString(1, a.getName());
            psm.setString(2, a.getDepartment());
            psm.setString(3, a.getEmail());
            psm.setString(4, a.getPassword());
            psm.setString(5, a.getDegree());
            psm.setString(6, a.getStudentId());

            int rowsAffected = psm.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean Login(String studentid, String password) {
        String query = "SELECT * FROM students WHERE studentid = ? AND password = ?";
        try (Connection connection = DBconnect.getConn();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, studentid);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getStudentName(String id) {
        String query = "SELECT name FROM students WHERE studentid = ?";
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
    public List<Student> printAllStudents() {
        List<Student> list = new ArrayList<>();
        Student d = null;
        try{
            String query = "select * from students order by id desc";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                d = new Student();
                d.setName(rs.getString(2));
                d.setDepartment(rs.getString(3));
                d.setEmail(rs.getString(4));
                d.setPassword(rs.getString(5));
                d.setDegree(rs.getString(6));
                d.setStudentId(rs.getString(7));
                list.add(d);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }

    }

    @Override
    public boolean removeStudent(String studentid) {
        boolean f = false;
        try{
            String query = "DELETE FROM students WHERE studentid = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,studentid);
            int rows = preparedStatement.executeUpdate();

            if(rows==1){
                f= true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Courses> printAllDepartmentCourses(String department) {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        try{
            String query = "select * from courses WHERE department = ? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,department);
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
    public String getDepartment(String id) {
        String query = "SELECT department FROM students WHERE studentid = ?";
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
    public boolean applyCourse(String student_id, String course_id, String faculty_id) {
        boolean f = false;
        String query = "INSERT INTO student_courses (student_id, course_id, faculty_id) VALUES (?, ?, ?)";
        try(Connection conn = DBconnect.getConn()){
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,student_id);
            preparedStatement.setString(2,course_id);
            preparedStatement.setString(3,faculty_id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected>0){
                f = true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Courses> printAllAppliedCourses(String student_id) {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        try{
            String query = "SELECT * FROM student_courses " +
                    "INNER JOIN courses ON student_courses.course_id = courses.course_id " +
                    "WHERE student_courses.student_id = ? AND student_courses.status <> 'approved'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(query);
            preparedStatement1.setString(1,student_id);
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
                d.setStatus(rs.getString("status"));
                list.add(d);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }

    @Override
    public List<Courses> printAllCurrentCourses(String student_id) {
        List<Courses> list = new ArrayList<>();
        Courses d = null;
        try{
            String query = "SELECT * FROM student_courses " +
                    "INNER JOIN courses ON student_courses.course_id = courses.course_id " +
                    "WHERE student_courses.student_id = ? AND student_courses.status = 'approved'";
            PreparedStatement preparedStatement1 = conn.prepareStatement(query);
            preparedStatement1.setString(1,student_id);
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
                list.add(d);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }
    }
}
