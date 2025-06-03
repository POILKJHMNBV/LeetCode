package com.example.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L417:太平洋大西洋水流问题</p>
 * @author zhenwu
 * @date 2025/6/3 21:43
 */
public class L417_PacificAtlantic {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(pacificAtlantic(heights));
    }

    private static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(heights, i, j, new boolean[m][n]) == 3) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    private static int dfs(int[][] heights,
                           int i, int j,
                           boolean[][] visited) {
        visited[i][j] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int ans = 0;
        for (int[] direction : directions) {
            int x = direction[0] + i, y = direction[1] + j;
            if (canReachPacific(x, y)) {
                ans |= 1;
                continue;
            }
            if (canReachAtlantic(heights, x, y)) {
                ans |= 2;
                continue;
            }
            if (!visited[x][y] && heights[x][y] <= heights[i][j]) {
                ans |= dfs(heights, x, y, visited);
            }
        }
        return ans;
    }

    private static boolean canReachPacific(int i, int j) {
        return i < 0 || j < 0;
    }

    private static boolean canReachAtlantic(int[][] heights, int i, int j) {
        return i >= heights.length || j >= heights[0].length;
    }
}
