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
        try{
            Connection conn = DBconnect.getConn();
            String query = "DELETE FROM courses WHERE course_id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,coursecode);
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected>0;

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
}
