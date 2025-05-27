package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L1034:边界着色</p>
 *
 * @author zhenwu
 * @date 2025/5/27 21:51
 */
public class L1034_ColorBorder {

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int row = 1, col = 1, color = 2;
        int[][] res = colorBorder(grid, col, row, color);
        for (int[] nums : res) {
            System.out.println(Arrays.toString(nums));
        }
    }

    private static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        List<int[]> borders = new ArrayList<>();
        dfs(grid, new boolean[grid.length][grid[0].length], borders,
                row, col, grid[row][col]);
        for (int[] border : borders) {
            int x = border[0], y = border[1];
            grid[x][y] = color;
        }
        return grid;
    }

    private static void dfs(int[][] grid, boolean[][] visited,
                            List<int[]> borders,
                            int row, int col, int originalColor) {
        boolean isBorder = false;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int x = direction[0] + row, y = direction[1] + col;
            if (!inArea(grid, x, y) || grid[x][y] != originalColor) {
                isBorder = true;
            } else if (!visited[x][y]) {
                visited[x][y] = true;
                dfs(grid, visited, borders, x, y, originalColor);
            }
        }
        if (isBorder) {
            borders.add(new int[]{row, col});
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
