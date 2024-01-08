package org.ahil.course_registertaskation.DAO;

import java.util.List;
import org.ahil.course_registertaskation.users.Courses;
import org.ahil.course_registertaskation.users.Student;

public interface CoursesDAO {

    boolean addCourse(Courses a);
    boolean removeCourse(String coursecode);
    List<Courses> printAllCourse();

}
