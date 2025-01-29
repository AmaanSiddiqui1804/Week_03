/* Singly Linked List: Student Record Management
Problem Statement: Create a program to manage student records using a singly linked list. Each node will store
information about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
Add a new student record at the beginning, end, or at a specific position.
Delete a student record by Roll Number.
Search for a student record by Roll Number.
Display all student records.
Update a student's grade based on their Roll Number.
Hint:
Use a singly linked list where each node contains student information and a pointer to the next node.
The head of the list will represent the first student, and the last node’s next pointer will be null.
Update the next pointers when inserting or deleting nodes.
 */

package com.student_record_management;

class InventoryNode {
    int rollNumber ;
    String name ;
    int age ;
    char grade ;
    InventoryNode next ;

    public InventoryNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber ;
        this.name = name;
        this.age = age ;
        this.grade = grade ;
        this.next = null ;
    }
}
class StudentLinkedList {
    private InventoryNode head ;

    //Method to add new records at the beginning
    public void  addAtBeginning(int rollNumber, String name, int age, char grade) {
        InventoryNode newNode = new InventoryNode(rollNumber, name, age, grade) ;
        newNode.next = head ;
        head = newNode ;
    }

    //Adding a new Student record at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        InventoryNode newNode = new InventoryNode(rollNumber, name, age, grade) ;
        if(head ==null){
            head = newNode ;
            return;
        }
        InventoryNode current = head ;
        while(current.next != null){
            current = current.next ;
        }
        current.next = newNode ;
    }

    //Adding new records at specific positions
    public  void addAtSpecific(int position, int rollNumber, String name, int age, char grade) {
        if(position == 1){
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        InventoryNode newNode = new InventoryNode(rollNumber, name, age, grade);
        InventoryNode current = head ;
        int count = 1;

        while (current != null && count < position-1) {
            current = current.next;
            count++;
        }
        if(current == null) {
            System.out.println("Invalid Position!");
            return;
        }
        newNode.next = current.next ;
        current.next = newNode ;
    }

    //Deleting a student record by roll number
    public void deleteRecord(int rollNumber) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        InventoryNode current = head ;
        while (current.next != null && current.next.rollNumber != rollNumber) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Record not found.");
            return;
        }

        current.next = current.next.next;
        System.out.println("Record deleted successfully.");
    }

    // Searching a student record by Roll Number
    public void searchByRollNumber(int rollNumber) {
        InventoryNode current = head;

        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
                return;
            }
            current = current.next;
        }

        System.out.println("Student not found.");
    }

    // Displaying all student records
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }

        InventoryNode current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll Number: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }

    // Updating a student's grade based on their Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        InventoryNode current = head;

        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated successfully to: " + newGrade);
                return;
            }
            current = current.next;
        }

        System.out.println("Student not found.");
    }
}
public class StudentRecordManagement {
    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        //Add student records
        list.addAtBeginning(1, "Abhay Gautam", 21, 'A');
        list.addAtSpecific(2, 2, "Amaan Siddiqui", 22, 'B');
        list.addAtEnd(3, "Tikesh", 23, 'A');

        //Displaying all records
        list.displayAllRecords();

        //Searching for a student with his roll number
        list.searchByRollNumber(2);

        //Updating a grade
        list.updateGrade(2, 'A');

        //Deleting a record via a roll number
        list.deleteRecord(3);

        //Displaying records after update
        list.displayAllRecords();

    }
}
