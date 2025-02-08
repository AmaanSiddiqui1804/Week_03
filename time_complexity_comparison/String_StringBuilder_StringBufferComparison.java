/* 3. Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
 */
package com.time_complexity_comparison;

public class String_StringBuilder_StringBufferComparison {
    static void comparison(String str, int count) {
        long startTime , endTime, netTime ;
        String s = str;
        StringBuilder s1 = new StringBuilder();
        StringBuffer s2 = new StringBuffer() ;

        //Testing string performance
        //Adding hello count times to simple string
        startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            s = s.concat(str);
        }
        endTime = System.nanoTime();
        netTime = (endTime - startTime)/1000_000;
        System.out.println("String Time: " + (endTime - startTime) + " ns");
        System.out.println("String Time: " + netTime + " ms\n");

        // Testing StringBuilder Performance
        startTime = System.nanoTime();

        //Adding hello count times using string builder
        for (long i = 0; i < count; i++) {
            s1.append(str);
        }
        endTime = System.nanoTime();
        netTime = (endTime - startTime)/1000_000;
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns.");
        System.out.println("String Builder Time: " + netTime + " ms.\n");

        //Testing stringBuffer performance
        startTime = System.nanoTime();

        //Adding hello 1 million times using StringBuffer
        for (long i = 0; i < 1000000; i++) {
            s2.append(str);
        }
        endTime = System.nanoTime();
        netTime = (endTime - startTime)/1000_000;
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");
        System.out.println("StringBuffer Time: " + netTime + " ms\n");
    }

    public static void main(String[] args) {

        String str = "hello";
        int count1 = 1000;
        int count2 = 10_000;
        int count3 = 1000_000;
        //Calling method to check performance
        System.out.println("\tCalculating time for adding hello 1000 times\n");
        comparison(str, count1);

        System.out.println("\tCalculating time for adding hello 10_000 times\n");
        comparison(str, count2);

        System.out.println("\tCalculating time for adding hello 1000_000 times\n");
        comparison(str, count3);
    }
}
