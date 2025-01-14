package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L930:和相同的二元子数组</p>
 * @author zhenwu
 * @date 2025/1/14 20:35
 */
public class L930_NumSubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0};
        int goal = 0;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    /**
     * 前缀和 + hash
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int numSubarraysWithSumPro(int[] nums, int goal) {
        int n = nums.length + 1;
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (map.containsKey(prefixSum[i] - goal)) {
                count += map.get(prefixSum[i] - goal);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }

    /**
     * 前缀和
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    private static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length + 1;
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prefixSum[j] - prefixSum[i] == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}
