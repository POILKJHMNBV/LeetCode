package com.example.matrix;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1162:地图分析</p>
 * @author zhenwu
 * @date 2025/6/9 21:55
 */
public class L1162_MaxDistance {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistance(grid));
    }

    /**
     * 多源BFS
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    public int maxDistancePro(int[][] grid) {
        int n = grid.length;
        Deque<int[]> d = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    d.add(new int[]{i, j});
                    map.put(i * n + j, 0);
                }
            }
        }
        int ans = -1;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!d.isEmpty()) {
            int[] poll = d.poll();
            int dx = poll[0], dy = poll[1];
            int step = map.get(dx * n + dy);
            for (int[] di : dirs) {
                int nx = dx + di[0], ny = dy + di[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (grid[nx][ny] != 0) continue;
                grid[nx][ny] = step + 1;
                d.add(new int[]{nx, ny});
                map.put(nx * n + ny, step + 1);
                ans = Math.max(ans, step + 1);
            }
        }
        return ans;
    }

    private static int maxDistance(int[][] grid) {
        int n = grid.length, ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, bfs(grid, i, j));
                }
            }
        }
        return ans;
    }

    private static int getDistance(int x1, int y1,
                                   int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int bfs(int[][] grid, int i, int j) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            for (int k = 0, size = queue.size(); k < size; k++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int newX = point[0] + direction[0], newY = point[1] + direction[1];
                    if (!inArea(grid, newX, newY) || visited[newX][newY]) {
                        continue;
                    }
                    if (grid[newX][newY] == 1) {
                        return getDistance(i, j, newX, newY);
                    }
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
