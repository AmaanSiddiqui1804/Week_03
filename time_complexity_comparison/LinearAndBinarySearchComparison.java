/* 1. Problem Statement: Search a Target in a Large Dataset
Objective:
Compare the performance of Linear Search (O(N)) and Binary Search (O(log N)) on different dataset sizes.
Approach:
Linear Search: Scan each element until the target is found.
Binary Search: Sort the data first (O(N log N)), then perform O(log N) search.

Expected Result:
Binary Search performs much better for large datasets, provided data is sorted.
 */
package com.time_complexity_comparison;

import java.util.Arrays;
import java.util.Random;

public class LinearAndBinarySearchComparison {

    // Linear Search
    static void linearSearch(int[] arr, int target) {
        long startTime, endTime, totalTime;
        int pos = -1;

        System.out.println("\nPerforming Linear Search ");
        startTime = System.nanoTime();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                pos = i;
                break;
            }
        }
        endTime = System.nanoTime();

        if (pos != -1) {
            System.out.println("Target found at index: " + pos);
        } else {
            System.out.println("Target not found.");
        }
        totalTime = (endTime - startTime) / 1_000_000 ;
        System.out.println("Time taken by Linear Search: " + totalTime + " ms.");
        System.out.println("Time taken by Linear Search: " + (endTime - startTime) + " ns.");
    }

    // Binary Search
    static void binarySearch(int[] arr, int target) {
        Arrays.sort(arr);  // Sorting required for Binary Search

        long startTime, endTime, netTime;
        startTime = System.nanoTime();
        int pos = Arrays.binarySearch(arr, target);
        endTime = System.nanoTime();

        if (pos >= 0) {
            System.out.println("Target found at index: " + pos + " (after sorting)");
        } else {
            System.out.println("Target not found.");
        }
        netTime = (endTime - startTime) / 1_000_000 ;
        System.out.println("Time taken by Binary Search (including sorting): " + netTime + " ms.");
        System.out.println("Time taken by Binary Search (including sorting): " + (endTime - startTime) + " ns.");
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Creating different dataset sizes
        int[] arr1 = new int[1000];
        int[] arr2 = new int[10_000];
        int[] arr3 = new int[1_000_000];

        //generating random numbers and storing it in array
        for (int i = 0; i < arr1.length; i++)
            arr1[i] = random.nextInt(1000) + 1;

        for (int i = 0; i < arr2.length; i++)
            arr2[i] = random.nextInt(10_000) + 1;

        for (int i = 0; i < arr3.length; i++)
            arr3[i] = random.nextInt(1_000_000) + 1;

        // Ensuring target exists in each array
        int target = 998;
        arr1[666] = target;
        arr2[6666] = target;
        arr3[66666] = target;

        // Perform searches on all dataset sizes
        System.out.println("\n Dataset Size: 1000 Elements");
        linearSearch(arr1, target);
        binarySearch(arr1, target);

        System.out.println("\n Dataset Size: 10,000 Elements");
        linearSearch(arr2, target);
        binarySearch(arr2, target);

        System.out.println("\n Dataset Size: 1,000,000 Elements");
        linearSearch(arr3, target);
        binarySearch(arr3, target);
    }
}
