/* Problem Statement: Implement a movie management system using a doubly linked list.
Each node will represent a movie and contain Movie Title, Director, Year of Release, and Rating.
Implement the following functionalities:
Add a movie record at the beginning, end, or at a specific position.
Remove a movie record by Movie Title.
Search for a movie record by Director or Rating.
Display all movie records in both forward and reverse order.
Update a movie's Rating based on the Movie Title.
Hint:
Use a doubly linked list where each node has two pointers: one pointing to the next node and
the other to the previous node.
Maintain pointers to both the head and tail for easier insertion and deletion at both ends.
For reverse display, start from the tail and traverse backward using the prev pointers.
 */
package com.movie_management_system;

class MovieNode {
    String movieTitle ;
    String director ;
    int yearOfRelease ;
    float rating ;
    MovieNode next ;
    MovieNode prev ;

    public MovieNode(String movieTitle, String director, int yearOfRelease, float rating){
        this.movieTitle = movieTitle;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null ;
        this.prev = null ;
    }
}
//Doubly Linked List
class MovieManagement {
    private MovieNode head ;
    private  MovieNode tail ;


    //Method to add movie records at the beginning
    public void addAtBeginning(String movieTitle, String director, int yearOfRelease, float rating){
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating) ;
        if(head == null) {
            head = tail = newNode ;
        }
        else {
            newNode.next = head;
            head.prev = newNode ;
            head = newNode ;
        }
    }

    //Method to add movie at the end
    public void addAtEnd(String movieTitle, String director, int yearOfRelease, float rating) {
        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating) ;
        if(tail ==null){
            head = tail = newNode ;
        }
        else {
            tail.next = newNode ;
            newNode.prev = tail ;
            tail = newNode ;
        }
    }

    //Adding new movie records at specific positions
    public  void addAtSpecific(int position, String movieTitle, String director, int yearOfRelease, float rating) {
        if(position == 1){
            addAtBeginning(movieTitle, director, yearOfRelease, rating);
            return;
        }

        MovieNode newNode = new MovieNode(movieTitle, director, yearOfRelease, rating);
        MovieNode current = head ;
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
        newNode.prev = current;

        if(current.next != null){
            current.next.prev = newNode ;
        }
        else {
            tail = newNode ;
        }
        current.next = newNode ;
    }

    //Method to remove by movie title
    public void removeByTitle(String movieTitle) {
        if(head == null) {
            System.out.println("No movies to remove! ");
            return;
        }

        MovieNode current = head;
        while (current != null) {
            if(current.movieTitle.equals(movieTitle)) {
                if(current.prev != null) {
                    current.prev.next = current.next;
                }
                else {
                    head = current.next;
                }

                if(current.next != null) {
                    current.next.prev = current.next;
                }
                else {
                    tail = current.prev ;
                }
                System.out.println("Movie removed successfully! ");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found!");
    }

    //Method to search for movies by director or rating in doubly linked list
    public void searchMovie(String director, float rating) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equals(director) || current.rating == rating) {
                System.out.println("Movie found: Movie Name: " + current.movieTitle + "\nDirector: " +
                        current.director + "\nRating: " + current.rating +
                        "\nYear of release: " + current.yearOfRelease);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Movie not found!");
        }
    }

    //Method to display all movies in forward order doubly linked list implementation
    public void displayForwardOrder() {
        if(head == null) {
            System.out.println("No movies to display!");
        }
        System.out.println("\nMovies (Forward Order):\n");

        MovieNode current = head ;
        while (current != null) {
            System.out.println("Movie Name: " + current.movieTitle + "\nDirector: " +
                    current.director + "\nRating: " + current.rating +
                    "\nYear of release: " + current.yearOfRelease);
            current = current.next ;
        }
    }

    //Method to display all movies in reverse order doubly linked list implementation
    public void displayReverseOrder() {
        if(tail == null) {
            System.out.println("No movies to display!");
        }
        System.out.println("\nMovies (Reverse Order):\n");

        MovieNode current = tail ;
        while (current != null) {
            System.out.println("Movie Name: " + current.movieTitle + "\nDirector: " +
                    current.director + "\nRating: " + current.rating +
                    "\nYear of release: " + current.yearOfRelease);
            current = current.prev ;
        }
    }

    //Method to update movie's rating by title
    public void updateRating(String movieTitle, float newRating) {
        MovieNode current = head ;
        float oldRating = current.rating;
        while(current != null) {
            if(current.movieTitle.equals(movieTitle)) {
                current.rating = newRating ;
                System.out.println("Rating updated for movie: " + movieTitle +
                        "\nOld Rating: " + oldRating + "\nNew Rating: " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie Not found!");
    }
}
//Main class
public class MovieManagementSystem {
    public static void main(String[] args) {

        MovieManagement movies = new MovieManagement();

        //Adding movies
        movies.addAtBeginning("Inception", "Christopher Nolan", 2010, 9.0f);
        movies.addAtEnd("The Matrix", "The Wachowskis", 1999, 8.7f);
        movies.addAtSpecific(2, "Interstellar", "Christopher Nolan", 2014, 8.6f);

        // Display movies
        movies.displayForwardOrder();
        // Searching for a movie by director name and rating
        System.out.println("\n \tSearching for movies with director name and rating");
        movies.searchMovie("Christopher Nolan", 8.7f);
        // Update rating
        System.out.println("\n \tUpdating movies with rating");
        movies.updateRating("Interstellar", 9.1f);
        // Remove a movie
        System.out.println("Removing a movie with its name");
        movies.removeByTitle("The Matrix");
        // Display movies in reverse order
        System.out.println("Displaying movies in reverse order");
        movies.displayReverseOrder();
    }
}
