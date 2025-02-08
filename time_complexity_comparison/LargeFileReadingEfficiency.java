/* 4. Problem Statement: Large File Reading Efficiency
Objective:
Compare FileReader (Character Stream) and InputStreamReader (Byte Stream) when reading a large file (500MB).
Approach:
FileReader: Reads character by character (slower for binary files).
InputStreamReader: Reads bytes and converts to characters (more efficient).
Expected Result:
InputStreamReader is more efficient for large files.
FileReader is preferable for text-based data.

 */
package com.time_complexity_comparison;

import java.io.*;

public class LargeFileReadingEfficiency {
    static void efficiencyTest(String filePath) {
        long startTime, endTime, netTime;

        // FileReader with BufferedReader
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            startTime = System.nanoTime();

            String line ; // Read in chunks (efficient for large files)
            while ((line = bufferedReader.readLine()) != null) {
                // File is read, but not printed
            }

            endTime = System.nanoTime();
            netTime = (endTime - startTime) / 1_000_000;
            System.out.println("FileReader Time: " + netTime + " ms.");
            System.out.println("FileReader Time: " + (endTime - startTime) + " ns.\n");

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Please check the file path.");
        } catch (IOException e) {
            System.err.println("Error reading the file.");
        }

        // InputStreamReader with BufferedReader
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            startTime = System.nanoTime();

            String line; // Read in chunks
            while ((line = bufferedReader.readLine()) != null) {
                // File is read, but not printed
            }

            endTime = System.nanoTime();
            netTime = (endTime - startTime) / 1_000_000;
            System.out.println("InputStreamReader Time: " + netTime + " ms.");
            System.out.println("InputStreamReader Time: " + (endTime - startTime) + " ns.\n");

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Please check the file path.");
        } catch (IOException e) {
            System.err.println("Error reading the file.");
        }
    }

    public static void main(String[] args) {
        String filePath1 = "D:\\Week_03\\Day_06\\src\\com\\text_files\\1MB file.txt";
        String filePath2 = "D:\\Week_03\\Day_06\\src\\com\\text_files\\10MB file.txt";
        String filePath3 = "D:\\Week_03\\Day_06\\src\\com\\text_files\\250MB file.txt";

        System.out.println("\n\tReading 1MB File");
        efficiencyTest(filePath1);

        System.out.println("\n\tReading 10MB File");
        efficiencyTest(filePath2);

        System.out.println("\n\tReading 250MB File");
        efficiencyTest(filePath3);
    }
}
