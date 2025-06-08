package com.example.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>L827:最大人工岛</p>
 * 最多 只能将一格 0 变成 1
 * 返回执行此操作后，grid 中最大的岛屿面积是多少？
 * @author zhenwu
 * @date 2025/6/8 16:05
 */
public class L827_LargestIsland {
    public static void main(String[] args) {

    }

    /**
     * 思路
     * 利用 DFS 计算出各个岛屿的面积，并标记每个 1（陆地格子）属于哪个岛。
     * 遍历每个 0，统计其上下左右四个相邻格子所属岛屿的编号，去重后，累加这些岛的面积，更新答案的最大值。
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    private static int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        List<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                // 编号+2, 区分原先的0和1
                areaList.add(dfs(grid, i, j, areaList.size() + 2));
            }
        }
        if (areaList.isEmpty()) {
            // 没有岛屿
            return 1;
        }

        // 去重, 防止当前格子上下左右的岛屿编号相同
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }

                int newArea = 1;
                set.clear();
                for (int[] direction : directions) {
                    int x = i + direction[0], y = j + direction[1];
                    if (inArea(grid, x, y) && grid[x][y] > 1 && set.add(grid[x][y])) {
                        newArea += areaList.get(grid[x][y] - 2);
                    }
                }
                ans = Math.max(ans, newArea);
            }
        }
        return ans == 0 ? m * n : ans;
    }

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * 计算岛屿面积
     * @param num 岛屿编号
     * @return 岛屿面积
     */
    private static int dfs(int[][] grid, int i, int j, int num) {
        grid[i][j] = num;
        int area = 1;
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (inArea(grid, x, y) && grid[x][y] == 1) {
                area += dfs(grid, x, y, num);
            }
        }
        return area;
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
