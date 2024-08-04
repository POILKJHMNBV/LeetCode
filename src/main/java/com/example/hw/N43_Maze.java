package com.example.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N43_Maze {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }

        // 定义四个方向的偏移量
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Point endPoint = null; // 终点
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0, 1, null));
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            if (curPoint.x == rows - 1 && curPoint.y == cols - 1){
                endPoint = curPoint;
                break;
            }

            // 开始考察当前位置的四个方向
            for (int i = 0; i < 4; i++) {
                int newX = curPoint.x + dx[i];
                int newY = curPoint.y + dy[i];
                if (inArea(newX, newY, grid) && grid[newX][newY] == 0) {
                    grid[newX][newY] = -1;
                    queue.offer(new Point(newX, newY, curPoint.steps + 1, curPoint));
                }
            }
        }
        Deque<Point> stack = new ArrayDeque<>();
        while (endPoint != null) {
            stack.push(endPoint);
            endPoint = endPoint.parent;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean inArea(int i, int j, int[][] grid) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    static class Point {
        int x;
        int y;
        int steps;
        Point parent; // 父节点

        Point(int x, int y, int steps, Point parent) {
            this.x = x;
            this.y = y;
            this.steps = steps;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
