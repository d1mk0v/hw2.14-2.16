package org.example;

import java.util.Arrays;

public class SortMethods {
    public static void main(String[] args) {
        sortBubble(generateRandomArray());
        sortSelection(generateRandomArray());
        sortInsertion(generateRandomArray());
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1) + 1_000_000;
        }
        return arr;
    }

    public static void sortBubble(int[] arr) {
        generateRandomArray();

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }

        System.out.println("bubbleSpeed - " + (System.currentTimeMillis() - start));
    }

    public static void sortSelection(int[] arr) {
        generateRandomArray();

        long start = System.currentTimeMillis();

        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }

        System.out.println("selectionSpeed - " + (System.currentTimeMillis() - start));

    }

    public static void sortInsertion(int[] arr) {
        generateRandomArray();

        long start = System.currentTimeMillis();

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

        System.out.println("insertionSpeed - " + (System.currentTimeMillis() - start));
    }

    public static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
