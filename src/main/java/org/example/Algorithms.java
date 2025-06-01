package org.example;

import java.util.Random;

public class Algorithms {
    static public void selection(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 1; j <= i; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if(array[i] < array[maxIndex]){
                Algorithms.swap(array, i, maxIndex);
            }
        }

        printArray(array);
    }

    static public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // The element to be inserted
            int j = i - 1;

            // Shift elements to the right until we find the correct position for 'key'
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key; // Insert key at the right position
        }

        // Print sorted array
//        printArray(array);
    }




    private static void swap(int[] array, int index1, int index2) {
        if (index1 == index2) return;
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void shellSort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }

        printArray(array);

    }

    public static int recursion(int number) {
        if (number == 0) {
            return 1;
        }

        return recursion(number - 1) *number;
    }

    public static void mergeSort(int[] input, int start, int end) {
        if(end - start < 2){
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    private static void merge(int[] input, int start, int mid, int end) {
        if(end - start < 2){
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }
        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }

    public static void quickSort(int[] input, int start, int end) {
        if(end - start < 2){
            return;
        }

        int pivotIndex = partition(input,start,end);
        quickSort(input, start, pivotIndex);// left of the pivot element.
        quickSort(input, pivotIndex + 1, end);// right of the pivot element.
    }

    private static int partition(int[] input, int start, int end) {
        // Use the first element as the pivot.
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            // This is an empty loop for decrementing the j for the right.
            while (i < j && input[--j] >= pivot);
            if(i < j)
            {
                input[i] = input[j];
            }

            // Empty loop for incrementing i for the left
            while (i < j && input[++i] <= pivot) ;

            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;

        return j;
    }

    static public void countingSort(int[] input, int min, int max) {

        int[] countArray = new int[max - min + 1];

        for (int i = 0; i < max - min + 1; i++) {
            int index = input[i] - min;
            countArray[index]++;
        }
        int currentIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            int num = min + i;
            for(int j = 0; j < countArray[i]; j++){
                input[currentIndex++] = num;
            }
        }
    }

    static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;

        int[] countArray = new int[radix];

        for(int value : input){
            countArray[gerDigit(position, value, radix)]++;
        }

        //adjust the count array;
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--){
            temp[--countArray[gerDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for(int tempIndex = 0; tempIndex < numItems; tempIndex++){
            input[tempIndex] = temp[tempIndex];
        }

    }

    public static int gerDigit(int position, int value, int radix) {
        return value /  (int) Math.pow(10, position) % radix;

    }

    public static int[] generateRandomArray(int size, int bound, int lowerBound) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int rand = random.nextInt(bound);
            while (rand < lowerBound) {
                rand = random.nextInt(bound);
            }
            array[i] = rand;
        }

        return array;
    }

    public static void classInsertion(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = 0;
            while( key > arr[j]){
                j++;
            }

            for(int k = i; k > j; k--){
                arr[k] = arr[k-1];
            }
            arr[j] = key;
        }
    }

}
