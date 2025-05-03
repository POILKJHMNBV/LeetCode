package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2364:统计坏数对的数目</p>
 * @author zhenwu
 * @date 2025/5/3 19:23
 * @see L1512_NumIdenticalPairs
 */
public class L2364_CountBadPairs {
    public static void main(String[] args) {

    }

    /**
     * j - i != nums[j] - nums[i]   =>  nums[i] - i != nums[j] - j
     * 正难则反：用总的个数减去 nums[i] - i = nums[j] - j 的个数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long countBadPairs(int[] nums) {
        int n = nums.length;
        long ans = (long) n * (n - 1) / 2, cnt = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            cnt += cntMap.getOrDefault(key, 0);
            cntMap.merge(key, 1, Integer::sum);
        }
        return ans - cnt;
    }
}
