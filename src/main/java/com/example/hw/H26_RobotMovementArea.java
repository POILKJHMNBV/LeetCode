package com.example.hw;

import java.util.Scanner;

/**
 * <p>机器人活动区域</p>
 * <p>
 *     现有一个机器人，可放置于 M x N 的网格中任意位置，每个网格包含一个非负整数编号，当相邻网格的数字编号差值的绝对值小于等于 1 时机器人可以在网格间移动。
 *     问题: 求机器人可活动的最大范围对应的网格点数目。
 *     说明：网格左上角坐标为(0,0),右下角坐标为(m - 1,n - 1)机器人只能在相邻网格间上下左右移动。
 * </p>
 * <p>
 *      输入描述：
 *          第 1 行入为 M 和N， M 表示网格的行数 N表示网格的列数
 *          之后 M 行表示网格数值，每行 N 个数值 (数值大小用 k 表示)数值间用单个空格分隔，行首行尾无多余空格。
 *          1 <= M,N <= 150，0 <= k <= 50
 * </p>
 * <p>
 *     输出描述：
 *          输出 1行，包含 1个数字，表示最大活动区域的网格点数目, 行首行尾无多余空格。
 * </p>
 * @author zhenwu
 * @date 2024/7/8 21:31
 */
public class H26_RobotMovementArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        int maxMovementArea = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxMovementArea = Math.max(maxMovementArea, dfs(grid, i, j, new boolean[rows][cols]));
            }
        }
        System.out.println(maxMovementArea);
    }

    private static int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int count = 1;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (inArea(grid, newX, newY) && Math.abs(grid[x][y] - grid[newX][newY]) <= 1) {
                count += dfs(grid, newX, newY, visited);
            }
        }
        return count;
    }

    private static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
