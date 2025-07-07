package com.example.bit;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2588:统计美丽子数组数目</p>
 * @author zhenwu
 * @date 2025/7/7 21:55
 */
public class L2588_BeautifulSubarrays {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1); // 预分配空间
        cnt.put(0, 1);
        for (int x : nums) {
            s ^= x;
            int c = cnt.getOrDefault(s, 0);
            ans += c;
            cnt.put(s, c + 1);
        }
        return ans;
    }
}
