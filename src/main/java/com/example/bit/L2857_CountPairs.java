package com.example.bit;

import java.util.HashMap;
import java.util.List;

/**
 * <p>L2857:统计距离为 k 的点对</p>
 * @author zhenwu
 * @date 2025/7/10 22:13
 */
public class L2857_CountPairs {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * k)
     * 空间复杂度：O(n)
     */
    private static int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        HashMap<Long, Integer> cnt = new HashMap<>();
        for (var p : coordinates) {
            int x = p.get(0), y = p.get(1);
            for (int i = 0; i <= k; i++) {
                ans += cnt.getOrDefault((x ^ i) * 2000000L + (y ^ (k - i)), 0);
            }
            cnt.merge(x * 2000000L + y, 1, Integer::sum);
        }
        return ans;
    }
}
