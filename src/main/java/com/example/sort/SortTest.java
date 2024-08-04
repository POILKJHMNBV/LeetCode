package com.example.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] array = getRandomArray(100000);
        int length = array.length;
        int[] arrayCopy1 = Arrays.copyOf(array, length);
        int[] arrayCopy2 = Arrays.copyOf(array, length);
        int[] arrayCopy3 = Arrays.copyOf(array, length);
        int[] arrayCopy4 = Arrays.copyOf(array, length);
        int[] arrayCopy5 = Arrays.copyOf(array, length);
        testSelectionSort(arrayCopy1);
        testInsertSort0(arrayCopy2);
        testInsertSort1(arrayCopy3);
        testBubbleSort(arrayCopy4);
        testMergeSort(arrayCopy5);
        long start = System.currentTimeMillis();
        Arrays.sort(array);
        long end = System.currentTimeMillis();
        System.out.println("快速排序共耗时【" + (end -start) + "】毫秒");
    }

    private static void testSelectionSort(int[] array) {
        long start = System.currentTimeMillis();
        SortUtil.selectionSort(array);
        long end = System.currentTimeMillis();
        System.out.println("选择排序共耗时【" + (end -start) + "】毫秒");
    }

    private static void testInsertSort0(int[] array) {
        long start = System.currentTimeMillis();
        SortUtil.insertSort0(array);
        long end = System.currentTimeMillis();
        System.out.println("插入排序0共耗时【" + (end -start) + "】毫秒");
    }

    private static void testInsertSort1(int[] array) {
        long start = System.currentTimeMillis();
        SortUtil.insertSort(array);
        long end = System.currentTimeMillis();
        System.out.println("插入排序共耗时【" + (end -start) + "】毫秒");
    }

    private static void testBubbleSort(int[] array) {
        long start = System.currentTimeMillis();
        SortUtil.bubbleSort(array);
        long end = System.currentTimeMillis();
        System.out.println("冒泡排序共耗时【" + (end -start) + "】毫秒");
    }

    private static void testMergeSort(int[] array) {
        long start = System.currentTimeMillis();
        SortUtil.mergeSort(array);
        long end = System.currentTimeMillis();
        System.out.println("归并排序共耗时【" + (end -start) + "】毫秒");
    }

    private static int[] getRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(n);
        }
        return array;
    }

    private static int[] getSortArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] getReverseSortArray(int n) {
        int[] array = new int[n];
        for (int i = n - 1; i > 0; i--) {
            array[i] = i;
        }
        return array;
    }
}
