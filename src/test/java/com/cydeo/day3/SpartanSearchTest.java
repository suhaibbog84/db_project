package com.cydeo.day3;

import org.testng.annotations.Test;

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

    @Test
    public void testSearchByGender(){

        // Assuming you already used your awesome webdriver knowledge
        // to get actual result from that total count
        // or by counting the web table row and get below result

        int actualResultMale = 53;
        int actualResultFemale = 47;

        // now get expected result from database query
        // For MALE : SELECT COUNT(*) AS MALE_COUNT FROM SPARTAN WHERE GENDER = 'MALE'
        // For FEMALE : SELECT COUNT(*) AS FEMALE_COUNT FROM SPARTAN WHERE GENDER = 'FEMALE'




    }
}
