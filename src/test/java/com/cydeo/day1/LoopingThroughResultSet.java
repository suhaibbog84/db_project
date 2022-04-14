package com.cydeo.day1;

import java.sql.*;

public class LoopingThroughResultSet {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE";
        String username = "hr";
        String password = "hr";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

            //keep looping to next rows until there are no more rows and condition is false
            while (rs.next()){

                System.out.println("rs.getString(\"REGION_NAME\") = "
                        + rs.getString("REGION_NAME"));

            }
            /* where is your pointer right now??--> AfterLast Location
            //below line will throw exception because we are at afterlast location
             System.out.println("rs.getString(\"REGION_NAME\") = "
                    + rs.getString("REGION_NAME"));
             */

            rs.previous();

        } catch (SQLException e) {
            System.out.println("Exception Occurred " + e.getMessage());
            e.printStackTrace();
        }


    }
}
