package com.example.array;

/**
 * <p>L2874:有序三元组中的最大值 II</p>
 * @author zhenwu
 * @date 2025/5/3 18:59
 */
public class L2874_MaximumTripletValue {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long maximumTripletValue(int[] nums) {
        long ans = 0;
        // maxDiff：nums[i] - nums[j] 的最大值   preMax：nums[i] 的最大值
        int maxDiff = 0, preMax = 0;
        for (int num : nums) {
            ans = Math.max(ans, (long) maxDiff * num);
            maxDiff = Math.max(maxDiff, preMax - num);
            preMax = Math.max(preMax, num);
        }
        return ans;
    }
}
