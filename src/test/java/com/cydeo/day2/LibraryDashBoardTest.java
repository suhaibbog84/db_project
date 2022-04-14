package com.cydeo.day2;

import com.cydeo.utility.DB_Util;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LibraryDashBoardTest {

    @Test
    public void testDashboardNumbers(){

        // Dashboard numbers are previously not matching the database numbers
        // the test is meant to check
        // the actual results from dashboard page matches database results

        int actualBookCount = 971;

        //Expected result we can get from running this query
        // SELECT COUNT(*) AS BOOK_COUNT FROM books

        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE" ;
        String username = "hr" ;
        String password = "hr" ;

        DB_Util.createConnection(url, username, password);
        DB_Util.runQuery("SELECT COUNT(*) AS BOOK_COUNT FROM books");
        int expectedBookResult = Integer.parseInt(DB_Util.getFirstRowFirstColumn());

        //import static org.testNG.Assert.assertEquals;
        Assert.assertEquals(actualBookCount, expectedBookResult);

        //destroy your connection
        DB_Util.destroy();


    }
}
