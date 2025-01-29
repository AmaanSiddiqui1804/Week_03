/* 8. Doubly Linked List: Undo/Redo Functionality for Text Editor
Problem Statement: Design an undo/redo functionality for a text editor using a doubly linked list.
Each node represents a state of the text content (e.g., after typing a word or performing a command).
Implement the following:
Add a new text state at the end of the list every time the user types or performs an action.
Implement the undo functionality (revert to the previous state).
Implement the redo functionality (revert back to the next state after undo).
Display the current state of the text.
Limit the undo/redo history to a fixed size (e.g., last 10 states).
Hint:
Use a doubly linked list where each node represents a state of the text.
The next pointer will represent the forward history (redo), and the prev pointer will represent the backward history (undo).
Keep track of the current state and adjust the next and prev pointers for undo/redo operations.
*/

package com.text_editor;

// Node class to represent each state of the text in the doubly linked list
class TextNode {
    String textState;   // Store the state of the text
    TextNode next;      // Pointer to the next text state (for redo functionality)
    TextNode prev;      // Pointer to the previous text state (for undo functionality)

    public TextNode(String textState) {
        this.textState = textState;
        this.next = null;
        this.prev = null;
    }
}

// Editor class implementing undo/redo functionality
class Editor {
    private TextNode head;  // Pointer to the first node
    private TextNode tail;  // Pointer to the last node
    private TextNode current;  // Pointer to the current state
    private int maxHistory;  // Maximum number of states to store
    private int currentHistorySize; // Track current history size

    public Editor(int maxHistory) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.maxHistory = maxHistory;
        this.currentHistorySize = 0;
    }

    // Add a new state to the end of the list
    public void addTextState(String textState) {
        TextNode newNode = new TextNode(textState);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            current = tail;
        }

        // If history size exceeds maxHistory, remove the oldest state
        if (currentHistorySize == maxHistory) {
            head = head.next; // Move the head forward, effectively removing the oldest state
            head.prev = null; // Fix the prev pointer of the new head
        } else {
            currentHistorySize++;
        }
    }

    // Undo functionality (move to the previous state)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.textState);
        } else {
            System.out.println("No more states to undo.");
        }
    }

    // Redo functionality (move to the next state)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.textState);
        } else {
            System.out.println("No more states to redo.");
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current state: " + current.textState);
        } else {
            System.out.println("No text state available.");
        }
    }

    // Method to display the entire text history from the beginning
    public void displayHistory() {
        if (head == null) {
            System.out.println("No history available.");
            return;
        }

        TextNode currentNode = head;
        System.out.println("\nText History:");
        while (currentNode != null) {
            System.out.println(currentNode.textState);
            currentNode = currentNode.next;
        }
    }
}

// Main class
public class TextEditor {
    public static void main(String[] args) {
        // Create a text editor with a history limit of 5 states
        Editor editor = new Editor(10);

        // Simulating typing actions
        editor.addTextState("Hello");
        editor.addTextState("Hello, Amaan!");
        editor.addTextState("Hello, Amaan! How are you?");
        editor.addTextState("Hello, Amaan! How are you doing?");
        editor.addTextState("Hello, Amaan! How are you doing? Have a nice day!");

        // Display current state
        editor.displayCurrentState();

        // Perform undo operations
        editor.undo();  // Undo last state
        editor.undo();  // Undo previous state

        // Perform redo operations
        editor.redo();  // Redo last undone state
        editor.redo();  // Redo previous undone state

        // Display history
        editor.displayHistory();

        // Add a new text state after redo
        editor.addTextState("New text after redo.");
        editor.displayCurrentState();  // Display new current state
    }
}
