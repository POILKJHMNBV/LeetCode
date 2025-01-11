package com.example.recursion;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>L542:01 矩阵</p>
 * @author zhenwu
 * @date 2025/1/11 9:18
 */
public class L542_UpdateMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0, 0}, {0, 1, 0, 0}, {1, 1, 1, 0}, {1, 0, 0, 0}};
        int[][] ints = updateMatrixPro(mat);
        for (int[] ints1 : ints) {
            System.out.println(java.util.Arrays.toString(ints1));
        }
    }

    public static int[][] updateMatrixPro(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] res = new int[mat.length][mat[0].length];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (isValid(mat, nextX, nextY) && !visited[nextX][nextY]) {
                    res[nextX][nextY] = res[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return res;
    }

    private static int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j] = bfs(mat, i, j);
            }
        }
        return res;
    }

    private static int bfs(int[][] mat, int x, int y) {
        if (mat[x][y] == 0) {
            return 0;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        visited[x][y] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            for (int size = queue.size(); size > 0; size--) {
                int[] cur = queue.poll();
                int curX = cur[0], curY = cur[1];
                if (mat[curX][curY] == 0) {
                    return step - 1;
                }
                for (int[] dir : dirs) {
                    int nextX = curX + dir[0];
                    int nextY = curY + dir[1];
                    if (isValid(mat, nextX, nextY) && !visited[nextX][nextY]) {
                        queue.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        return step - 1;
    }

    private static boolean isValid(int[][] mat, int x, int y) {
        return x >= 0 && x < mat.length && y >= 0 && y < mat[0].length;
    }
}
