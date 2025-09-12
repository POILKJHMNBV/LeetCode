package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L2279:装满石头的背包的最大数量</p>
 * @author zhenwu
 * @date 2025/9/12 23:12
 */
public class L2279_MaximumBags {
    public static void main(String[] args) {

    }

    /**
     * 贪心
     * 时间复杂度：O(n logn)
     * 空间复杂度：O(1)
     */
    private static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        for (int i = 0; i < n; i++) {
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int cnt = 0;
        for (int j : capacity) {
            additionalRocks -= j;
            if (additionalRocks < 0) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
