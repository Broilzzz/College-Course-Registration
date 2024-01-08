package org.ahil.course_registertaskation.DAO;

import org.ahil.course_registertaskation.users.Courses;
import org.ahil.course_registertaskation.users.Student;

import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student a);
    boolean Login(String username, String password);

    String getStudentName(String id);
    List<Student> printAllStudents();
    boolean removeStudent(String studentid);
    List<Courses> printAllDepartmentCourses(String department);

    String getDepartment(String id);
    boolean applyCourse(String student_id, String course_id, String teacher_name);
    List<Courses> printAllAppliedCourses(String student_id);
    List<Courses> printAllCurrentCourses(String student_id);


}
