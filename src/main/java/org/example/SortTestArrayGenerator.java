package org.example;

import java.util.Random;

public class SortTestArrayGenerator {

    public static int[] generateArrayForSorting(int size, int upperBound) {
        if (size <= 0) {
            throw new IllegalArgumentException("Array size must be positive.");
        }
        if (upperBound <= 0) {
            throw new IllegalArgumentException("Upper bound must be positive.");
        }

        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(upperBound);
        }
        return arr;
    }

    public static void main(String[] args) {
        String filePath = "src/numbers_1M.txt";
        int expectedNumberOfIntegers = 1_000_000;

        int[] testArray1 = DataLoader.loadNumbersFromFile(filePath, expectedNumberOfIntegers);
        int[] testArray2 = DataLoader.loadNumbersFromFile(filePath, expectedNumberOfIntegers);
        int[] testArray3 = DataLoader.loadNumbersFromFile(filePath, expectedNumberOfIntegers);
//        int arraySize = 1_000_000; // 10^6
//        int arraySize = 1_000_000;
//        int numberUpperBound = 100;

//        System.out.println("Generating an array of " + arraySize +
//                " integers, with each integer < " + numberUpperBound + "...");
//        int[] testArray = generateArrayForSorting(arraySize, numberUpperBound);
        System.out.println("Array generated.");
//        long startTime = System.nanoTime();

//        long endTime = System.nanoTime();
//        BubbleSort.bubbleSort(testArray);
//        long durationMs = (endTime - startTime) / 1_000_000;
//        System.out.println("Bubble sort completed in " + durationMs + " ms.");

        timePerformance("bubbleSort", testArray1);
        System.out.println("Sorting completed--------------------------------");
        timePerformance("insertionSort", testArray2);
        System.out.println("Sorting completed--------------------------------");
        timePerformance("mergesort", testArray3);
//        timePerformance("insertionSort", testArray);
//        timePerformance("mergeSort", testArray);

        System.out.print("First 10 elements: ");
        for (int i = 0; i < 10; i++) {
            assert testArray1 != null;
            System.out.print(testArray1[i] + " ");
        }
        System.out.println();

        System.out.print("Last 10 elements: ");
        for (int i = Math.max(0, testArray1.length - 10); i < testArray1.length; i++) {
            System.out.print(testArray1[i] + " ");
        }
        System.out.println();

    }

    public static void timePerformance(String methodName, int[] testArray) {
        System.out.println("Running " + methodName);
        long startTime = System.nanoTime();

        if (methodName.equals("bubbleSort")) {
            BubbleSort.bubbleSort(testArray);
        }

        if (methodName.equals("insertionSort")) {
            Algorithms.insertionSort(testArray);
        }

        if (methodName.equals("mergeSort")) {
            Algorithms.mergeSort(testArray, 0, testArray.length);
        }


        long endTime = System.nanoTime();
        System.out.println("Time for " + methodName + ": " + (endTime - startTime) + " ns");

    }
}