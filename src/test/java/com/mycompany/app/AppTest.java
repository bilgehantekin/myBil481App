package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    // Test the method with valid input
    public void testStringManipulationWithValidInput() {
        ArrayList<Integer> firstArray = new ArrayList<>();
        firstArray.add(65);

        ArrayList<Integer> secondArray = new ArrayList<>();
        secondArray.add(66);

        int multiplier = 2;
        char lastChar = 'X';

        String expectedResult = "ABABX";

        assertEquals(expectedResult, App.stringManipulation(firstArray, secondArray, multiplier, lastChar));
    }

    // Test the method with empty arrays
    public void testStringManipulationWithEmptyArrays() {
        ArrayList<Integer> firstArray = new ArrayList<>();

        ArrayList<Integer> secondArray = new ArrayList<>();

        int multiplier = 2;
        char lastChar = 'X';

        assertNull(App.stringManipulation(firstArray, secondArray, multiplier, lastChar));
    }

    // Test the method with negative multiplier
    public void testStringManipulationWithNegativeMultiplier() {
        ArrayList<Integer> firstArray = new ArrayList<>();
        firstArray.add(65);

        ArrayList<Integer> secondArray = new ArrayList<>();
        secondArray.add(66);

        int multiplier = -2;
        char lastChar = 'X';

        assertNull(App.stringManipulation(firstArray, secondArray, multiplier, lastChar));
    }

    // Test the method with invalid char
    public void testStringManipulationWithInvalidLastChar() {
        ArrayList<Integer> firstArray = new ArrayList<>();
        firstArray.add(65);

        ArrayList<Integer> secondArray = new ArrayList<>();
        secondArray.add(66);

        int multiplier = 2;
        char lastChar = '.';

        assertNull(App.stringManipulation(firstArray, secondArray, multiplier, lastChar));
    }

    // Test the method with multiplier which is 0
    public void testStringManipulationWithZeroMultiplier() {
        ArrayList<Integer> firstArray = new ArrayList<>();
        firstArray.add(65);

        ArrayList<Integer> secondArray = new ArrayList<>();
        secondArray.add(66);
        
        int multiplier = 0;
        char lastChar = 'X';

        String expectedResult = "X";

        assertEquals(expectedResult, App.stringManipulation(firstArray, secondArray, multiplier, lastChar));
    }
}
