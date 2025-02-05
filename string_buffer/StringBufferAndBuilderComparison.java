/* StringBuffer Problem 2: Compare StringBuffer with StringBuilder for String Concatenation
Problem:
Write a program that compares the performance of StringBuffer and StringBuilder for concatenating strings.
For large datasets (e.g., concatenating 1 million strings), compare the execution time of both classes.
Approach:
Initialize two StringBuffer and StringBuilder objects.
Perform string concatenation in both objects, appending 1 million strings (e.g., "hello").
Measure the time taken to complete the concatenation using System.nanoTime() for both StringBuffer and StringBuilder.
Output the time taken by both classes for comparison.
 */
package com.string_buffer;

public class StringBufferAndBuilderComparison {
    static void comparison(String str) {
        long startTime , endTime ;
        StringBuilder s1 = new StringBuilder();
        StringBuffer s2 = new StringBuffer() ;

        // Testing StringBuilder Performance
        startTime = System.nanoTime();

        //Adding hello 1 million times using string builder
        for (long i = 0; i < 1000000; i++) {
            s1.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");

        //Testing stringBuffer performance
        startTime = System.nanoTime();

        //Adding hello 1 million times using StringBuffer
        for (long i = 0; i < 1000000; i++) {
            s2.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");

    }

    public static void main(String[] args) {

        String str = "hello";
        //Calling method to check performance
        comparison(str);
    }
}
