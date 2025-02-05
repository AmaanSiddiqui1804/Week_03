/* StringBuilder Problem 1: Reverse a String Using StringBuilder
Problem:
Write a program that uses StringBuilder to reverse a given string. For example, if the input is "hello",
the output should be "olleh".
Approach:
Create a new StringBuilder object.
Append the string to the StringBuilder.
Use the reverse() method of StringBuilder to reverse the string.
Convert the StringBuilder back to a string and return it.
 */
package com.string_builder;

public class ReverseString {
    public static void main(String[] args) {

        //Creating an object of string builder
        StringBuilder str = new StringBuilder();

        //Adding hello to string builder str
        str.append("hello") ;

        //Using .reverse method to reverse the String str
        str.reverse();

        //Printing the result
        System.out.println(str.toString());
    }
}
