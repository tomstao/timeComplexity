package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static int[] loadNumbersFromFile(String filePath, int expectedCount) {
        System.out.println("Loading numbers from file: " + filePath);
        long startTime = System.nanoTime();

        List<Integer> numberList = new ArrayList<>(expectedCount > 0 ? expectedCount : 1024);


        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    numberList.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Skipping invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        int[] numbers = new int[numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            numbers[i] = numberList.get(i);
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;
        System.out.println("Finished loading " + numbers.length + " numbers in " + durationMs + " ms.");
        return numbers;
    }

    public static void main(String[] args) {
        String filePath = "src/numbers_1M.txt";
        int expectedNumberOfIntegers = 1_000_000;

        int[] testArray = loadNumbersFromFile(filePath, expectedNumberOfIntegers);

        if (testArray != null && testArray.length > 0) {
            System.out.println("Successfully loaded array. First 10 elements:");
            for (int i = 0; i < Math.min(10, testArray.length); i++) {
                System.out.print(testArray[i] + " ");
            }
            System.out.println();


        } else {
            System.out.println("Failed to load the array.");
        }
    }
}