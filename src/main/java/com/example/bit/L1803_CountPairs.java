package com.example.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1803:统计异或值在范围内的数对有多少</p>
 * @author zhenwu
 * @date 2025/7/11 21:54
 */
public class L1803_CountPairs {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static int countPairs(int[] nums, int low, int high) {
        int ans = 0;
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        for (++high; high > 0; high >>= 1, low >>= 1) {
            HashMap<Integer, Integer> nxt = new HashMap<>();
            for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
                int x = e.getKey(), c = e.getValue();
                if ((high & 1) == 1) ans += c * cnt.getOrDefault(x ^ (high - 1), 0);
                if ((low & 1) == 1)  ans -= c * cnt.getOrDefault(x ^ (low - 1), 0);
                nxt.put(x >> 1, nxt.getOrDefault(x >> 1, 0) + c);
            }
            cnt = nxt;
        }
        return ans / 2;
    }
}
