/* Linear Search Problem 2: Search for a Specific Word in a List of Sentences
Problem:
You are given an array of sentences (strings). Write a program that performs Linear Search to
find the first sentence containing a specific word. If the word is found, return the sentence.
If no sentence contains the word, return "Not Found".
Approach:
Iterate through the list of sentences.
For each sentence, check if it contains the specific word.
If the word is found, return the current sentence.
If no sentence contains the word, return "Not Found"
 */
package com.linear_search;

public class WordSearch {
    static String wordSearch(String[] str, String word){

        for (String sentence : str) {
            // Checking if the sentence contains the target word
            if (sentence.contains(word)) {
                return sentence ;
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {

        String[] sentences = {
                "The sun is shining brightly.",
                "I enjoy reading books on rainy days.",
                "The mountains are covered in snow.",
                "Today is a perfect day for a walk.",
                "I love drinking coffee in the morning.",
                "She is learning to play the guitar.",
                "The cat is sleeping peacefully.",
                "We are planning a trip to the beach.",
                "The flowers are blooming in the garden.",
                "I’m excited for the weekend to arrive."
        };
        String word = "love";
            System.out.println("Found sentence: " + wordSearch(sentences, word));

    }
}
