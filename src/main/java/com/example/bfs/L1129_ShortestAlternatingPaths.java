package com.example.bfs;

import java.util.*;

/**
 * <p>L1129:颜色交替的最短路径</p>
 * @author zhenwu
 * @date 2025/8/11 22:04
 */
public class L1129_ShortestAlternatingPaths {
    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = {{0, 1}, {1, 2}};
        int[][] blueEdges = {{1, 0}};
        System.out.println(Arrays.toString(shortestAlternatingPaths(n, redEdges, blueEdges)));
    }

    /**
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        final int RED = 0, BLUE = 1;
        List<Integer>[][] adjacentArr = new List[n][2];
        for (int i = 0; i < n; i++) {
            adjacentArr[i][RED] = new ArrayList<>();
            adjacentArr[i][BLUE] = new ArrayList<>();
        }
        for (int[] redEdge : redEdges) {
            adjacentArr[redEdge[0]][RED].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            adjacentArr[blueEdge[0]][BLUE].add(blueEdge[1]);
        }
        int[][] distances = new int[n][2];
        for (int i = 1; i < n; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, RED});
        queue.offer(new int[]{0, BLUE});
        while (!queue.isEmpty()) {
            int[] nodeColor = queue.poll();
            int node = nodeColor[0], color = nodeColor[1];
            int distance = distances[node][color];
            int nextColor = color ^ 1;
            int nextDistance = distance + 1;
            List<Integer> adjacent = adjacentArr[node][nextColor];
            for (int next : adjacent) {
                if (nextDistance < distances[next][nextColor]) {
                    distances[next][nextColor] = nextDistance;
                    queue.offer(new int[]{next, nextColor});
                }
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int distance = Math.min(distances[i][RED], distances[i][BLUE]);
            answer[i] = distance != Integer.MAX_VALUE ? distance : -1;
        }
        return answer;
    }
}
