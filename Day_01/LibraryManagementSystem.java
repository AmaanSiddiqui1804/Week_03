/* 5. Doubly Linked List: Library Management System
Problem Statement: Design a library management system using a doubly linked list.
Each node represents a book and contains the following attributes:
Book Title, Author, Genre, Book ID, and Availability Status. Implement the following functionalities:
Add a new book at the beginning, end, or at a specific position.
Remove a book by Book ID.
Search for a book by Book Title or Author.
Update a book’s Availability Status.
Display all books in forward and reverse order.
Count the total number of books in the library.
Hint:
Use a doubly linked list with two pointers (next and prev) in each node to facilitate traversal in both directions.
Ensure that when removing a book, both the next and prev pointers are correctly updated.
Displaying in reverse order will require traversal from the last node using prev pointers*/

package com.library_management_system;
class LibraryNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    LibraryNode next;
    LibraryNode prev;

    public LibraryNode(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = null;
        this.prev = null;
    }
}

class LibraryManagement {
    private LibraryNode head;
    private LibraryNode tail;

    // Method to add book at the beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        LibraryNode newNode = new LibraryNode(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Method to add book at the end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean availabilityStatus) {
        LibraryNode newNode = new LibraryNode(title, author, genre, bookId, availabilityStatus);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Adding a new book record at a specific position
    public void addAtSpecific(int position, String title, String author, String genre, int bookId, boolean availabilityStatus) {
        if (position == 1) {
            addAtBeginning(title, author, genre, bookId, availabilityStatus);
            return;
        }

        LibraryNode newNode = new LibraryNode(title, author, genre, bookId, availabilityStatus);
        LibraryNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Invalid Position!");
            return;
        }

        newNode.next = current.next;
        newNode.prev = current;

        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
    }

    // Method to remove book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("No books to remove!");
            return;
        }

        LibraryNode current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                System.out.println("Book removed successfully!");
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found!");
    }

    // Method to search book by Title or Author
    public void searchBook(String title, String author) {
        LibraryNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equals(title) || current.author.equals(author)) {
                System.out.println("\nBook Found:");
                System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                        ", Book ID: " + current.bookId + ", Availability: " + current.availabilityStatus);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Book not found!");
        }
    }

    // Method to update book availability
    public void updateAvailability(int bookId, boolean availabilityStatus) {
        LibraryNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                boolean prevStatus = current.availabilityStatus;
                current.availabilityStatus = availabilityStatus;
                System.out.println("Availability updated for book: " + current.title +
                        "\nPrevious Availability: " + prevStatus + "\nCurrent Availability: " + availabilityStatus);
                return;
            }
            current = current.next;
        }
        System.out.println("Book Not Found!");
    }

    // Method to display all books in forward order
    public void displayForwardOrder() {
        if (head == null) {
            System.out.println("No books to display!");
            return;
        }
        System.out.println("\nBooks (Forward Order):");

        LibraryNode current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookId + ", Availability: " + current.availabilityStatus);
            current = current.next;
        }
    }

    // Method to display all books in reverse order
    public void displayReverseOrder() {
        if (tail == null) {
            System.out.println("No books to display!");
            return;
        }
        System.out.println("\nBooks (Reverse Order):");

        LibraryNode current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre +
                    ", Book ID: " + current.bookId + ", Availability: " + current.availabilityStatus);
            current = current.prev;
        }
    }

    // Method to count the total number of books in the library
    public void totalCount() {
        int count = 0;
        LibraryNode current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        System.out.println("Total books count: " + count);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement books = new LibraryManagement();

        // Adding books to the library
        books.addAtEnd("Harry Potter", "J.K. Rowling", "Fantasy", 101, true);
        books.addAtBeginning("The Hobbit", "J.R.R. Tolkien", "Fantasy", 102, false);
        books.addAtEnd("1984", "George Orwell", "Dystopian", 103, true);
        books.addAtSpecific(2, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 104, true);

        // Display books in both orders
        books.displayForwardOrder();
        books.displayReverseOrder();

        // Searching for books
        books.searchBook("1984", "");

        // Updating availability
        books.updateAvailability(101, false);

        // Removing a book
        books.removeByBookId(103);

        // Display final count
        books.totalCount();
    }
}
