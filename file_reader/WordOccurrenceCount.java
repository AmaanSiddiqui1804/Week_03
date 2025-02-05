/* FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
Problem:
Write a program that uses FileReader and BufferedReader to read a file and count how many
times a specific word appears in the file.
Approach:
Create a FileReader to read from the file and wrap it in a BufferedReader.
Initialize a counter variable to keep track of word occurrences.
For each line in the file, split it into words and check if the target word exists.
Increment the counter each time the word is found.
Print the final count.
 */

package com.file_reader;
import java.io.*;

public class WordOccurrenceCount {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Enter the word to count its occurrences: ");
            String targetWord = br.readLine().trim();

            // Specifying the file path
            String filePath = "D:\\Week_03\\Day_04\\src\\com\\TextFiles\\Difference between StringBuilder and StringBuffer.txt";
            int count = 0;

            try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
                String line;

                while ((line = fileReader.readLine()) != null) {

                    //Removing punctuation
                    line = line.replaceAll("[^a-zA-Z0-9\\s]", "");  // Removes punctuations except spaces
                    String[] words = line.split("\\s+"); //Removes spaces
                    for (String word : words) {
                        if (word.equalsIgnoreCase(targetWord)) {
                            count++;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found.");
                return;
            } catch (IOException e) {
                System.out.println("Error reading the file.");
                return;
            }

            //Result
            System.out.println("The word \"" + targetWord + "\" appears " + count + " times in the file.");
        }
        catch (IOException e) {
            System.out.println("USer input error.");
        }
    }
}
