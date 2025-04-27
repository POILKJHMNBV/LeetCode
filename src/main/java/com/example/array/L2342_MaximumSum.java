package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2342:数位和相等数对的最大和</p>
 *
 * @author zhenwu
 * @date 2025/4/27 22:24
 */
public class L2342_MaximumSum {
    public static void main(String[] args) {
        int[] nums = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(nums));
    }

    /**
     * 时间：O(n)
     * 空间：O(n)
     */
    private static int maximumSum(int[] nums) {
        int maxSum = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = sum(num);
            if (map.containsKey(key)) {
                maxSum = Math.max(maxSum, num + map.get(key));
            }
            map.put(key, Math.max(num, map.getOrDefault(key, -1)));
        }
        return maxSum;
    }

    private static int sum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}
