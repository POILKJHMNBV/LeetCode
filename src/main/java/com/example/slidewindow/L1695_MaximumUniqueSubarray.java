package com.example.slidewindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1695:删除子数组的最大得分</p>
 * @author zhenwu
 * @date 2025/2/10 21:29
 */
public class L1695_MaximumUniqueSubarray {
    public static void main(String[] args) {
        int[] nums = {187,470,25,436,538,809,441,167,477,110,275,133,666,345,411,459,490,266,987,965,429,166,809,
                340,467,318,125,165,809,610,31,585,970,306,42,189,169,743,78,810,70,382,367,490,787,670,476,278,775,
                673,299,19,893,817,971,458,409,886,434};
        System.out.println(nums.length);
        System.out.println(Arrays.stream(nums).distinct().count());
        System.out.println(maximumUniqueSubarray(nums));
    }

    /**
     * 删除子数组的最大得分
     * <p>滑动窗口</p>
     * <p>时间复杂度：O(n)</p>
     * <p>空间复杂度：O(n)</p>
     */
    private static int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int maxScore = 0;
        for (int r = 0, l = 0, n = nums.length, score = 0; r < n; r++) {
            score += nums[r];
            if (indexMap.containsKey(nums[r]) && indexMap.get(nums[r]) + 1 > l) {
                for (int i = l; i <= indexMap.get(nums[r]); i++) {
                    score -= nums[i];
                }
                l = indexMap.get(nums[r]) + 1;
            }
            indexMap.put(nums[r], r);
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }
}
