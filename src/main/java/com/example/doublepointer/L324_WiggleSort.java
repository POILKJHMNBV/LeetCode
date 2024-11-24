package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L324:摆动排序 II</p>
 * <p>给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。</p>
 * @author zhenwu
 * @date 2024/11/24 20:54
 */
public class L324_WiggleSort {
    public static void main(String[] args) {

    }

    private static void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int x = (n + 1) / 2;
        for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
            nums[i] = arr[j];
            if (i + 1 < n) {
                nums[i + 1] = arr[k];
            }
        }
    }
}
