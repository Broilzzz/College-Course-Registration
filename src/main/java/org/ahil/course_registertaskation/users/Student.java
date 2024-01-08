package org.ahil.course_registertaskation.users;

public class Student {
    private int id;
    private String name;
    private String email;
    private String password;
    private String department;
    private String previousCourses;
    private String appliedCourses;
    private String degree;
    private  String studentid;

    public Student(String name,String department, String email, String password, String degree, String studentid){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.department = department;
        this.degree = degree;
        this.studentid = studentid;
    }
    public Student(){

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email ){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password ){
        this.password = password;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department ){
        this.department = department;
    }
    public String getDegree(){
        return degree;
    }
    public void setDegree(String degree ){
        this.degree = degree;
    }
    public String getStudentId(){
        return studentid;
    }
    public void setStudentId(String studentid){
        this.studentid = studentid;
    }

    public String getAppliedCourses() {
        return appliedCourses;
    }

    public void setAppliedCourses(String appliedCourses) {
        this.appliedCourses = appliedCourses;
    }

    public String getPreviousCourses() {
        return previousCourses;
    }

    public void setPreviousCourses(String previousCourses) {
        this.previousCourses = previousCourses;
    }
}
