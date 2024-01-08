package org.ahil.course_registertaskation.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
    private static Connection conn;
    public static Connection getConn(){
        try{
            String url = "jdbc:mysql://localhost:3306/courseregister";   //add your own database name if you want or use mine
            String username = "root"; //add your username from your mySQL
            String password = "A10102004a!"; //add your password from your mySQL

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();

        }

        return conn;
    }


}
