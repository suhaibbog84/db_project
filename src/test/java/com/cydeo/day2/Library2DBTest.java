package com.cydeo.day2;

import java.sql.*;

public class Library2DBTest {

    public static void main(String[] args) throws SQLException {


        String url = "jdbc:mysql://34.230.35.214:3306/library2";
        String username = "library2_client";
        String password = "6s2LQQTjBcGFfDhY";

        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM books");

        /*
        while (rs.next()) {
            System.out.println("rs.getString(\"name\") = "
                    + rs.getString("name"));
        }
         */

        rs.next(); // row 1
        System.out.println("rs.getString(\"name\") = " + rs.getString("name"));

        //What if now I want to run this query : select count(*) from books
        //Just call tge message again and save the result
        // into rs variable or new variable with type ResultSet
        rs = stmt.executeQuery("SELECT COUNT(*) AS BOOK_COUNT from books");
        //move to the first row
        rs.next();
        System.out.println("rs.getString(\"BOOK_COUNT\") = "
                + rs.getString("BOOK_COUNT"));

        //Can I not overwrite previous ResultSet object and save it into new
        // ResultSet variable
        //YES you CAN

        ResultSet rs2 = stmt.executeQuery("SELECT * AS BOOK_COUNT from users");




    }
}
