/* Circular Linked List: Online Ticket Reservation System
Problem Statement: Design an online ticket reservation system using a circular linked list,
where each node represents a booked ticket.
Each node will store the following information: Ticket ID, Customer Name, Movie Name,
Seat Number, and Booking Time. Implement the following functionalities:
Add a new ticket reservation at the end of the circular list.
Remove a ticket by Ticket ID.
Display the current tickets in the list.
Search for a ticket by Customer Name or Movie Name.
Calculate the total number of booked tickets.

Hint:
Use a circular linked list to represent the ticket reservations, with the last node’s next
pointer pointing to the first node.
When removing a ticket, update the circular pointers accordingly.
For displaying all tickets, traverse the list starting from the first node, looping back after
reaching the last node.
*/
package com.ticket_reservation_system;

class TicketNode {
    int ticketId ;
    String customerName ;
    String movieName ;
    int seatNumber ;
    String bookingTime ;
    TicketNode next ;

    public TicketNode(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime){
        this.ticketId = ticketId ;
        this.customerName = customerName ;
        this.movieName = movieName ;
        this.seatNumber = seatNumber ;
        this.bookingTime = bookingTime ;
        this.next = null ;
    }
}

class TicketReservation {
    private TicketNode head;
    private TicketNode tail;
    private int totalTickets;

    // Constructor to initialize the system
    public TicketReservation() {
        head = null;
        tail = null;
        totalTickets = 0;
    }

    //Method to add new ticket reservation at the end of Circular List
    public void addTicket(int ticketId, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode ticket = new TicketNode(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = ticket;
            ticket.next = head; // Circular link
        } else {
            tail.next = ticket;
            tail = ticket;
            tail.next = head; // Circular link
        }
        totalTickets++;
    }

    //Method to remove ticket by ticket id
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove!");
            return;
        }
        TicketNode current = head;
        TicketNode prev = tail;
        do {
            if (current.ticketId == ticketId) {
                if (prev != null) {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev; // Update tail if it's the last node
                    }
                } else {
                    // If the head node needs to be removed
                    tail.next = current.next; // Update tail's next pointer
                    head = current.next; // Move head to next node
                }
                totalTickets--;
                System.out.println("Ticket removed: " + ticketId);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head); // Loop back to the head in a circular manner

        System.out.println("Ticket ID not found.");
    }

    // Display the current tickets in the list
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        TicketNode current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName
                    + ", Movie: " + current.movieName + ", Seat: " + current.seatNumber
                    + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head); // Loop back to the head in a circular manner
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String searchTerm) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        TicketNode current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(searchTerm) || current.movieName.equalsIgnoreCase(searchTerm)) {
                System.out.println("Ticket found: ID - " + current.ticketId + ", Customer - " + current.customerName
                        + ", Movie - " + current.movieName + ", Seat - " + current.seatNumber
                        + ", Booking Time - " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No ticket found with the search term: " + searchTerm);
        }
    }

    // Calculate the total number of booked tickets
    public int totalTicketsBooked() {
        return totalTickets;
    }
}

public class OnlineTicketReservationSystem {

    public static void main(String[] args) {
        TicketReservation ticket = new TicketReservation();

        ticket.addTicket(1, "Amaan Siddiqui", "Avengers", 101, "2025-01-29 19:00");
        ticket.addTicket(2, "Sonu Sharma", "Batman", 201, "2025-01-29 21:00");
        ticket.addTicket(3, "Neeraj ", "Blacky", 203, "2025-01-29 22:00");

        ticket.displayTickets(); // Display all tickets

        ticket.removeTicket(2); // Remove ticket with ID 2

        ticket.displayTickets(); // Display all tickets again

        ticket.searchTicket("Sonu Sharma"); // Search for a ticket by customer name

        System.out.println("Total Tickets Booked: " + ticket.totalTicketsBooked()); // Display total tickets booked
    }
}