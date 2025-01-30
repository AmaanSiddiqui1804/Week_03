package com.longest_consecutive_sequence;

import java.util.HashSet;
public class LongestConsecutiveSequence {

    // Method to find the length of the longest consecutive sequence in the array.
    public static int longestConsecutive(int[] nums) {
        // HashSet to store all unique numbers
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Traversing the HashSet
        for (int num : numSet) {
            // Checking if the current number is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Finding the length of the consecutive sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Updating the longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        System.out.println("Length of the longest consecutive sequence: " + longestConsecutive(nums));
    }
}