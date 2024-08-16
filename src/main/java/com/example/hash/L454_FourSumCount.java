package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L454:四数相加 II</p>
 * @author zhenwu
 * @date 2024/8/16 21:14
 */
public class L454_FourSumCount {
    public static void main(String[] args) {

    }

    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }

        int count = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(-i - j)) {
                    count += map.get(-i - j);
                }
            }
        }
        return count;
    }
}
