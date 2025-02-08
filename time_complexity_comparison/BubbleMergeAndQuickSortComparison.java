/* Problem Statement: Sorting Large Data Efficiently
Objective:
Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and Quick Sort (O(N log N)).
Approach:
Bubble Sort: Repeated swapping (inefficient for large data).
Merge Sort: Divide & Conquer approach (stable).
Quick Sort: Partition-based approach (fast but unstable).
 */
package com.time_complexity_comparison;

import java.util.Arrays;
import java.util.Random;

public class BubbleMergeAndQuickSortComparison {

    static void bubbleSort(int[] arr) {

        long startTime, endTime, netTime;
        System.out.println("Performing Bubble Sort");
        startTime = System.nanoTime();
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        endTime = System.nanoTime();
        netTime = (endTime - startTime)/1000_000;
        System.out.println("Time taken by by Bubble Sort: " + netTime + " ms.");
        System.out.println("Time taken by by Bubble Sort: " + (endTime-startTime) + " ns.");

    }

    static void mergeSort(int[] arr) {

        if (arr.length < 2) {
            return;  // Base case: an array of size 1 is already sorted
        }

        // Dividing the array into two halves
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merging the sorted halves
        merge(arr, left, right);

    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Merge the arrays in sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                k++;
                i++;
            } else {
                arr[k] = right[j];
                k++ ;
                j++ ;
            }
        }

        // Copying remaining elements from left, if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copying remaining elements from right, if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Wrapper function to measure Merge Sort execution time
    static void mergeSortWithTiming(int[] arr) {
        System.out.println("Performing Merge Sort");
        long startTime = System.nanoTime();
        mergeSort(arr);  // Call the recursive mergeSort function
        long endTime = System.nanoTime();
        long netTime = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken by Merge Sort: " + netTime + " ms.");
    }

    //Method to calculate sorting time in quickSort
    static void quickSort(int[] arr) {
        long startTime, endTime, netTime;
        System.out.println("Performing Quick Sort");
        startTime = System.nanoTime();

        quickSortTiming(arr, 0, arr.length-1);

        endTime = System.nanoTime();
        netTime = (endTime - startTime)/1000_000;
        System.out.println("Time taken by by Quick Sort: " + netTime + " ms.");
        System.out.println("Time taken by by Quick Sort: " + (endTime-startTime) + " ns.");
    }
    static void quickSortTiming(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);

            //Recursively sort elements before and after partition
            quickSortTiming(arr, low, p-1);
            quickSortTiming(arr, p+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                //Swapping i and j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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


        // Sorting on all dataset sizes
        System.out.println("\n Dataset Size: 1000 Elements");
        bubbleSort(Arrays.copyOf(arr1, arr1.length));
        mergeSortWithTiming(Arrays.copyOf(arr1, arr1.length));
        quickSort(Arrays.copyOf(arr1, arr1.length));

        System.out.println("\n Dataset Size: 10,000 Elements");
        bubbleSort(Arrays.copyOf(arr2, arr2.length));
        mergeSortWithTiming(Arrays.copyOf(arr2, arr2.length));
        quickSort(Arrays.copyOf(arr2, arr2.length));

        System.out.println("\n Dataset Size: 1,000,000 Elements");
        //bubbleSort(Arrays.copyOf(arr3, arr3.length));
        mergeSortWithTiming(Arrays.copyOf(arr3, arr3.length));
        quickSort(Arrays.copyOf(arr3, arr3.length));
    }
}