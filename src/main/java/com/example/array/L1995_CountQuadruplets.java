package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1995:统计特殊四元组</p>
 * @author zhenwu
 * @date 2025/5/6 21:45
 */
public class L1995_CountQuadruplets {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 5};
        System.out.println(countQuadruplets(nums));
    }

    /**
     * nums[a] + nums[b] = nums[d] − nums[c]
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(n)
     */
    private static int countQuadruplets(int[] nums) {
        int ans = 0, n = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int b = n - 3; b >= 1; b--) {
            for (int d = b + 2, c = b + 1; d < n; d++) {
                cntMap.merge(nums[d] - nums[c], 1, Integer::sum);
            }
            for (int a = 0; a < b; a++) {
                ans += cntMap.getOrDefault(nums[a] + nums[b], 0);
            }
        }
        return ans;
    }
}
