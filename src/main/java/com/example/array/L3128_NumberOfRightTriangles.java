package com.example.array;

/**
 * <p>L3128:直角三角形</p>
 * @author zhenwu
 * @date 2025/5/11 21:39
 */
public class L3128_NumberOfRightTriangles {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m + n)
     */
    private static long numberOfRightTriangles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ans += (long) (rows[i] - 1) * (cols[j] - 1);
            }
        }
        return ans;
    }
}
