/* Linear Search Problem 1: Search for the First Negative Number
Problem:
You are given an integer array. Write a program that performs Linear Search
to find the first negative number in the array.
If a negative number is found, return its index. If no negative number is found, return -1.
Approach:
Iterate through the array from the start.
Check if the current element is negative.
If a negative number is found, return its index.
If the loop completes without finding a negative number, return -1.
 */
package com.linear_search;

public class FirstNegativeNumber {
    static int linearSearch(int [] inputArray) {
    int indexValue ;
        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] < 0) {
                indexValue = i;
                return indexValue;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        int[] arr = {12, 45, 0, 5, 95, -3, 7, -1, 20, -30};
        System.out.println("First negative element found at index: " + linearSearch(arr));

    }
}
