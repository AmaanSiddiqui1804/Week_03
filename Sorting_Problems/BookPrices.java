/* Merge Sort - Sort an Array of Book Prices
Problem Statement:
A bookstore maintains a list of book prices in an array. Implement Merge Sort to sort the prices in ascending order.
Hint:
Divide the array into two halves recursively.
Sort both halves individually.
Merge the sorted halves by comparing elements.
 */


package com.merge_sort;
import java.util.Arrays;
public class BookPrices {
    public static void mergeSort(int[] bookprices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(bookprices, left, mid);
            mergeSort(bookprices, mid + 1, right);
            merge(bookprices, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {
        int[] bookprices = {500, 300, 580, 400, 250, 300, 600};
        mergeSort(bookprices, 0, bookprices.length - 1);
        System.out.println("Book Prices: " + Arrays.toString(bookprices));
    }
}
