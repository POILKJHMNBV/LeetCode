package com.example.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L1403:非递增顺序的最小子序列</p>
 * @author zhenwu
 * @date 2025/9/16 21:30
 */
public class L1403_MinSubsequence {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1, curSum = 0; i >= 0 && 2 * curSum <= sum; i--) {
            res.add(nums[i]);
            curSum += nums[i];
        }
        return res;
    }
}
