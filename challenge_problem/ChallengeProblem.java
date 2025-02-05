/* Challenge Problem (for both Linear and Binary Search)
Problem:
You are given a list of integers. Write a program that uses Linear Search to find the
first missing positive integer in the list and Binary Search to find the index of a given target number.
                                                        Approach:
Linear Search for the first missing positive integer:
Iterate through the list and mark each number in the list as visited (you can use negative marking or a separate array).
Traverse the array again to find the first positive integer that is not marked.
Binary Search for the target index:
After sorting the array, perform binary search to find the index of the given target number.
Return the index if found, otherwise return -1.
 */

package com.challenge_problem;
import java.util.Arrays;
public class ChallengeProblem {

    // Method to find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {

        int n = nums.length ;
        //If array is empty
        if(nums.length == 0) return 1 ;

        //If array contiains 1 as smallest integer
        boolean containsOne = false;
        for (int num : nums) {
            if (num == 1) {
                containsOne = true;
                break;
            }
        }
        if (!containsOne) {
            return 1;
        }

        // Cleaning up the array
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1; // Replace invalid numbers with 1
            }
        }

        // Marking visited numbers using negative sign
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]); //Taking absolute
            if (num == n) {
                nums[0] = -Math.abs(nums[0]); // Use index 0 for number n
            } else {
                nums[num] = -Math.abs(nums[num]); // Mark as visited
            }
        }

        //Finding the first missing positive
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i; // Missing positive is i
            }
        }

        // Check if n is missing
        if (nums[0] > 0) {
            return n;
        }

        // If all numbers from 1 to n are present, return n + 1
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;  // Target found
            } else if (arr[mid] < target) {
                left = mid + 1; // Searching in right half
            } else {
                right = mid - 1; // Searching in left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 8, 6, -1, 1};  // Sample input
        int target = 3;

        int missing = findFirstMissingPositive(arr);
        System.out.println("First Missing Positive: " + missing);

        // Sorting the array for binary search
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Performing binary search
        int index = binarySearch(arr, target);
        System.out.println("Index of " + target + ": " + index);
    }
}