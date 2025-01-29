/*6. Circular Linked List: Round Robin Scheduling Algorithm
Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list. Each node will represent a process and contain Process ID, Burst Time, and Priority. Implement the following functionalities:
Add a new process at the end of the circular list.
Remove a process by Process ID after its execution.
Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
Display the list of processes in the circular queue after each round.
Calculate and display the average waiting time and turn-around time for all processes.
Hint:
Use a circular linked list to represent a queue of processes.
Each process executes for a fixed time quantum, and then control moves to the next process in the circular list.
Maintain the current node as the process being executed, and after each round, update the list to simulate execution.
*/

package com.round_robin_scheduler;

class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add a process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    // Remove a process by Process ID after its execution
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove!");
            return;
        }
        ProcessNode current = head, prev = tail;
        do {
            if (current.processId == processId) {
                if (current == head) head = head.next;
                if (current == tail) tail = prev;
                prev.next = current.next;
                System.out.println("Process " + processId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
        System.out.println("Process not found!");
    }

    // Simulate Round Robin scheduling
    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute!");
            return;
        }
        System.out.println("Executing processes in Round Robin order:");
        ProcessNode current = head;
        while (head != null) {
            System.out.println("Executing Process " + current.processId + " (Remaining Burst Time: " + current.burstTime + ")");
            if (current.burstTime <= timeQuantum) {
                System.out.println("Process " + current.processId + " completed execution.");
                removeProcess(current.processId);
            } else {
                current.burstTime -= timeQuantum;
            }
            current = current.next;
            if (head == null) break;
        }
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);

        //Displaying process
        scheduler.executeProcesses();
    }
}

