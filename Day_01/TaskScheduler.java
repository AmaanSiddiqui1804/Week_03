/* 3. Circular Linked List: Task Scheduler
Problem Statement: Create a task scheduler using a circular linked list.
Each node in the list represents a task with Task ID, Task Name, Priority, and Due Date.
Implement the following functionalities:
Add a task at the beginning, end, or at a specific position in the circular list.
Remove a task by Task ID.
View the current task and move to the next task in the circular list.
Display all tasks in the list starting from the head node.
Search for a task by Priority.
Hint:
Use a circular linked list where the last node’s next pointer points back to the first node,
creating a circular structure.
Ensure that the list loops when traversed from the head node, so tasks can be revisited in a circular manner.
When deleting or adding tasks, maintain the circular nature by updating the appropriate next pointers */

package com.task_scheduler;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class Scheduler {
    private Task head;
    private Task tail;

    // Method to add tasks at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newNode = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Method to add tasks at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newNode = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Method to add tasks at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 0) {
            System.out.println("Invalid position. Position should be greater than 0.");
            return;
        }
        Task newNode = new Task(taskId, taskName, priority, dueDate);
        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Task current = head;
        for (int i = 1; i < position - 1; i++) {
            current = current.next;
            if (current == head) {
                System.out.println("Position out of bounds.");
                return;
            }
        }
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == head) {
            tail = newNode;
        }
    }

    // Method to remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Task current = head;
        Task previous = null;
        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                    if (head == null) {
                        tail = null; // List is now empty
                    }
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // Method to view the current task and move to the next task
    public void viewAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + head.taskName);
        head = head.next;
    }

    // Method to display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task current = head;
        do {
            System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Method to search for tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Task current = head;
        boolean found = false;
        do {
            if (current.priority == priority) {
                System.out.println("Task ID: " + current.taskId + ", Task Name: " + current.taskName +
                        ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();

        // Adding tasks
        scheduler.addAtBeginning(1, "Task A", 2, "2023-10-01");
        scheduler.addAtEnd(2, "Task B", 1, "2023-10-02");
        scheduler.addAtPosition(2, 3, "Task C", 3, "2023-10-03");

        // Displaying all tasks
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View and move to next task
        System.out.println("\nView and Move Next:");
        scheduler.viewAndMoveNext();
        scheduler.viewAndMoveNext();

        // Searching tasks by priority
        System.out.println("\nTasks with Priority 2:");
        scheduler.searchByPriority(2);

        // Removing a task by ID
        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTaskById(2);

        // Displaying all tasks after removal
        System.out.println("\nAll Tasks after removal:");
        scheduler.displayAllTasks();
    }
}
