package com.stack_sorting_recursion;

import java.util.Stack;
class RecursionSorting {
    //Method to insert sorted element
    public static void insertSorted(Stack<Integer> stack1, int element) {
        if (stack1.isEmpty() || element > stack1.peek()) {
            stack1.push(element);
            return;
        }
        int top = stack1.pop() ;

        insertSorted(stack1, element);

        stack1.push(top);
    }

    //Recursive method to sort stack
    public static void sortStack(Stack<Integer> stack1) {
       if(!stack1.isEmpty()){
           int top = stack1.pop();

           sortStack(stack1);

           insertSorted(stack1,top);
       }
    }
}
public class SortingStackViaRecursion {
    public static void main(String[] args) {

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(28);
        stack1.push(22);
        stack1.push(29);
        stack1.push(14);
        stack1.push(25);

        System.out.println("Original Stack: " + stack1);

        // Sort the stack
        RecursionSorting sortedStack = new RecursionSorting();
        sortedStack.sortStack(stack1);

        System.out.println("Sorted Stack: " + stack1);
    }
}
