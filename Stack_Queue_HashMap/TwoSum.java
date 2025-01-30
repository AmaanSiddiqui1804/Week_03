package com.two_sum_problem;

import java.util.HashMap;
public class TwoSum {

    // Method to find two indices such that their values add up to the target.
    public static int[] twoSum(int[] nums, int target) {
        // HashMap to store the index of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traversing the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Checking if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return the indices
            }

            // Adding the current element and its index to the map
            map.put(nums[i], i);
        }

        // No such pair found
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5};
        int target = 10;

        int[] result = twoSum(nums, target);

        if (result != null) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
    }
}
