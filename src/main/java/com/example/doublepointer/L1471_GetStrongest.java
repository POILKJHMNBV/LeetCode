package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L1471:数组中的 k 个最强值</p>
 * @author zhenwu
 * @date 2025/2/25 21:47
 */
public class L1471_GetStrongest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(Arrays.toString(getStrongest(arr, k)));
    }

    /**
     * 排序 + 双指针
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    private static int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length, l = 0, r = n - 1, median = arr[(n - 1) / 2];
        int[] ans = new int[k];
        k--;
        while (k >= 0 && l <= r) {
            ans[k--] = Math.abs(arr[r] - median) >= Math.abs(arr[l] - median) ? arr[r--] : arr[l++];
        }
        return ans;
    }
}
