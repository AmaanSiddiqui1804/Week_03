/*Singly Linked List: Inventory Management System
Problem Statement: Design an inventory management system using a singly linked list where each node stores
information about an item such as Item Name, Item ID, Quantity, and Price. Implement the following functionalities:
Add an item at the beginning, end, or at a specific position.
Remove an item based on Item ID.
Update the quantity of an item by Item ID.
Search for an item based on Item ID or Item Name.
Calculate and display the total value of inventory (Sum of Price * Quantity for each item).
Sort the inventory based on Item Name or Price in ascending or descending order.
Hint:
Use a singly linked list where each node represents an item in the inventory.
Implement sorting using an appropriate algorithm (e.g., merge sort) on the linked list.
For total value calculation, traverse through the list and sum up Quantity * Price for each item.
*/

package com.inventory_management_system;

class InventoryNode {
    int itemId ;
    String itemName ;
    int quantity ;
    double price ;
    InventoryNode next ;

    public InventoryNode(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId ;
        this.itemName = itemName;
        this.quantity = quantity ;
        this.price = price ;
        this.next = null ;
    }
}
class InventoryLinkedList {
    private InventoryNode head ;

    //Method to add items at the beginning
    public void  addAtBeginning(int itemId, String itemName, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemId, itemName, quantity, price) ;
        newNode.next = head ;
        head = newNode ;
    }

    //Adding a item at the end
    public void addAtEnd(int itemId, String itemName, int quantity, double price) {
        InventoryNode newNode = new InventoryNode(itemId, itemName, quantity, price) ;
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

    //Method to add items at specific position
    public  void addAtSpecific(int position, int itemId, String itemName, int quantity, double price) {
        if(position == 1){
            addAtBeginning(itemId, itemName, quantity, price);
            return;
        }

        InventoryNode newNode = new InventoryNode(itemId, itemName, quantity, price);
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

    //Removing an item by item Id
    public void deleteRecord(int itemId) {
        if(head == null) {
            System.out.println("List is empty");
            return;
        }

        InventoryNode current = head ;
        while (current.next != null && current.next.itemId != itemId) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Record not found.");
            return;
        }

        current.next = current.next.next;
        System.out.println("Item deleted successfully.");
    }

    // Updating the quantity by Item Id
    public void updateQuantity(int itemId, int quantity) {
        InventoryNode current = head;

        while (current != null) {
            if (current.itemId == itemId) {
                current.quantity = quantity;
                System.out.println("Quantity updated successfully to: " + quantity);
                return;
            }
            current = current.next;
        }

        System.out.println("Item not found.");
    }

    // Searching an item by Item id or Item name
    public void searchItem(int itemId, String itemName) {
        InventoryNode current = head;

        while (current != null) {
            if (current.itemId == itemId || current.itemName.equals(itemName)) {
                System.out.println("Item Found: Item name: " + current.itemName + ", Item ID: " + current.itemId) ;
                return;
            }
            current = current.next;
        }

        System.out.println("Item not found.");
    }

    // Displaying all inventory records and total price
    public void displayAllRecords() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }
        InventoryNode current = head;
        double totalInventoryValue = 0;
        System.out.println("Inventory Records:");
        while (current != null) {
            double itemValue = current.quantity * current.price;
            totalInventoryValue += itemValue;
            System.out.println("Item Name: " + current.itemName + ", Item Id: " + current.itemId + ", Quantity: " + current.quantity + ", Price: Rs" + current.price + ", Total Value: " + itemValue);
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + totalInventoryValue);
    }
    // Method to sort the inventory by Item Name (ascending order)
    public void sortByItemName() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one node
        }

        boolean swapped;
        do {
            swapped = false;
            InventoryNode current = head;
            InventoryNode previous = null;

            while (current.next != null) {
                if (current.itemName.compareTo(current.next.itemName) > 0) {
                    // Swap nodes
                    InventoryNode nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;

                    if (previous == null) {
                        head = nextNode;
                    } else {
                        previous.next = nextNode;
                    }

                    previous = nextNode;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }

    // Method to sort the inventory by Price (ascending order)
    public void sortByPrice() {
        if (head == null || head.next == null) {
            return; // No need to sort if the list is empty or has only one node
        }

        boolean swapped;
        do {
            swapped = false;
            InventoryNode current = head;
            InventoryNode previous = null;

            while (current.next != null) {
                if (current.price > current.next.price) {
                    // Swap nodes
                    InventoryNode nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;

                    if (previous == null) {
                        head = nextNode;
                    } else {
                        previous.next = nextNode;
                    }

                    previous = nextNode;
                    swapped = true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        } while (swapped);
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        // Adding items to the inventory
        inventory.addAtBeginning(101, "Laptop", 10, 12000.0);
        inventory.addAtEnd(102, "Mouse", 50, 25.0);
        inventory.addAtSpecific(2, 103, "Keyboard", 30, 450.0);

        // Display all inventory records
        System.out.println("Initial Inventory:");
        inventory.displayAllRecords();

        // Update quantity of an item
        System.out.println("\nUpdating quantity of Item ID 102:");
        inventory.updateQuantity(102, 60);

        // Search for an item by Item ID or Item Name
        System.out.println("\nSearching for Item ID 103:");
        inventory.searchItem(103, "");

        // Remove an item by Item ID
        System.out.println("\nRemoving Item ID 101:");
        inventory.deleteRecord(101);

        // Display all inventory records after removal
        System.out.println("\nInventory after removal:");
        inventory.displayAllRecords();

        // Calculate and display total inventory value
        System.out.println("\nCalculating Total Inventory Value:");
        inventory.displayAllRecords();

        // Sort inventory by Item Name
        System.out.println("\nSorting Inventory by Item Name:");
        inventory.sortByItemName();
        inventory.displayAllRecords();

        // Sort inventory by Price
        System.out.println("\nSorting Inventory by Price:");
        inventory.sortByPrice();
        inventory.displayAllRecords();
    }
}
