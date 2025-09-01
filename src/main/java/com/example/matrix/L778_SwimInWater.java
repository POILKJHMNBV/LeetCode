package com.example.matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>L778:水位上升的泳池中游泳</p>
 * @author zhenwu
 * @date 2025/9/1 21:32
 */
public class L778_SwimInWater {
    public static void main(String[] args) {

    }

    /**
     * 思路：使用优先队列，从左上角开始，每次取出 elevation 最小的格子，并更新 ans，如果当前格子是右下角，则返回 ans
     * 时间复杂度：O(n^2 log n)
     * 空间复杂度：O(n^2)
     */
    private static int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], elevation = cur[2];
            ans = Math.max(ans, elevation);
            if (x == n - 1 && y == n - 1) {
                return ans;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                pq.offer(new int[]{nx, ny, grid[nx][ny]});
            }
        }
        return ans;
    }
}
