package com.cydeo.day2;

import com.cydeo.utility.DB_Util;

public class DB_Util_Practice {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        //This will create a connection and save the connection to static variable of utility
        DB_Util.createConnection(url, username, password);

        //This will execute query and save the query result to static variable of utility
        DB_Util.runQuery("SELECT * FROM COUNTRIES");

        //THIS WILL PRINT OUT EVERY CELL IN THE RESULT
        DB_Util.displayAllData();

        //get the country name from second row
        System.out.println("DB_Util.getCellValue(2, \"COUNTRY_NAME\") = "
                + DB_Util.getCellValue(2, "COUNTRY_NAME"));

        //get second column from second row
        System.out.println("DB_Util.getCellValue(2, 2) = "
                + DB_Util.getCellValue(2, 2));

        //get row count
        System.out.println("DB_Util.getRowCount() = "
                + DB_Util.getRowCount());

        //get column count
        System.out.println("DB_Util.getColumnCount() = "
                + DB_Util.getColumnCount());

        // This will clean up resultSet
        DB_Util.destroy();



    }
}
