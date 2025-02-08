/* 6. Problem Statement: Comparing Different Data Structures for Searching
Objective:
Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching elements.
Approach:
Array: Linear search (O(N)).
HashSet: Uses hashing (O(1) on average).
TreeSet: Balanced BST (O(log N)).

Expected Result:
HashSet is fastest for lookups but requires extra memory.
TreeSet maintains order but is slightly slower than HashSet.
 */

package com.time_complexity_comparison;
import java.util.HashMap;
import java.util.Random;

public class ComparingDataStructures {

    public static boolean linearSearch(int[] arr, int target) {
        for (int it : arr) {
            if (it == target) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Random ran = new Random();
        int[] arr1 = new int[1001];
        int[] arr2 = new int[10001];
        int[] arr3 = new int[100001];


        for (int i = 0; i < 1001; i++) {
            arr1[i] = ran.nextInt(999);
        }
        for (int i = 0; i < 10001; i++) {
            arr2[i] = ran.nextInt(9999);
        }
        for (int i = 0; i < 100001; i++) {
            arr3[i] = ran.nextInt(99999);
        }

        int target = 998;
        arr1[997] = target;
        arr2[9997] = target;
        arr3[99997] = target;


        long start, end;
        double time;
        boolean isPresent;


        // Linear Search and HashMap for arr1
        start = System.nanoTime();
        isPresent = linearSearch(arr1, target);
        end = System.nanoTime();
        time = (end - start) / 1000000.0;
        System.out.println("Time taken to find in 1000 dataset (Using LinearSearch): " + time);


        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int it : arr1) {
            map1.put(it, 1);
        }
        start = System.nanoTime();
        isPresent = map1.containsKey(target);
        end = System.nanoTime();
        time = (end - start) / 1000000.0;
        System.out.println("Time taken to find in 1000 dataset (using HashMap): " + time);


        // Linear Search and HashMap for arr2
        start = System.nanoTime();
        isPresent = linearSearch(arr2, target);
        end = System.nanoTime();
        time = (end - start) / 1000000.0;
        System.out.println("Time taken to find in 10000 dataset (Using LinearSearch): " + time);


        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int it : arr2) {
            map2.put(it, 1);
        }
        start = System.nanoTime();
        isPresent = map2.containsKey(target);
        end = System.nanoTime();
        time = (end - start) / 1000000.0;
        System.out.println("Time taken to find in 10000 dataset (using HashMap): " + time);


        // Linear Search and HashMap for arr3
        start = System.nanoTime();
        isPresent = linearSearch(arr3, target);
        end = System.nanoTime();
        time = (end - start) / 1000000.0;
        System.out.println("Time taken to find in 100000 dataset (Using LinearSearch): " + time);


        HashMap<Integer, Integer> map3 = new HashMap<>();
        for (int it : arr3) {
            map3.put(it, 1);
        }
        start = System.nanoTime();
        isPresent = map3.containsKey(target);
        end = System.nanoTime();
        time = (end - start) / 1000000.0;
        System.out.println("Time taken to find in 100000 dataset (Using HashMap): " + time);
    }
}