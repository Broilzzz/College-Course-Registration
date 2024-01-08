package org.ahil.course_registertaskation.users;

public class Faculty {
    private String name;
    private String email;



    private String password;
    private String faculty_id;
    private String department;

    public Faculty(String name, String email, String password, String faculty_id, String department){
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        this.faculty_id = faculty_id;
        this.department = department;
    }
    public Faculty(){

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFaculty_id() {
        return faculty_id;
    }

    public void setFaculty_id(String faculty_id) {
        this.faculty_id = faculty_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
