/* StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
Problem:
You are given an array of strings. Write a program that uses StringBuffer to concatenate all the strings in the
array efficiently.
Approach:
Create a new StringBuffer object.
Iterate through each string in the array and append it to the StringBuffer.
Return the concatenated string after the loop finishes.
Using StringBuffer ensures efficient string concatenation due to its mutable nature.
 */
package com.string_buffer;

import java.util.Scanner;
public class StringConcatenation {
    // Method to concatenate string using String buffer
    static String concatenate(String[] strArray) {
        // StringBuffer to hold the concatenated result
        StringBuffer result = new StringBuffer();

        // Efficiently appending each string to the StringBuffer
        for (String str : strArray) {
            result.append(str).append(" ");  // Added space for better readability
        }

        // Removing the last unnecessary space (if added)
        if (!result.isEmpty()) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of string array i.e No. of words in String");
        int n = input.nextInt();
        System.out.println("Enter string: ");
        String [] userInput = new String[n];
        for(int i = 0 ; i < n ; i++){
            userInput[i] = input.next();
        }

        System.out.println("Concatenated string: " + concatenate(userInput));
        input.close();
    }
}
