/*Insertion Sort - Sort Employee IDs
Problem Statement:
A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the
employee IDs in ascending order.
Hint:
Divide the array into sorted and unsorted parts.
Pick an element from the unsorted part and insert it into its correct position in the sorted part.
Repeat for all elements.
 */

package com.insertion_sort;
import java.util.Arrays;
public class EmployeeIDs {
    public static void insertionSort(int[] iDs) {
            int n = iDs.length;
            for (int i = 1; i < n; i++) {
                int key = iDs[i];
                int j = i - 1;
                // Move elements that are greater than key to one position ahead
                while (j >= 0 && iDs[j] > key) {
                    iDs[j + 1] = iDs[j];
                    j--;
                }
                iDs[j + 1] = key;
            }
    }

    public static void main(String[] args) {
            int[] iDs = {102, 107, 121, 123, 125, 106, 101, 105, 108, 103};
            insertionSort(iDs);
            System.out.println("Sorted Employee Id's: " + Arrays.toString(iDs));
    }
}
