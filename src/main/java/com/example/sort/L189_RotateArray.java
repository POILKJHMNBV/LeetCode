package com.example.sort;

import java.util.Arrays;

/**
 * <p>L189:给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数</p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class L189_RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 9);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotatePro(int[] nums, int k) {
        int n = nums.length, m = k % n;
        if (m == 0) {
            return;
        }
        swap(nums, 0, n - 1);
        swap(nums, 0, m - 1);
        swap(nums, m, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        for (; i < j ; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    private static void rotate(int[] nums, int k) {
        int len = nums.length;
        int tempLen = k % len;
        if (tempLen == 0) {
            return;
        }
        int[] temp = new int[tempLen];
        int j = tempLen - 1;
        for (int i = len - 1; i >= len - tempLen; i--) {
            temp[j--] = nums[i];
        }

        if (len - tempLen - 1 + 1 >= 0) System.arraycopy(nums, 0, nums, tempLen, len - tempLen - 1 + 1);

        System.arraycopy(temp, 0, nums, 0, tempLen);
    }
}
