// src/Sorting_Algorithms/SortingAlgorithms.java
package Sorting_Algorithms;

public class SortingAlgorithms {
    public static void bubbleSort(int[] array) {
        /**
         * Método que realiza a ordenação Bubble Sort.
         * @param int[] array: Array que o Bubble Sort sera implementado.
         */
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if(array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

}
