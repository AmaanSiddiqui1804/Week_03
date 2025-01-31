/* Counting Sort - Sort Student Ages
Problem Statement:
A school collects students’ ages (ranging from 10 to 18) and wants them sorted. Implement Counting Sort for this task.
Hint:
Create a count array to store the frequency of each age.
Compute cumulative frequencies to determine positions.
Place elements in their correct positions in the output array.
 */
package com.counting_sort;
import java.util.Arrays;
public class StudentAges {
    public static void countingSort(int[] ages) {
        int minAge = 10, maxAge = 18;  // Taking age range
        int range = maxAge - minAge + 1;  // Size of count array

        int[] count = new int[range];  // Count array
        int[] output = new int[ages.length];  // Output array

        //Counting occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }
        //Counting frequencies
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        //Placing elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        //sorted elements back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 12, 14, 16, 10, 15, 17};
        countingSort(studentAges);

        // Display sorted ages
        System.out.println("Sorted Ages: " + Arrays.toString(studentAges));
    }
}
