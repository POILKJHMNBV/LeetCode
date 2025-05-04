package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L3371:识别数组中的最大异常值</p>
 * @author zhenwu
 * @date 2025/5/4 9:44
 */
public class L3371_GetLargestOutlier {
    public static void main(String[] args) {

    }

    /**
     * 设异常值为 x，n - 2 个元素和为 y，则 x + 2y = sum
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int getLargestOutlier(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            cntMap.merge(num, 1, Integer::sum);
            sum += num;
        }

        int ans = -1000;
        for (int x : nums) {
            cntMap.merge(x, -1, Integer::sum);
            int z = sum - x;
            if (z % 2 == 0 && cntMap.getOrDefault(z / 2, 0) > 0) {
                ans = Math.max(ans, x);
            }
            cntMap.merge(x, 1, Integer::sum);
        }
        return ans;
    }
}
