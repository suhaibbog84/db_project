package com.cydeo.day1;

import java.sql.*;

public class FlexibleNavigation {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE";
        String username = "hr";
        String password = "hr";

        Connection conn = DriverManager.getConnection(url,username,password) ;
        // creating statement this way will only allow to
        // get resultSet that forward only when we execute Query

        //Statement stmt = conn.createStatement();
        //In order to be able to move through any row in the resultSet
        //with the help of resultSet navigation methods like next previous absolute
        //we need to create Statement object in the below way
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs   = stmt.executeQuery("SELECT * FROM REGIONS") ;

        /**
         * In order to access data in ResultSet object , we need to use cursor navigation methods :
         *
         * next() -move to next row and return true false according to if we have valid row
         * previous() -move to previous row and return true false according to if we have valid row
         * first() - move to first row from anywhere
         * last() - move to last row from anywhere
         * beforeFirst() - move to before first location from anywhere
         * afterLast() - move to after last location from anywhere
         * absolute(8) - move to any row by using row number , for example 8 in this case
         */

        rs.next(); // row 1
        System.out.println("rs.next() " + rs.getString("REGION_ID") + " "
                + rs.getString("REGION_NAME"));

        rs.last(); // last row , row 4
        System.out.println("rs.last() " + rs.getString("REGION_ID") + " "
                + rs.getString("REGION_NAME"));

        rs.first(); // row 1
        System.out.println("rs.first() " + rs.getString("REGION_ID") + " "
                + rs.getString("REGION_NAME"));

        rs.absolute(3); // row 3
        System.out.println("rs.absolute(3) " + rs.getString("REGION_ID") + " "
                + rs.getString("REGION_NAME"));

        rs.previous(); // row 2
        System.out.println("rs.previous() " + rs.getString("REGION_ID") + " "
                + rs.getString("REGION_NAME"));

        rs.beforeFirst(); //this method just puts you all the way at the top, so you can start all over
       // System.out.println("rs.beforeFirst() " + rs.getString("REGION_ID") + " "
         //       + rs.getString("REGION_NAME"));
        rs.next();
        rs.afterLast(); //we are at the after last location, we use it once we want to go
        // backward using the loop.
        rs.previous();
        System.out.println("rs.previous() " + rs.getString("REGION_ID") + " "
                + rs.getString("REGION_NAME"));

    }
}
