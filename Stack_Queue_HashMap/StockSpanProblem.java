package com.stock_span;

import java.util.Stack;
public class StockSpanProblem {
    public static int [] calculateSpan(int [] prices) {
        int n = prices.length;
        int [] span = new int[n] ;

        Stack <Integer> stack = new Stack<>() ;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                span[i] = i+1 ;
            }

            else {
                span[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return span;
    }
    public static void main(String[] args) {
        int [] prices = {100, 80, 50, 55, 78, 55, 90, 60};
        int [] span = calculateSpan(prices) ;

        System.out.println("Stock spans: ");
        for (int i : span) {
            System.out.print(i + " ");
        }
    }
}
