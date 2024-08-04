package com.example.hw;

import java.util.Scanner;

/**
 * <p>可以组成网络的服务器</p>
 * <p>
 *     在一个机房中，服务器的位置标识在n*m的整数矩阵网格中，1表示单元格上有服务器，0表示没有。
 *     如果两台服务器位于同一行或者同一列中紧邻的位置，则认为它们之间可以组成一个局域网，请你统计机房中最大的局域网包含的服务器个数。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入两个正整数，n和m，0<n,m<=100
 *          之后为n*m的二维数组，代表服务器信息
 * </p>
 * <p>
 *     输出描述：
 *          最大局域网包含的服务器个数。
 * </p>
 * @author zhenwu
 * @date 2024/7/2 21:20
 */
public class H10_CanConstituteNetworkServer {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt(); int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxServerCount = Math.max(dfs(grid, i, j), maxServerCount);
                }
            }
        }
        System.out.println(maxServerCount);
    }

    private static int maxServerCount = 0;

    private static int dfs(int[][] grid, int x, int y) {
        if (!inArea(grid, x, y) || grid[x][y] == -1 || grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = -1;
        return 1 + dfs(grid, x - 1, y)
                 + dfs(grid, x, y + 1)
                 + dfs(grid, x + 1, y)
                 + dfs(grid, x, y - 1);
    }

    private static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
