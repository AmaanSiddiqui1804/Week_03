package com.subarray_with_zero_sum;

import java.util.*;
class Pair {
    int first, second;
    Pair(int a, int b)
    {
        first = a;
        second = b;
    }
}
public class ZeroSumSubArray {
    // Method to find all sub arrays in the array which has sum = 0
    static ArrayList<Pair> findSubArrays(int[] arr, int n)
    {
        // Creating an empty map where key = integer and value =
        HashMap<Integer, ArrayList<Integer> > map = new HashMap<>();

        //Arraylist of objects (Pairs)
        ArrayList<Pair> pairs = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {

            sum += arr[i];
            if (sum == 0)
                pairs.add(new Pair(0, i));

            ArrayList<Integer> alist = new ArrayList<>();

            if (map.containsKey(sum)) {
                // map[sum] stores starting index of all subarrays
                alist = map.get(sum);
                for (int j = 0; j < alist.size(); j++) {
                    pairs.add(new Pair(alist.get(j) + 1, i));
                }
            }
            alist.add(i);
            map.put(sum, alist);
        }
        return pairs;
    }

    // Method to print all subarrays with sum 0
    public static void print(ArrayList<Pair> pairs)
    {
        for (int i = 0; i < pairs.size(); i++) {
            Pair p = pairs.get(i);
            System.out.println("Subarray found from Index " + p.first + " to " + p.second);
        }
    }

    // Driver code
    public static void main(String args[])
    {
        int[] arr
                = { 4, 3, -1, -3, 6, -2, 2, 2, 6, -12, -5 };
        int n = arr.length;

        ArrayList<Pair> pairs = findSubArrays(arr, n);

        if (pairs.size() == 0)
            System.out.println("No subarray exists");
        else
            print(pairs);
    }
}