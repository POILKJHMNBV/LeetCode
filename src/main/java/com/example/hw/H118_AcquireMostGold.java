package com.example.hw;

import java.util.Scanner;

/**
 * <p>小华最多能得到多少克黄金</p>
 * <p>
 *     小华按照地图去寻宝，地图上被划分成 m(0 ≤ m ≤ 50) 行和 n(0 ≤ n ≤ 50) 列的方格横纵坐标范围分别是[0, n−1]和[0, m−1]。
 *     在横坐标和纵坐标数位之和不大于 k(0 ≤ k ≤ 100) 的方格中存在黄金 (每个方格中仅存在一克黄金)，但横坐标和纵坐标数位之和大于 k 的方格存在危险不可进入。
 *     小华从入口(0, 0)进入，任何时候只能向左，右，上，下个方向移动一格。请问小华最多能获得多少克黄金?
 * </p>
 * <p>
 *     输入描述：输入中包含 3 个字数,分别为 m, n, k
 * </p>
 * <p>
 *     输出描述：最多能获得多少克黄金
 * </p>
 * @author zhenwu
 * @date 2024/7/28 15:26
 */
public class H118_AcquireMostGold {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt(), k = in.nextInt();
        if (m == 0 || n == 0) {
            System.out.println(0);
            return;
        }
        if ((m + n - 2) <= k) {
            System.out.println(m * n);
            return;
        }
        dfs(new int[m][n], 0, 0, k);
        System.out.println(maxGold);
    }

    private static int maxGold = 0;

    private static void dfs(int[][] grid, int i, int j, int k) {
        if (!inArea(grid, i, j) || grid[i][j] == 1 || (sum(i) + sum(j)) > k) {
            return;
        }
        grid[i][j] = 1;
        maxGold++;
        dfs(grid, i - 1, j, k);
        dfs(grid, i + 1, j, k);
        dfs(grid, i, j - 1, k);
        dfs(grid, i, j + 1, k);
    }

    private static int sum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
