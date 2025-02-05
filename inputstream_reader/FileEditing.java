/* InputStreamReader Problem 2: Read User Input and Write to File Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read user input from the console and
write the input to a file. Each input should be written as a new line in the file.
Approach:
Create an InputStreamReader to read from System.in (the console).
Wrap the InputStreamReader in a BufferedReader for efficient reading.
Create a FileWriter to write to the file.
Read user input using readLine() and write the input to the file.
Repeat the process until the user enters "exit" to stop inputting.
Close the file after the input is finished.
 */

package com.inputstream_reader;

import java.io.*;
public class FileEditing {
    public static void main(String[] args) {

        String filePath = "D:\\Week_03\\Day_04\\src\\com\\TextFiles\\Difference between StringBuilder and StringBuffer.txt";
        try {

            InputStreamReader inputStreamReader = new InputStreamReader(System.in) ;
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            FileWriter fileWriter = new FileWriter(filePath, true);

            String userInput;
            while (true) {
                System.out.println("Enter text (type 'exit101' to stop): \n");
                userInput = bufferedReader.readLine();

                if (userInput.equalsIgnoreCase("exit101")) {
                    break;  // Exit the loop if user types "exit101"
                }

                // Write the input to the file followed by a newline
                fileWriter.write(userInput + System.lineSeparator());
            }

            inputStreamReader.close();
            bufferedReader.close();
            fileWriter.close();

        }
        catch (FileNotFoundException e){
            System.out.println("File not found!");
        }
        catch (IOException e) {
            System.out.println("Error Reading the file!");
        }
    }
}
