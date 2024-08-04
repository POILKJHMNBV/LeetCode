package com.example.hw;

import java.util.Scanner;

/**
 * <p>图像物体的边界</p>
 * <p>
 *     给定一个二维数组M行N列，二维数组里的数字代表图片的像素，为了简化问题，仅包含像素1和5两种像素，每种像素代表一个物体2个物体相邻的格子为边界，求像素1代表的物体的边界个数。
 *     像素1代表的物体的边界指与像素5相邻的像素1的格子，边界相邻的属于同一个边界，相邻需要考虑8个方向(上，下，左，右，左上，左下，右上，右下)。
 *     其他约束:地图规格约束为: 0<M<100    0<N<100
 * </p>
 * <p>
 *     输入描述：
 *          第一行，行数M， 列数N
 *          第二行开始，是M行N列的像素的二维数组，仅包含像素1和5
 * </p>
 * <p>
 *     输出描述：像素1代表的物体的边界个数。如果没有边界输出0(比如只存在像素1，或者只存在像素5)。
 * </p>
 * @author zhenwu
 * @date 2024/7/17 20:17
 */
public class H59_ImageBorder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 5) {
                    for (int k = 0; k < 8; k++) {
                        // 标记可能为边界的点
                        if (inArea(grid, i + dx[k], j + dy[k])) {
                            grid[i + dx[k]][j + dy[k]] = 0;
                        }
                    }
                }
            }
        }

        // 统计边界数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j) || grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int k = 0; k < 8; k++) {
            dfs(grid, i + dx[k], j + dy[k]);
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
