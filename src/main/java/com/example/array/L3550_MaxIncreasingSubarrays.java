package com.example.array;

import java.util.List;

/**
 * <p>L3350:检测相邻递增子数组 II</p>
 * @author zhenwu
 * @date 2025/3/28 22:32
 */
public class L3550_MaxIncreasingSubarrays {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = 0, preCnt = 0, cnt = 0, n = nums.size();
        for (int i = 0; i < n; i++) {
            cnt++;
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                ans = Math.max(ans, Math.max(cnt / 2, Math.min(preCnt, cnt)));
                preCnt = cnt;
                cnt = 0;
            }
        }
        return ans;
    }
}
