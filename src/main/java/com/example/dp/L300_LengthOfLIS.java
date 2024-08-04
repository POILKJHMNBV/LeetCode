package com.example.dp;

import java.util.Arrays;

/**
 * <p>L300:最长递增子序列</p>
 * <p>给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。</p>
 * <p>子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。</p>
 */
public class L300_LengthOfLIS {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLISPro(nums));
    }

    /**
     * dp[i]: 以nums[i]结尾上升子序列的长度
     */
    private static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        // 初始化dp
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        Arrays.sort(dp);
        return dp[len - 1];
    }

    /**
     * dp[i]: 表示长度为 i+1 的所有上升子序列中，结尾最小的那个元素的数值
     * 这里的dp数组是一个有序数组
     */
    private static int lengthOfLISPro(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        // end 表示有序数组 dp 的最后一个已经赋值元素的下标
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (dp[end] < nums[i]) {
                // 如果 nums[i] 比最后一个赋值的元素还要大，说明找到了一个更长的上升子序列
                end++;
                dp[end] = nums[i];
            } else {
                // 尝试让长度固定的上升子序列的结尾更小，即找到第 1 个大于等于 nums[i] 的元素，让它更小
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                dp[left] = nums[i];
            }
        }
        end++;
        return end;
    }
}
