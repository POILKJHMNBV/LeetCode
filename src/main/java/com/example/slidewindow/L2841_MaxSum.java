package com.example.slidewindow;

import java.util.*;

/**
 * <p>L2841:几乎唯一子数组的最大和</p>
 * @author zhenwu
 * @date 2025/2/3 16:49
 */
public class L2841_MaxSum {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1,1,1,3);
        int m = 2;
        int k = 2;
        System.out.println(maxSum(nums, m, k));
    }

    /**
     * 滑动窗口求最大值，窗口大小为minutes
     * 时间复杂度: O(n)
     * 空间复杂度: O(k)
     */
    private static long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        long sum = 0;

        // key -> 滑动窗口中的元素 value -> 索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
            map.put(nums.get(i), i);
        }
        long maxSum = 0;
        if (map.size() >= m) {
            maxSum = sum;
        }
        int l = 0, r = k;
        while (r < n) {
            if (Objects.equals(map.get(nums.get(l)), l)) {
                map.remove(nums.get(l));
            }
            map.put(nums.get(r), r);
            sum += nums.get(r) - nums.get(l);
            if (map.size() >= m) {
                maxSum = Math.max(sum, maxSum);
            }
            l++;
            r++;
        }
        return maxSum;
    }
}
