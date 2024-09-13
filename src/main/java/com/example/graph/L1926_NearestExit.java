package com.example.graph;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L1926:迷宫中离入口最近的出口</p>
 * @author zhenwu
 * @date 2024/9/13 21:09
 */
public class L1926_NearestExit {
    public static void main(String[] args) {
        char[][] maze = {
                {'+','.','+','+','+','+','+'},
                {'+','.','+','.','.','.','+'},
                {'+','.','+','.','+','.','+'},
                {'+','.','.','.','+','.','+'},
                {'+','+','+','+','+','.','+'}
        };
        int[] entrance = {3, 2};
        System.out.println(nearestExit(maze, entrance));
    }

    /**
     * 时间：O(m * n)
     */
    private static int nearestExit(char[][] maze, int[] entrance) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        int step = 0;
        maze[entrance[0]][entrance[1]] = '+';
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = point[0] + dx[j];
                    int newY = point[1] + dy[j];
                    if (inArea(maze, newX, newY) && maze[newX][newY] == '.') {
                        if (arriveExit(maze, newX, newY)) {
                            return step;
                        }
                        queue.offer(new int[]{newX, newY});
                        maze[newX][newY] = '+';
                    }
                }
            }
        }
        return -1;
    }

    private static boolean arriveExit(char[][] maze, int row, int col) {
        return row - 1 == -1 || row + 1 == maze.length || col - 1 == -1 || col + 1 == maze[0].length;
    }

    private static boolean inArea(char[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length;
    }
}
