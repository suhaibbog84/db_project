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

        //get all column name as list
        System.out.println("DB_Util.getAllColumnNamesAsList() = "
                + DB_Util.getAllColumnNamesAsList());

        //get entire third row as list
        System.out.println("DB_Util.getRowDataAsList(3) = "
                + DB_Util.getRowDataAsList(3));

        //Get the entire second column as list
        System.out.println("DB_Util.getColumnDataAsList(2) = \n\t"
                + DB_Util.getColumnDataAsList(2));

        //get the COUNTRY_NAME column as list of string
        System.out.println("DB_Util.getColumnDataAsList(\"COUNTRY_NAME\") = \n\t"
                + DB_Util.getColumnDataAsList("COUNTRY_NAME"));

        //get the second row as Map<String, String>
        System.out.println("DB_Util.getRowMap(2) = \n\t" + DB_Util.getRowMap(2));

        //get all rows as list of maps
        System.out.println("DB_Util.getRowDataAsList(2) = \n\t"
                + DB_Util.getRowDataAsList(2));

        //run this query and get the only cell in the result
        // SELECT COUNT(*) COUNT from EMPLOYEES
        DB_Util.runQuery("SELECT COUNT(*) COUNT FROM EMPLOYEES");
        System.out.println("DB_Util.getFirstRowFirstColumn() = "
                + DB_Util.getFirstRowFirstColumn());

        // This will clean up resultSet
        DB_Util.destroy();



    }
}
