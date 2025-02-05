/* InputStreamReader Problem 1: Convert Byte Stream to Character Stream Using InputStreamReader
Problem:
Write a program that uses InputStreamReader to read binary data from a file and print it as characters.
The file contains data encoded in a specific charset (e.g., UTF-8).
Approach:
Create a FileInputStream object to read the binary data from the file.
Wrap the FileInputStream in an InputStreamReader to convert the byte stream into a character stream.
Use a BufferedReader to read characters efficiently from the InputStreamReader.
Read the file line by line and print the characters to the console.
Handle any encoding exceptions as needed.
 */
package com.inputstream_reader;

import java.io.*;
public class ByteStreamToCharacterStream {
    public static void main(String[] args) {
        try {
            String filePath = "D:\\Week_03\\Day_04\\src\\com\\TextFiles\\Difference between StringBuilder and StringBuffer.txt";
            FileInputStream file = new FileInputStream(filePath);
            InputStreamReader inputStreamReader = new InputStreamReader(file, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found! ");
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
