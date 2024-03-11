package com.mycompany.app;

import java.util.ArrayList;

/*
    1) We convert each integer in firstArray and secondArray to its corresponding
    ASCII character using a cast to (char).
    2) We then concatenate these ASCII characters into concatenatedString.
    3) Then it repeats concatenatedString multiplier times and appends lastChar which is letter to the end.
    4) Finally, it returns the resulting string.

*/
public class App 
{
    public static String stringManipulation(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray, int multiplier, char lastChar) {

        StringBuilder concatenatedString = new StringBuilder();

        // check if the arrays are empty
        if (firstArray.isEmpty() || secondArray.isEmpty()) {
            return null;
        }

        // check if the multiplier is non-negative
        if (multiplier < 0) {
            return null;
        }

        // check if the lastChar is proper character
        if (!Character.isLetter(lastChar)) {
            return null;
        }

        // Convert firstArray to string and append to concatenatedString
        for (int num : firstArray) {
            concatenatedString.append((char) num);
        }

        // Convert secondArray to string and append to concatenatedString
        for (int num : secondArray) {
            concatenatedString.append((char) num);
        }

        // Create the final string by repeating concatenatedString 'multiplier' times
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            finalString.append(concatenatedString);
        }

        // Append the lastChar to the final string
        finalString.append(lastChar);

        return finalString.toString();
    }
}
