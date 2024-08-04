package com.example.hw;

import java.util.Scanner;

/**
 * <p>中庸行者</p>
 * <p>给定一个m * n的整数矩阵作为地图，短阵数值为地形高度；中庸行者选择地图中的任意一点作为起点，尝试往上、下、左、右四个相邻格子移动; 移动时有如下约束:</p>
 * <p>
 *      中庸行者只能上坡或者下坡，不能走到高度相同的点
 *      不允许连续上坡或者连续下坡，需要交替进行，
 *      每个位置只能经过一次，不能重复行走，
 * </p>
 * <p>请给出中庸行者在本地图内，能连续移动的最大次数</p>
 * @author zhenwu
 * @date 2024/6/26 21:17
 */
public class H2_ModerationHuman {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(grid, i, j, new boolean[rows][cols], true, 0);
                dfs(grid, i, j, new boolean[rows][cols], false, 0);
            }
        }
        System.out.println(maxTimes);
    }

    private static int maxTimes = 0;

    /**
     * @param grid 矩阵
     * @param i 当前行
     * @param j 当前列
     * @param visited 访问数组
     * @param up 是否上坡到达此位置
     * @param times 移动次数
     */
    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, boolean up, int times) {
        maxTimes = Math.max(maxTimes, times);
        visited[i][j] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (prohibitVisit(grid, x, y, visited)) {
                continue;
            }
            if (up && grid[x][y] >= grid[i][j]) {
                continue;
            }
            if (!up && grid[x][y] < grid[i][j]) {
                continue;
            }
            dfs(grid, x, y, visited, !up, times + 1);
        }
    }

    private static boolean prohibitVisit(int[][] grid, int i, int j, boolean[][] visited) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j];
    }
}
