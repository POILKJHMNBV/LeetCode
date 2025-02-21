package com.example.slidewindow;

import java.util.TreeMap;

/**
 * <p>L2762:不间断子数组</p>
 * @author zhenwu
 * @date 2025/2/21 21:25
 */
public class L2762_ContinuousSubarrays {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long continuousSubarrays(int[] nums) {
        long res = 0;
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int l = 0, r = 0, n = nums.length; r < n; r++) {
            cntMap.merge(nums[r], 1, Integer::sum);
            while (cntMap.lastKey() - cntMap.firstKey() > 2) {
                int out = nums[l++];
                cntMap.merge(out, -1, Integer::sum);
                if (cntMap.get(out) == 0) {
                    cntMap.remove(out);
                }
            }
            res += r - l + 1;
        }
        return res;
    }
}
