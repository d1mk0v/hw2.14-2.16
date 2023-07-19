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
        int copy[] = Arrays.copyOf(arr, arr.length);
        return copy;
    }

    public static void sortBubble(int[] copy) {

        generateRandomArray();

        long start = System.currentTimeMillis();

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    swapElements(copy, j, j + 1);
                }
            }
        }

        System.out.println("bubbleSpeed - " + (System.currentTimeMillis() - start));
    }

    public static void sortSelection(int[] copy) {
        generateRandomArray();

        long start = System.currentTimeMillis();

        for (int i = 0; i < copy.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < copy.length; j++) {
                if (copy[j] < copy[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(copy, i, minElementIndex);
        }

        System.out.println("selectionSpeed - " + (System.currentTimeMillis() - start));

    }

    public static void sortInsertion(int[] copy) {
        generateRandomArray();

        long start = System.currentTimeMillis();

        for (int i = 1; i < copy.length; i++) {
            int temp = copy[i];
            int j = i;
            while (j > 0 && copy[j - 1] >= temp) {
                copy[j] = copy[j - 1];
                j--;
            }
            copy[j] = temp;
        }

        System.out.println("insertionSpeed - " + (System.currentTimeMillis() - start));
    }

    public static void swapElements(int[] copy, int indexA, int indexB) {
        int tmp = copy[indexA];
        copy[indexA] = copy[indexB];
        copy[indexB] = tmp;
    }
}
