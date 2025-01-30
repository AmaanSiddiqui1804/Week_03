package com.target_pair_in_an_array;

import java.util.HashMap;
public class PairWithGivenSum {

    // Method to check if there exists a pair of elements in the array
    public static boolean hasPairWithSum(int[] arr, int target) {
        // HashMap to store visited numbers
        HashMap<Integer, Boolean> visited = new HashMap<>();

        // Traversing the array
        for (int num : arr) {
            // Calculating the required complement for the current number
            int complement = target - num;

            // Checking if the complement exists in the HashMap
            if (visited.containsKey(complement)) {
                return true; // Pair found
            }

            // Adding the current number to the HashMap
            visited.put(num, true);
        }

        // No pair found
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 5, 3, 2, 8};
        int target = 10;

        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair with sum " + target + " exists.");
        } else {
            System.out.println("No pair with sum " + target + " exists.");
        }
    }
}

