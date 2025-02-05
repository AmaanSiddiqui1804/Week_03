/* StringBuilder Problem 2: Remove Duplicates from a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to remove all duplicate characters from a given string while
maintaining the original order.
Approach:
Initialize an empty StringBuilder and a HashSet to keep track of characters.
Iterate over each character in the string:
If the character is not in the HashSet, append it to the StringBuilder and add it to the HashSet.
Return the StringBuilder as a string without duplicates.
 */
package com.string_builder;

import java.util.HashSet;
import java.util.Scanner;
public class DuplicateRemove {

    //Method to remove duplicate characters
    static String removeDuplicate(String originalString) {
        StringBuilder str = new StringBuilder();
        HashSet <Character> originals = new HashSet<>();

        //Converting string to lowercase
        originalString = originalString.toLowerCase();

        for (int i = 0; i < originalString.length(); i++) {
            char c = originalString.charAt(i);
            if (!originals.contains(c)) {
                str.append(c);
                originals.add(c);
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Taking user input for string
        System.out.println("Enter a text to remove duplicate characters: ");
        String originalString = input.next();

        //Output
        System.out.println("Unique String: " + removeDuplicate(originalString));
        input.close();
    }
}
