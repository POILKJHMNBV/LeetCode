package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L1679:K 和数对的最大数目</p>
 * @author zhenwu
 * @date 2024/9/1 10:08
 */
public class L1679_MaxOperations {
    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 3};
        int k = 6;
        System.out.println(maxOperations(nums, k));
    }

    private static int maxOperations(int[] nums, int k) {
        int count = 0, l = 0, r = nums.length - 1;
        Arrays.sort(nums);
        while (l < r) {
            if (nums[l] + nums[r] == k) {
                count++;
                l++;
                r--;
            } else if (nums[l] + nums[r] < k) {
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
