package com.queue_using_stacks;
import java.util.Stack;

class QueueOperations {
    private Stack <Integer> stack1 ;
    private Stack <Integer> stack2 ;

    public QueueOperations() {
        this.stack1 = new Stack<>() ;
        this.stack2 = new Stack<>() ;
    }

    //Adding elements in stack
    public void enque(int value) {
        stack1.push(value);
        System.out.println("Enqued: " + value);
    }

    //Deque operation
    public int deque() {
        if (stack2.isEmpty()) { // If stack2 is empty, transfer elements from stack1
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty! Cannot dequeue.");
                return -1;
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    //Peek operation
    public int peek() {
        if (stack2.isEmpty()) { // If stack2 is empty, transfer elements from stack1
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty! Nothing to peek.");
                return -1;
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    //Method to check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
public class QueueUsingStacks {
    public static void main(String[] args) {

        QueueOperations queue = new QueueOperations();
        //Adding elements in stack implemented queue
        queue.enque(21);
        queue.enque(22);
        queue.enque(23);
        queue.enque(24);
        queue.enque(25);

        System.out.println();

        //Removing element from queue: 25 should be removed
        System.out.println("Removing element from queue: 21 should be removed\n");
        System.out.println("Dequeued: " + queue.deque() + "\n");

        System.out.println("Checking first element: Output should be 22");
        System.out.println("Peking in queue: " + queue.peek()+ "\n");

        System.out.println("Adding another element");
        queue.enque(28);

        System.out.println("Removing multiple elements from queue: \n");
        System.out.println("Dequed: " + queue.deque());
        System.out.println("Dequed: " + queue.deque());
        System.out.println("Dequed: " + queue.deque());
        System.out.println("Dequed: " + queue.deque());

        System.out.println("Is queue empty ?:" + queue.isEmpty());
    }
}
