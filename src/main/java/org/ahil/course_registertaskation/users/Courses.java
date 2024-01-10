package org.ahil.course_registertaskation.users;

public class Courses {
    private String courseCode;
    private String courseName;
    private String department;
    private String teacher;
    private String slots;
    private String credits;
    private String description;
    private  String prerequisites;
    private String student_id_apply;
    private String student_name_apply;
    private String status;
    private String faculty_id;
    private String modification_status;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Courses(String courseCode, String courseName, String department, String description,String prerequisites, String slots, String credits, String teacher) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.department = department;
        this.teacher = teacher;
        this.slots = slots;
        this.credits = credits != null ? credits : "";
        this.description = description;
        this.prerequisites = prerequisites;
    }
    public Courses(String courseCode){
        this.courseCode = courseCode;
    }
    public Courses(){

    }



    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }
    public String getPrerequisites() {
        return prerequisites;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudent_name_apply() {
        return student_name_apply;
    }

    public void setStudent_name_apply(String student_name_apply) {
        this.student_name_apply = student_name_apply;
    }

    public String getStudent_id_apply() {
        return student_id_apply;
    }

    public void setStudent_id_apply(String student_id_apply) {
        this.student_id_apply = student_id_apply;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }
    public String getModification_status() {
        return modification_status;
    }

    public void setModification_status(String modification_status) {
        this.modification_status = modification_status;
    }
}
