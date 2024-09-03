package com.example.hash;

/**
 * <p>L2352:相等行列对</p>
 * @author zhenwu
 * @date 2024/9/3 20:36
 */
public class L2352_EqualPairs {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        System.out.println(equalPairs(grid));
    }

    private static int equalPairs(int[][] grid) {
        int count = 0, len = grid.length;
        for (int[] nums : grid) {
            for (int j = 0; j < len; j++) {
                int k = 0;
                for (; k < len; k++) {
                    if (nums[k] != grid[k][j]) {
                        break;
                    }
                }
                if (k == len) {
                    count++;
                }
            }
        }
        return count;
    }
}
