/* Binary Search Problem 2: Find the Peak Element in an Array
Problem:
A peak element is an element that is greater than its neighbors. Write a program that performs Binary Search to
find a peak element in an array. If there are multiple peak elements, return any one of them.
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
Continue until a peak element is found.
 */
package com.binary_search;

public class PeakElementSearch {
    static int binarySearchForPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Checking if mid is a peak element
            boolean leftCheck = (mid == 0) || (arr[mid] > arr[mid - 1]);  // Left boundary check
            boolean rightCheck = (mid == arr.length - 1) || (arr[mid] > arr[mid + 1]); // Right boundary check

            if (leftCheck && rightCheck) {
                return arr[mid];  // Returning peak element
            }
            else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 20, 4, 1, 0};  // 20 is a peak element
        System.out.println("Peak Element: " + binarySearchForPeakElement(arr));
    }
}

