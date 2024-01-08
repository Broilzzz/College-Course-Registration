package org.ahil.course_registertaskation.DAO;

import org.ahil.course_registertaskation.users.Courses;
import org.ahil.course_registertaskation.users.Faculty;
import org.ahil.course_registertaskation.users.Student;

import java.util.List;

public interface FacultyDAO {

    boolean addFaculty(Faculty a);
    boolean removeFaculty(String faculty_id);

    boolean LoginFaculty(String faculty_id, String password);

    List<Faculty> printAllFaculty();
    String getFacultyName(String id);
    String getFacultyId(String faculty_name);
    String getFacultyDepartment(String id);
    List<Courses> printAllAppliedCourses(String faculty_id);
    List<Courses> printAllStudents(String faculty_id);

    boolean allowStudent(String student_id, String course_id);
    boolean declineStudent(String student_id, String course_id);
}
