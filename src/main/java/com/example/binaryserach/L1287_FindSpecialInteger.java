package com.example.binaryserach;

/**
 * <p>L1287:有序数组中出现次数超过25%的元素</p>
 * @author zhenwu
 * @date 2025/4/12 22:27
 */
public class L1287_FindSpecialInteger {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        System.out.println(findSpecialInteger(arr));
    }

    /**
     * 时间：O(log n)
     * 空间：O(1)
     */
    private static int findSpecialIntegerPro(int[] arr) {
        int n = arr.length, span = n / 4 + 1;
        for (int i = 0; i < n; i += span) {
            int start = leftBound(arr, arr[i]);
            int end = leftBound(arr, arr[i] + 1);
            if (end - start >= span) {
                return arr[i];
            }
        }
        return -1;
    }

    private static int leftBound(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    /**
     * 时间：O(n)
     * 空间：O(1)
     */
    private static int findSpecialInteger(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && arr[j] == arr[i]) {
                j++;
            }
            if (j - i > n / 4) {
                return arr[i];
            }
            i = j;
        }
        return -1;
    }
}
