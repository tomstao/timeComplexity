package org.example;


public class SortTestArrayGenerator {


    public static void main(String[] args) {
        String filePath = "src/numbers_1M.txt";
        int expectedNumberOfIntegers = 1_000_000;

        int[] testArray1 = DataLoader.loadNumbersFromFile(filePath, expectedNumberOfIntegers);
        int[] testArray2 = DataLoader.loadNumbersFromFile(filePath, expectedNumberOfIntegers);
        int[] testArray3 = DataLoader.loadNumbersFromFile(filePath, expectedNumberOfIntegers);

        System.out.println("Array generated.");

        timePerformance("bubbleSort", testArray1);
        System.out.println("Sorting completed--------------------------------");
        timePerformance("insertionSort", testArray2);
        System.out.println("Sorting completed--------------------------------");
        timePerformance("mergeSort", testArray3);


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


        System.out.print("First 10 elements: ");
        for (int i = 0; i < 10; i++) {
            assert testArray != null;
            System.out.print(testArray[i] + " ");
        }
        System.out.println();

        System.out.print("Last 10 elements: ");
        for (int i = Math.max(0, testArray.length - 10); i < testArray.length; i++) {
            System.out.print(testArray[i] + " ");
        }
        System.out.println();
    }
}