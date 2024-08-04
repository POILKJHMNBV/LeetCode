package com.example.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>智能驾驶</p>
 * <p>
 *     有一辆汽车需要从 m * n 的地图的左上角（起点）开往地图的右下角（终点），去往每一个地区都需要消耗一定的油量，加油站可进行加油
 *     请你计算汽车确保从起点到达终点时所需的最少初始油量
 *     说明：
 *      （1）智能汽车可以上下左右四个方向移动;
 *      （2）地图上的数字取值是 0 或 −1 或者正整数;
 *      （3）−1：表示加油站，可以加满油，汽车的油箱容量最大为 100；0 ：表示这个地区是障碍物，汽车不能通过;正整数：表示汽车走过这个地区的耗油量
 *      （4）如果汽车无论如何都无法到达终点，则返回 −1
 * </p>
 * <p>
 *     输入描述：
 *          第一行为两个数字，M , N，表示地图的大小为 M * N ( 0 < M,N ≤ 200 )
 *          后面一个M * N 的矩阵，其中的值是 0 或 −1 或正整数，加油站的总数不超过 200个
 * </p>
 * <p>
 *     输出描述：
 *          如果汽车无论如何都无法到达终点，则返回-1
 *          如果汽车可以到达终点，则返回最少的初始油量
 * </p>
 * @author zhenwu
 * @date 2024/7/21 10:46
 */
public class H78_IntelligentDrive {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] metaDataArray = in.nextLine().split(",");
        int m = Integer.parseInt(metaDataArray[0]), n = Integer.parseInt(metaDataArray[1]);
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] numStr = in.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(numStr[j]);
            }
        }

        // dp[i][j]表示终点到达(i, j)位置的最小油耗
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m - 1][n - 1] = grid[m - 1][n - 1];

        // 利用小根堆每次选取油耗最少的点作为起始点进行BFS
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 从终点出发，进行反推
        minHeap.offer(new int[]{dp[m - 1][n - 1], m - 1, n - 1});

        while (!minHeap.isEmpty()) {
            int[] curNode = minHeap.poll();
            int cost = curNode[0], x = curNode[1], y = curNode[2];
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (!inArea(grid, newX, newY) || grid[newX][newY] == 0) {
                    continue;
                }

                int nextCost = grid[newX][newY] == -1 ? 0 : cost + grid[newX][newY];

                if (nextCost <= 100 && nextCost < dp[newX][newY]) {
                    // 找到一条到达(newX, newY)
                    dp[newX][newY] = nextCost;
                    minHeap.offer(new int[]{nextCost, newX, newY});
                }
            }
        }

        if (dp[0][0] > 100) {
            System.out.println(-1);
        } else {
            System.out.println(dp[0][0]);
        }
    }

    private static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
