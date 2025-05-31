package com.example.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * <p>L1905:统计子岛屿</p>
 * @author zhenwu
 * @date 2025/5/31 10:42
 */
public class L1905_CountSubIslands {
    public static void main(String[] args) {

    }

    /**
     * bfs
     */
    private static int countSubIslandsPro(int[][] grid1, int[][] grid2) {
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int subIslands = 0;
        int m = grid1.length, n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                boolean isSubIsland = true;
                visited[i][j] = true;
                Queue<int[]> queue = new ArrayDeque<int[]>();
                queue.offer(new int[]{i, j});
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll();
                    int row = cell[0], col = cell[1];
                    if (grid1[row][col] == 0) {
                        isSubIsland = false;
                    }
                    for (int[] dir : dirs) {
                        int newRow = row + dir[0], newCol = col + dir[1];
                        if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid2[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                            visited[newRow][newCol] = true;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
                if (isSubIsland) {
                    subIslands++;
                }
            }
        }
        return subIslands;
    }

    /**
     * dfs
     */
    private static int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        int cnt = 0;
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] != 1) {
                    continue;
                }
                dfsGrid2(grid2, i, j, pointSet);
                dfsGrid1(grid1, new boolean[m][n], i, j, pointSet);
                if (pointSet.isEmpty()) {
                    cnt++;
                }
                pointSet.clear();;
            }
        }
        return cnt;
    }

    private static void dfsGrid1(int[][] grid, boolean[][] visited,
                                 int i, int j,
                                 Set<Point> pointSet) {
        if (!inArea(grid, i, j) || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        pointSet.remove(new Point(i, j));
        visited[i][j] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int x = direction[0] + i, y = direction[1] + j;
            dfsGrid1(grid, visited, x, y, pointSet);
        }
    }

    private static void dfsGrid2(int[][] grid, int i, int j, Set<Point> pointSet) {
        if (!inArea(grid, i, j) || grid[i][j] < 1) {
            return;
        }
        pointSet.add(new Point(i, j));
        grid[i][j] = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int x = direction[0] + i, y = direction[1] + j;
            dfsGrid2(grid, x, y, pointSet);
        }
    }

    static class Point {

        final int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
