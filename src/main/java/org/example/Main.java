package org.example;

import static org.example.BubbleSort.bubbleSort;
import static org.example.BubbleSort.printArray;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] data = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Array before sorting:");
        printArray(data);

        bubbleSort(data);

        System.out.println("\nArray after sorting:");
        printArray(data);

        int[] anotherData = {5, 1, 4, 2, 8};
        System.out.println("\nAnother array before sorting:");
        printArray(anotherData);

        bubbleSort(anotherData);

        System.out.println("\nAnother array after sorting:");
        printArray(anotherData);
    }
}