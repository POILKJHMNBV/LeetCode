package com.example.hw;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>亲子游戏</p>
 * <p>
 *     宝宝和妈妈参加亲子游戏，在一个二维矩阵(N*N)的格子地图上，宝宝和妈妈抽签决定各自的位置，地图上每个格子有不同的糖果数量，部分格子有障碍物。
 *     游戏规则是妈妈必须在最短的时间(每个单位时间只能走一步)到达宝宝的位置，路上的所有糖果都可以拿走，不能走障碍物的格子，只能上下左右走。
 *     请问妈妈在最短到达宝宝位置的时间内最多拿到多少糖果(优先考虑最短时间到达的情况下尽可能多拿糖果)。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为 N，N 表示二维矩阵的大小。 之后 N 行，每行有 N 个值，表格矩阵每个位置的值，其中:
 *          -3: 妈妈；     -2: 宝宝；     -1: 障碍 :    >=0 糖果数(0 表示没有糖果，但是可以走)
 * </p>
 * <p>
 *     输出描述：输出妈妈在最短到达宝宝位置的时间内最多拿到多少糖果，行未无多余空格。
 * </p>
 * @author zhenwu
 * @date 2024/7/27 22:21
 */
public class H114_ParentGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] grid = new int[n][n];

        // 利用队列进行BFS
        // num[0] = x, num[1] = y, num[2] = candyCount
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
                if (grid[i][j] == -3) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][n];
        boolean arrived = false;
        int maxCandyCount = 0;
        while (!queue.isEmpty() && !arrived) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0], y = point[1], candyCount = point[2];
                visited[x][y] = true;

                if (grid[x][y] == -2) {
                    maxCandyCount = Math.max(maxCandyCount, candyCount);
                    arrived = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int newX = x + dx[k];
                    int newY = y + dy[k];
                    if (!inArea(grid, newX, newY) || grid[newX][newY] == -1 || visited[newX][newY]) {
                        continue;
                    }
                    queue.offer(new int[]{newX, newY, candyCount + (Math.max(grid[newX][newY], 0))});
                }
            }
        }
        if (arrived) {
            System.out.println(maxCandyCount);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
