/* FileReader Problem 1: Read a File Line by Line Using FileReader
Problem:
Write a program that uses FileReader to read a text file line by line and print each line to the console.
Approach:
Create a FileReader object to read from the file.
Wrap the FileReader in a BufferedReader to read lines efficiently.
Use a loop to read each line using the readLine() method and print it to the console.
Close the file after reading all the lines.
 */
package com.file_reader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader ;
import java.io.BufferedReader;

public class FileReaderProgram {
    public static void main(String[] args) {
        // Specify the file path
        String filePath = "D:\\Week_03\\Day_04\\src\\com\\TextFiles\\Difference between StringBuilder and StringBuffer.txt";

        try {
            // Create FileReader and wrap it with BufferedReader
            FileReader fileReader = new FileReader(filePath);

            //Wrapping file reader into BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Closing resources
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Please check the file path.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }
    }
}



