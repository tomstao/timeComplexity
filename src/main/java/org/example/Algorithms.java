package org.example;


public class Algorithms {

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
