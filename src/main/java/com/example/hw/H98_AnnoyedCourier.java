package com.example.hw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>快递员的烦恼</p>
 * <p>
 *     快递公司每日早晨，给每位快递员推送需要淡到客户手中的快递以及路线信息，快递员自己又查找了一些客户与客户之间的路线距离信息，请你依据这些信息，给快递员设计一条最短路径，告诉他最短路径的距离。
 *      1.不限制快递包裹送到客户手中的顺序，但必须保证都送到客户手中；
 *      2.用例保证一定存在投递站到每位客户之间的路线，但不保证客户与客户之间有路线，客户位置及投递站均允许多次经过；
 *      3.用例保证一定存在投递站到每位客户之间的路线，但不保证客户与客户之间有路线，客户位置及投递站均允许多次经过；
 * </p>
 * <p>
 *     输入描述：
 *          首行输入两个正整数n、m.
 *          接下来n行，输入快递公司发布的客户快递信息，格式为：客户id 投递站到客户之间的距离distance
 *          再接下来的m行，是快递员自行查找的客户与客户之间的距离信息，格式为：客户1id 客户2id distance
 *          在每行数据中，数据与数据之间均以单个空格分割规格:
 *          0 <=n <= 10 0 <= m <= 10 0 < 客户id <= 1000 0 < distance <= 10000
 * </p>
 * <p>
 *     输出描述：最短路径距离，如无法找到，请输出-1
 * </p>
 * @author zhenwu
 * @date 2024/7/24 22:07
 */
public class H98_AnnoyedCourier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); int m = in.nextInt();

        // 使用邻接矩阵表达连通关系
        int[][] dist = new int[n + 1][n + 1];
        int infiniteDistance = 200000;
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], infiniteDistance);
            dist[i][i] = 0;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int customerId = in.nextInt();
            int distance = in.nextInt();

            // 基站位置为0
            dist[0][i] = dist[i][0] = distance;
            indexMap.put(customerId, i);
        }

        for (int i = 0; i < m; i++) {
            int index1 = indexMap.get(in.nextInt());
            int index2 = indexMap.get(in.nextInt());
            int distance = in.nextInt();
            dist[index1][index2] = dist[index2][index1] = distance;
        }

        // 利用Floyd算法计算任意两点之间的最短距离
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 利用动态规划求解最短距离
        // dp[i][j]表示已经访问的结点集合为i(利用i的每一个二进制位表示结点是否已经被访问)，到达结点j的最短路径
        int[][] dp = new int[1 << n + 1][n + 1];
        for (int i = 0; i < (1 << n + 1); i++) {
            Arrays.fill(dp[i], infiniteDistance);
        }

        // 初始位置为基站
        dp[1][0] = 0;

        for (int visited = 1; visited < (1 << n + 1); visited++) {
            // 已经访问的结点集合visited
            for (int i = 0; i <= n; i++) {
                if (((visited >> i) & 1) == 1 && dp[visited][i] != infiniteDistance) {
                    // 结点i已经被访问，即已经在访问结点集合中
                    for (int j = 0; j <= n; j++) {
                        // 是否可以通过结点i访问j尝试找到到达j的更短距离
                        dp[visited | (1 << j)][j] = Math.min(dp[visited | (1 << j)][j], dp[visited][i] + dist[i][j]);
                    }
                }
            }
        }
        if (dp[(1 << n + 1) - 1][0] != infiniteDistance) {
            System.out.println(dp[(1 << n + 1) - 1][0]);
        } else {
            System.out.println(-1);
        }
    }
}
