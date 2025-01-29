/* 7. Singly Linked List: Social Media Friend Connections
Problem Statement: Create a system to manage social media friend connections using a singly linked list. Each node represents a user with User ID, Name, Age, and List of Friend IDs. Implement the following operations:
Add a friend connection between two users.
Remove a friend connection.
Find mutual friends between two users.
Display all friends of a specific user.
Search for a user by Name or User ID.
Count the number of friends for each user.
Hint:
Use a singly linked list where each node contains a list of friends (which can be another linked list or array of Friend IDs).
For mutual friends, traverse both lists and compare the Friend IDs.
The List of Friend IDs for each user can be implemented as a nested linked list or array.
 */
package com.social_media_connections;
import java.util.List;
import java.util.ArrayList;
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head;

    // Method to add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
    }

    // Method to find a user by ID
    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to add a friend connection
    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null && userId1 != userId2) {
            if (!user1.friendIds.contains(userId2)) {
                user1.friendIds.add(userId2);
            }
            if (!user2.friendIds.contains(userId1)) {
                user2.friendIds.add(userId1);
            }
            System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Invalid User IDs or connection already exists.");
        }
    }

    // Method to remove a friend connection
    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            user1.friendIds.remove((Integer) userId2);
            user2.friendIds.remove((Integer) userId1);
            System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        } else {
            System.out.println("Invalid User IDs.");
        }
    }

    // Method to find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);

        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>(user1.friendIds);
            mutualFriends.retainAll(user2.friendIds);
            System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
        } else {
            System.out.println("Invalid User IDs.");
        }
    }

    // Method to display all friends of a user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + "'s friends: " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    // Method to search for a user by name or ID
    public void searchUser(String name, int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equals(name) || temp.userId == userId) {
                System.out.println("User found: " + temp.name + ", Age: " + temp.age + ", Friends: " + temp.friendIds);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Method to count number of friends for each user
    public void countFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + " has " + user.friendIds.size() + " friends.");
        } else {
            System.out.println("User not found.");
        }
    }
}

public class SocialMediaFriends {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        // Adding users
        sm.addUser(1, "Amaan", 22);
        sm.addUser(2, "Abhay", 21);
        sm.addUser(3, "Nishank", 21);
        sm.addUser(4, "Sonu", 24);
        sm.addUser(5, "Vikas", 22);
        sm.addUser(6, "Vishnu", 28);
        sm.addUser(7, "Neeraj", 22);
        sm.addUser(8, "Amol", 38);

        // Adding friend connections
        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);
        sm.addFriend(3, 4);
        sm.addFriend(1, 5);
        sm.addFriend(1, 6);
        sm.addFriend(1, 7);
        sm.addFriend(1, 8);
        sm.addFriend(6, 8);
        sm.addFriend(2, 5);

        // Display friends
        sm.displayFriends(1);
        sm.displayFriends(3);
        sm.displayFriends(5);
        sm.displayFriends(8);
        sm.displayFriends(7);

        // Find mutual friends
        sm.findMutualFriends(1, 3);
        sm.findMutualFriends(2, 5);

        // Search for a user
        sm.searchUser("Pappu", -1);

        // Count friends
        sm.countFriends(1);

        // Remove friend connection
        sm.removeFriend(1, 3);
        sm.displayFriends(1);
    }
}
