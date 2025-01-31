/* Heap Sort - Sort Job Applicants by Salary
Problem Statement:
A company receives job applications with different expected salary demands. Implement Heap Sort to sort these salary demands in ascending order.
Hint:
Build a Max Heap from the array.
Extract the largest element (root) and place it at the end.
Reheapify the remaining elements and repeat until sorted.
 */
package com.heap_sort;
import java.util.Arrays;
import java.util.Scanner;

public class JobApplicants {
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        //Building a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Reheapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to heapify a subtree rooted at index i
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Assume root is largest
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2;  // Right child index

        // Check if left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of applicants and there salary demands: ");
        int n = input.nextInt();
        int [] applicantsSalary = new int[n];
        for (int i = 0; i < n; i++) {
            applicantsSalary[i] = input.nextInt();
        }
        heapSort(applicantsSalary);

        System.out.println("Sorted Salaries: "+ Arrays.toString(applicantsSalary));
    }
}
