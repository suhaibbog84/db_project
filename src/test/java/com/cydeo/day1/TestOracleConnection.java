package com.cydeo.day1;

import java.sql.*;

public class TestOracleConnection {

    public static void main(String[] args) throws SQLException {

        // Step 1: create a connection by providing connection information
        //this connection jdbc url , also known as connection string
        //syntax look like this
        //            jdbc:DataBaseType:subprotocal:@Host:port:SID
        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE";
        String username = "hr";
        String password = "hr";

        //now JDBC provide utility class called DriverManager with many methods
        // the getConnection method accept 3 parameters url, username, password
        // according to this information ,
        // it will first look for the driver of the database type you are connecting to
        // it once it's found , use the rest of connection information like
        // host ip , username password , port , sid to make connection
        // MAKE SURE YOUR CONNECTION WORK MANUALLY ,
        // ANYTHING DOES NOT WORK MANUALLY WILL NOT WORK AUTOMATION

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Successfully Connected");

        //Once we have the connection , now we use this connection object to create a statement object
        Statement stmt = conn.createStatement();

        //Once we have statement object now we can execute query to get result set
        //RESULTSET OBJECT STORE ALL THE ROW DATA
        //It uses iterator to move through the row using cursor to hold the
        //position where it's currently at
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

        //
        rs.next(); //now we are at the 1st row

        //The resulting data has two column REGION_ID, REGION_NAME
        //in order to access the cell value we can use getX method
        // that accepts 1 parameter , either using column name or using 1 based index
        //getString, GetInt, GetDouble, ...etc

        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));

        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        //you can also use column index
        System.out.println("rs.getString(1) = " + rs.getString(1));
        System.out.println("rs.getString(2) = " + rs.getString(2));

        //now we want to move to the next row
        rs.next();

        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));

        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        //now we want to move to the next row... now we are at the third row
        rs.next();

        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));

        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        //now we want to move to the next row... now we are at the 4th row
        rs.next();

        System.out.println("rs.getString(\"REGION_ID\") = "
                + rs.getString("REGION_ID"));

        System.out.println("rs.getString(\"REGION_NAME\") = "
                + rs.getString("REGION_NAME"));

        System.out.println("rs.next() = " + rs.next());


    }
}
