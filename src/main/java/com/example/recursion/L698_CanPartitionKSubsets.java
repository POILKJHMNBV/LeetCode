package com.example.recursion;

import java.util.Arrays;

/**
 * <p>L698:划分为k个相等的子集</p>
 * @author zhenwu
 * @date 2025/2/21 21:46
 */
public class L698_CanPartitionKSubsets {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 1, 2};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    private static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        return backtrack(nums.length - 1, 0, nums, 0, target, used, k);
    }

    private static boolean backtrack(int idx, int cnt,
                                     int[] nums, int curSum,
                                     int target, boolean[] used, int k) {
        if (cnt == k) {
            // 找到k个集合
            return true;
        }
        if (curSum == target) {
            // 当前集合的和已经为target, 寻找下一个满足条件的集合
            return backtrack(nums.length - 1, cnt + 1, nums, 0, target, used, k);
        }
        for (int i = idx; i >= 0; i--) {
            if (used[i] || curSum + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if (backtrack(i - 1, cnt, nums, curSum + nums[i], target, used, k)) {
                return true;
            }
            used[i] = false;
            if (curSum == 0) {
                // 当前集合一个值也没有加进去，之间返回false
                return false;
            }
        }
        return false;
    }
}
