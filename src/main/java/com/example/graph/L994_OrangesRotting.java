package com.example.graph;

import java.util.ArrayDeque;

/**
 * <p>L994: 腐烂的橘子</p>
 * <p>
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * </p>
 */
public class L994_OrangesRotting {
    public static void main(String[] args) {

    }

    private static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // 新鲜橘子数量
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int minutes = 0;
        while (count > 0 && !queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                // 开始 bfs
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];

                if (inArea(grid, row - 1, col) && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    count--;
                    queue.offer(new int[]{row - 1, col});
                }

                if (inArea(grid, row + 1, col) && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    count--;
                    queue.offer(new int[]{row + 1, col});
                }

                if (inArea(grid, row, col - 1) && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    count--;
                    queue.offer(new int[]{row, col - 1});
                }

                if (inArea(grid, row, col + 1) && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    count--;
                    queue.offer(new int[]{row, col + 1});
                }
            }
        }

        return count > 0 ? -1 : minutes;
    }

    private static boolean inArea(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
