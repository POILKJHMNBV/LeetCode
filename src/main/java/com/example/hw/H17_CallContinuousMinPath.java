package com.example.hw;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>通话不中断的最短路径 </p>
 * <p>
 * 给定一个MxN的网格，其中每个单元格都填有数字，数字大小表示覆盖信号强度。灰色网格代表空地，橙色网格代表信号覆盖区域，绿色网格代表基站，绿色网格内数字大小表示该基站发射信号的初始强度。
 * 基站信号每向外（上下左右）传播一格，信号强度减1，最小减为0，表示无信号，如下图示。当某个位置可以同时接收到多个基站的信号时，取其中接收信号强度的最大值作为该位置的信号强度。
 * 对于给定网格，请判断是否存在一条路径，使得从左上角移动到右下角过程中信号不中断，只能上下左右移动。假设接收到的信号强度低于门限Th ，信号就会中断。
 * 注意:出发点固定在网格的左上角，终点是网格的右下角。
 * </p>
 * <p>
 *     输入描述:
 *          第一行输入信号强度Th。 (1<= Th <= 100)
 *          第二行输入矩阵M、N。 (1<= M <= 100，1<= N <= 100)
 *          第三行输入基站个数K。 (1<= K <= 100)
 *          后续K行输入基站位置及初始信号强度。(前两个值表示基站所在行、列索引，第3个值表示基站初始信号强度)
 * </p>
 * <p>
 *     输出描述：返回信号不中断的最短路径，不存在返回0
 * </p>
 * @author zhenwu
 * @date 2024/7/6 21:37
 */
public class H17_CallContinuousMinPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int threshold = in.nextInt();
        int rows = in.nextInt();int cols = in.nextInt();
        int n = in.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < n; i++) {
            int row = in.nextInt();int col = in.nextInt();int val = in.nextInt();
            grid[row][col] = val;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    bfs(grid, i, j);
                }
            }
        }
        if (grid[rows - 1][cols - 1] < threshold) {
            System.out.println(0);
            return;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int minPath = -1;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!queue.isEmpty()) {
            int size = queue.size();
            minPath++;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                if (point[0] == rows -1 && point[1] == cols - 1) {
                    System.out.println(minPath);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int newX = point[0] + dx[j];
                    int newY = point[1] + dy[j];
                    if (inArea(grid, newX, newY) && !visited[newX][newY] && grid[newX][newY] >= threshold) {
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static void bfs(int[][] grid, int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int signalStrength = grid[x][y];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty() && signalStrength != 0) {
            int size = queue.size();
            signalStrength--;
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int newX = point[0] + dx[j];
                    int newY = point[1] + dy[j];
                    if (inArea(grid, newX, newY) && !visited[newX][newY]) {
                        grid[newX][newY] = Math.max(grid[newX][newY], signalStrength);
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }
    }

    private static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
