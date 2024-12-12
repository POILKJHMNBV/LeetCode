package com.example.num;

import java.util.Arrays;

/**
 * <p>L922:按奇偶排序数组 II</p>
 * @author zhenwu
 * @date 2024/12/12 22:08
 */
public class L922_SortArrayByParityII {
    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(nums)));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] sortArrayByParityII(int[] nums) {
        for (int i = 0, j = 1; i < nums.length && j < nums.length;) {
            if ((nums[i] & 1) == 0) {
                i += 2;
            } else if ((nums[j] & 1) == 1) {
                j += 2;
            } else {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}
