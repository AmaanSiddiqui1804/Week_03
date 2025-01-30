package com.custom_hashmap;

import java.util.LinkedList;
public class CustomHashMap<K, V> {
    private static final int SIZE = 10; // Default bucket size
    private LinkedList<Entry<K, V>>[] buckets;

    // Entry class to store key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize buckets
    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to determine the bucket index
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }
        bucket.add(new Entry<>(key, value)); // Insert new entry
    }

    // Retrieve a value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null; // Key not found
    }

    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        bucket.removeIf(entry -> entry.key.equals(key)); // Remove if key matches
    }

    // Display the hash map contents
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : buckets[i]) {
                System.out.print("[" + entry.key + " -> " + entry.value + "] ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CustomHashMap<Integer, String> map = new CustomHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println("Get key 2: " + map.get(2));
        map.remove(2);
        System.out.println("Get key 2 after removal: " + map.get(2));

        map.display();
    }
}
