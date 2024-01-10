package org.ahil.course_registertaskation.DAO;

import java.util.List;
import org.ahil.course_registertaskation.users.Courses;
import org.ahil.course_registertaskation.users.Student;

public interface CoursesDAO {

    boolean addCourse(Courses a);
    boolean removeCourse(String coursecode);
    boolean removeCourseFromRegistration(String coursecode);
    List<Courses> printAllCourse();
    boolean editCourse(Courses a);
    boolean acceptEdit(String course_name, String description, String prerequisites, String credits, String slots, String course_id);
    boolean declineEdit(String course_id);
    List<Courses> printEditCourses();



}
