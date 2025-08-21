package com.example.graph;

import java.util.Arrays;

/**
 * <p>L3341:到达最后一个房间的最少时间 I</p>
 * @author zhenwu
 * @date 2025/8/21 21:47
 */
public class L3341_MinTimeToReach {
    public static void main(String[] args) {
        int[][] moveTime = {
                {17, 56},
                {97, 80}
        };
        System.out.println(minTimeToReach(moveTime));
    }

    /**
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(n * m)
     */
    private static int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;

        // 存储源点到其他点的最短距离
        int[][] dist = new int[m][n];
        for (int[] ints : dist) {
            Arrays.fill(ints, -1);
        }
        dist[0][0] = 0;
        boolean[][] done = new boolean[m][n];
        while (true) {
            int u = -1, v = -1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!done[i][j] &&
                            (u == -1 || (dist[i][j] != -1 && dist[i][j] < dist[u][v]))) {
                        u = i;
                        v = j;
                    }
                }
            }
            if (u == -1) {
                break;
            }
            done[u][v] = true;
            int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int x = u + dx[i], y = v + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n) {
                    if (dist[x][y] == -1) {
                        dist[x][y] = Math.max(dist[u][v], moveTime[x][y]) + 1;
                    } else {
                        dist[x][y] = Math.min(dist[x][y], (Math.max(dist[u][v], moveTime[x][y]) + 1));
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
