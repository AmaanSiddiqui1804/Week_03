/* 5. Problem Statement: RecursiveVsIterativeFibonacciComputation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}
Expected Result:
Recursive approach is infeasible for large values of N due to exponential growth.
The iterative approach is significantly faster and memory-efficient.


 */
package com.time_complexity_comparison;

public class RecursiveVsIterativeFibonacci {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        long startTime, endTime;
        double netTime ;
        int limit1 = 10;
        int limit2 = 30;
        int limit3 = 50;

        System.out.println("\n\tComputing Recursive Fibonacci Upto 10");
        startTime = System.nanoTime();
        int ans1 = fibonacciRecursive(limit1);
        endTime = System.nanoTime();
        System.out.println("Result: " + ans1);
        netTime =(double) (endTime - startTime) / 1_000_000;
        System.out.println("Recursive Fibonacci Time: " + netTime + " ms.");
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns.\n");

        System.out.println("\n\tComputing Iterative Fibonacci Upto 10");
        startTime = System.nanoTime();
        int ans2 = fibonacciIterative(limit1);
        endTime = System.nanoTime();
        System.out.println("Result: " + ans2);
        netTime =(double) (endTime - startTime) / 1_000_000;
        System.out.println("Recursive Fibonacci Time: " + netTime + " ms.");
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns.\n");

        System.out.println("\n\tComputing Recursive Fibonacci Upto 30");
        startTime = System.nanoTime();
        int ans3 = fibonacciRecursive(limit2);
        endTime = System.nanoTime();
        System.out.println("Result: " + ans3);
        netTime =(double) (endTime - startTime) / 1_000_000;
        System.out.println("Recursive Fibonacci Time: " + netTime + " ms.");
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns.\n");

        System.out.println("\n\tComputing Iterative Fibonacci Upto 30");
        startTime = System.nanoTime();
        int ans4 = fibonacciIterative(limit2);
        endTime = System.nanoTime();
        System.out.println("Result: " + ans4);
        netTime =(double) (endTime - startTime) / 1_000_000;
        System.out.println("Recursive Fibonacci Time: " + netTime + " ms.");
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns.\n");

        System.out.println("\n\tComputing Recursive Fibonacci Upto 50");
        startTime = System.nanoTime();
        int ans5 = fibonacciRecursive(limit3);
        endTime = System.nanoTime();
        System.out.println("Result: " + ans5);
        netTime =(double) (endTime - startTime) / 1_000_000;
        System.out.println("Recursive Fibonacci Time: " + netTime + " ms.");
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns.\n");

        System.out.println("\n\tComputing Iterative Fibonacci Upto 50");
        startTime = System.nanoTime();
        int ans6 = fibonacciIterative(limit1);
        endTime = System.nanoTime();
        System.out.println("Result: " + ans6);
        netTime =(double) (endTime - startTime) / 1_000_000;
        System.out.println("Recursive Fibonacci Time: " + netTime + " ms.");
        System.out.println("Recursive Fibonacci Time: " + (endTime - startTime) + " ns.\n");

    }
}
