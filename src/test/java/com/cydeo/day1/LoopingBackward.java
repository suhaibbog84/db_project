package com.cydeo.day1;

import java.sql.*;

public class LoopingBackward {

    public static void main(String[] args) throws SQLException {

        //print all Employees Employee_ID and FIRST_NAME backward
        // SELECT * EMPLOYEES (do not SORT THIS)
        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url,username,password) ;
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM EMPLOYEES") ;

        //USE AfterLast() METHOD TO GO TO AFTER LAST LOCATION

        rs.afterLast();
        while (rs.previous()){

            System.out.println(rs.getString("EMPLOYEE_ID") + " "
                    + rs.getString("FIRST_NAME"));

        }



    }
}
