package com.example.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L2593:标记所有元素后数组的分数</p>
 * @author zhenwu
 * @date 2025/3/31 21:44
 */
public class L2593_FindScore {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static long findScore(int[] nums) {
        Integer[] idx = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> nums[i]));
        long ans = 0;
        boolean[] visited = new boolean[nums.length + 2];
        for (int i : idx) {
            if (!visited[i + 1]) {
                // 防止越界
                visited[i] = visited[i + 2] = true;
                ans += nums[i];
            }
        }
        return ans;
    }
}
