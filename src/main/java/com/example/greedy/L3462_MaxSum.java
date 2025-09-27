package com.example.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L3462:提取至多 K 个元素的最大总和</p>
 * @author zhenwu
 * @date 2025/9/27 19:59
 */
public class L3462_MaxSum {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(m * n log n * m)
     * 空间复杂度：limits[i] 之和
     */
    private static long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> nums = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
            for (int j = n - limits[i]; j < n; j++) {
                nums.add(grid[i][j]);
            }
        }
        nums.sort((a, b) -> b - a);
        long res = 0;
        for (int i = 0; i < k; i++) {
            res += nums.get(i);
        }
        return res;
    }
}
