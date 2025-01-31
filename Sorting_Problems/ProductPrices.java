/* Quick Sort - Sort Product Prices
Problem Statement:
An e-commerce company wants to display product prices in ascending order. Implement Quick Sort to sort the product prices.
Hint:
Pick a pivot element (first, last, or random).
Partition the array such that elements smaller than the pivot are on the left and larger ones are on the right.
Recursively apply Quick Sort on left and right partitions.
 */
package com.quick_sort;
import java.util.Arrays;
public class ProductPrices {
    public static void quickSort(int[] p, int low, int high) {
        if (low < high) {
            int pi = partition(p, low, high);
            quickSort(p, low, pi - 1);
            quickSort(p, pi + 1, high);
        }
    }

    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] prices = {50, 483, 85, 94, 12, 25, 69, 500, 800, 10, 36, 70};
        quickSort(prices, 0, prices.length - 1);
        System.out.println("Product prices in sorted order" + Arrays.toString(prices));
    }
}