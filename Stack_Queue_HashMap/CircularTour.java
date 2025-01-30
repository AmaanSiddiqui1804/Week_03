package com.circular_tour_problem;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    private int[] petrol;
    private int[] distance;
    private int n;

    public CircularTour(int[] petrol, int[] distance) {
        this.petrol = petrol;
        this.distance = distance;
        this.n = petrol.length;
    }

    public int findStartingPoint() {
        Queue<Integer> queue = new LinkedList<>();
        int start = 0;     // Starting petrol pump index
        int current = 0;   // Current petrol balance
        int deficit = 0;   // Total petrol used

        for (int i = 0; i < n; i++) {
            current += petrol[i] - distance[i];
            queue.add(i);

            if (current < 0) {
                deficit += current;
                current = 0;
                start = i + 1;
                queue.clear();  // Restart journey, so clear the queue
            }
        }

        return (current + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {5, 7, 5, 5}; //Distance to next petrol pump or petrol consumption

        int sumPetrol = 0;
        int sumDistance = 0;
        for (int i = 0; i < petrol.length; i++) {
            sumPetrol += petrol[i];
            sumDistance += distance[i];
        }
        if(sumPetrol < sumDistance) {
            System.out.println("Not enough petrol to complete the tour!");
        }
        else {
            CircularTour tour = new CircularTour(petrol, distance);
            int startIndex = tour.findStartingPoint();

            if (startIndex != -1) {
                System.out.println("The vehicle should start at petrol pump index: " + startIndex);
            } else {
                System.out.println("No valid starting point exists to complete the tour.");
            }
        }
    }
}

