package com.cydeo.day3;

import com.cydeo.utility.DB_Util;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Background : on Spartan UI All Data page ,
 * Search functionality has been acting up
 * It does not always return correct result count
 * You opened the defect , it has been fixed
 * and yet it occasionally comes back again
 * Now you are writing automated test to make sure
 * it works all the times
 *  few scenario you came up with
 *    search by gender should work
 *    search by partial name should work
 *    search by partial name + gender should also work
 */

public class SpartanSearchTest {

    @BeforeClass
    public void setup(){

        // create connection ONLY ONCE! for all tests in this class
        String url = "jdbc:oracle:thin:@54.235.2.232:1521:XE";
        String username = "SP";
        String password = "SP";

        DB_Util.createConnection(url, username, password);
    }

    @AfterClass
    public void teardown(){
        // tear down the connection only once after all the tests in this class
        DB_Util.destroy();
    }

    @Test
    public void testSearchByGenderMale() {

        // Assuming you already used your awesome webdriver knowledge
        // to get actual result from that total count
        // or by counting the web table row and get below result

        int actualResultMale = 53;
        int actualResultFemale = 47;

        // now get expected result from database query
        // For MALE : SELECT COUNT(*) AS MALE_COUNT FROM SPARTANS WHERE GENDER = 'MALE'
        // For FEMALE : SELECT COUNT(*) AS FEMALE_COUNT FROM SPARTANS WHERE GENDER = 'FEMALE'

        DB_Util.runQuery("SELECT COUNT(*) AS MALE_COUNT FROM SPARTANS WHERE GENDER = 'Male'");
        int expectedMaleResult = Integer.parseInt(DB_Util.getFirstRowFirstColumn());

        // assert Male
        assertEquals(actualResultMale, expectedMaleResult);


        DB_Util.runQuery("SELECT COUNT(*) AS FEMALE_COUNT FROM SPARTANS WHERE GENDER = 'Female'");
        int expectedFemaleResult = Integer.parseInt(DB_Util.getFirstRowFirstColumn());

        // assert Female
        assertEquals(actualResultFemale, expectedFemaleResult);

    }

}