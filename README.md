
# Course RegistrTaskation

In this project, the admin/faculty can create or delete course and can be assigned to that faculty member.
Students can then apply to these courses of respective branches. the faculty can then approved or decline the courses submitted by Students. 


## Demo Video Of The Project

link


## Installation

download mySQL from this website https://dev.mysql.com/downloads/installer/

go for custom setup type and select these options:
1. mySQL Server 8.0.35
2. MySQL Workbench 8.0.34
3. MySQL Shell 8.0.35
4. MySQL Router 8.0.32
5. MySQL Connectors, then Connector/J 8.0.32

Use this video as reference if stil confused from 3:40 till 11:18- https://www.youtube.com/watch?v=u0o_VTxImVk&t=912s&ab_channel=CodingWallahSir

setup mySQL Workbench and run this query to Create all the tables

```bash
  -- Create the database
CREATE DATABASE IF NOT EXISTS courseregister;

-- Use the courseregister database
USE courseregister;

-- Create the students table
CREATE TABLE IF NOT EXISTS students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    department VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    degree VARCHAR(255),
    studentid VARCHAR(255) PRIMARY KEY UNIQUE
);

-- Create the courses table
CREATE TABLE IF NOT EXISTS courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    course_id VARCHAR(255) PRIMARY KEY UNIQUE,
    course_name VARCHAR(255),
    department VARCHAR(255),
    description VARCHAR(255),
    prerequisites VARCHAR(255),
    credits VARCHAR(255),
    slots VARCHAR(255),
    teacher VARCHAR(255)
);

-- Create the teachers table
CREATE TABLE IF NOT EXISTS teachers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    faculty_id VARCHAR(255) PRIMARY KEY UNIQUE,
    department VARCHAR(255)
);

-- Create the student_courses table
CREATE TABLE IF NOT EXISTS student_courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    student_id VARCHAR(255),
    course_id VARCHAR(255),
    status ENUM('pending', 'approved', 'declined'),
    faculty_id VARCHAR(255),
    FOREIGN KEY (student_id) REFERENCES students(studentid),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (faculty_id) REFERENCES teachers(faculty_id)
);
```


Now For IDE I would recommend using `Intellij Idea Ultimate Edition` as it will be easy to run the web project.
It is free for Students and you just have to enter your student mail to unlock the IDE.

Now install `Apache Tomcat` from this website: 
https://tomcat.apache.org/download-10.cgi

Download the core version. Remember the location of you file as you will need to locate it later


Now you need the github clone url. The Github clone url is found in `code` option which is green in color

Once you have the IDE, click on the top right option given as `Get from VCS`.
Once you click the option paste the github clone url, and clone the project.

Now we need to setup the tomcat server. Head on to `Edit Configuration` (located beside the run button at the top), and add a new Configuration option,then scroll till you find `TomEE server` option click `Local`

Now Name it Tomcat and click the `Configure...` option, then for both `TomEE Home` and `TomEE base directory` go to your tomcat file location which should look something like this `apache-tomcat-10.1.17`

if you are still facing problem, follow this tutorial:
https://www.youtube.com/watch?v=Tf-xyLBW9nI&ab_channel=PersonalClasses

Now once you do it, it some look something like this 

![image](https://github.com/Broilzzz/IRIS_Rec24_221EE103_Java-JSP-Servlet-MySQL-Bootstrap/assets/123230400/4e17ecee-4af4-4a98-9bd0-ce51bb2d6c73)



Now got to the project and file under `src/main/java/org.ahil.course_registertaskation/db/DBconnect`
as we need to connect our MySQL Database to our IDE using `JDBC`

Change the username and password to what you have initialized on your MySQL.

Once that is done you can now run the project by click the run button at the top
## List of Implemented Features

    1. created a login page for admin, faculty and students 
    2. created a signup page for students to create an account
    3. addition of faculty from the admin panel
    4. admin can remove any student or faculty
    5. admin can add or remove courses from system
    6. faculty can only add courses to the system
    7. students can apply to courses of their specific department only with the 
    respected faculty who has to have been added to the system
    8. faculty whom the students have courses registered and applied to can
    either accept or declined the request
    9. students can view all the applied courses and their status(applied,
    declined,pending)
    10. students can view their current courses that have been accepted

## Screenshots

![Screenshot 2024-01-10 200139](https://github.com/Broilzzz/cohort/assets/123230400/95561a70-86d4-43cf-9d2b-2902775232ee)
