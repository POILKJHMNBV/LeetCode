package com.example.array;

/**
 * <p>L845:数组中的最长山脉</p>
 * @author zhenwu
 * @date 2025/3/23 10:23
 */
public class L845_LongestMountain {
    public static void main(String[] args) {
        int[] arr = {2, 3};
        System.out.println(longestMountain(arr));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestMountain(int[] arr) {
        int maxLen = 0, n = arr.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && arr[j] > arr[j - 1]) {
                j++;
            }

            if (j >= n) {
                break;
            }

            // j未发生移动
            if (j == i + 1) {
                continue;
            }

            // arr[j] <= arr[j - 1]
            int k = j;
            while (k < n && arr[k] == arr[k - 1]) {
                k++;
            }
            if (k != j) {
                i = k - 2;
                continue;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            while (j < n && arr[j] < arr[j - 1]) {
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }
}
