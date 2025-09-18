package com.example.greedy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L1338:数组大小减半</p>
 * @author zhenwu
 * @date 2025/9/18 21:29
 */
public class L1338_MinSetSize {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.merge(num, 1, Integer::sum);
        }
        List<Integer> values = freq.values().stream().sorted((a, b) -> b - a).toList();
        int s = 0;
        for (int i = 0; ; i++) {
            s += values.get(i);
            if (s >= arr.length / 2) {
                return i + 1;
            }
        }
    }
}
