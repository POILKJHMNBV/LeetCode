package com.example.hw;

import java.util.*;

/**
 * <p>电脑病毒感染</p>
 * <p>
 *     一个局域网只内有很多台电脑，分别标注为 1 ~ N 的数字。相连接的电脑距离不一样，所以感染时间不一样，感染时间用t 表示。
 *     其中网络内一台电脑被病毒感染，求其感染网络内所有的电脑最少需要多长时间。如果最后有电脑不会感染，则返回-1。
 *     给定一个数组 times 表示一台电脑把相邻电脑感染所用的时间: path[i] = {i, j, t} 表示: 电脑i 上的病毒感染 j，需要时间 t 。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入一个整数N，表示局域网内电脑个数 N，1<= N<= 200
 *          第二行输入一个整数M, 表示有 M 条网络连接
 *          接下来M行, 每行输入为 i,j,t 。表示电脑 i 感染电脑 j 需要时间t
 *          最后一行为病毒所在的电脑编号
 * </p>
 * <p>
 *     输出描述：
 *          输出最少需要多少时间才能感染全部电脑，如果不存在输出 -1
 * </p>
 * @author zhenwu
 * @date 2024/7/8 20:41
 */
public class H25_ComputerVirusInfection {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int computerNum = in.nextInt();
        int internetConnectNum = in.nextInt();

        // key-电脑编号 value-[电脑编号, 时间]
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < internetConnectNum; i++) {
            int a = in.nextInt();int b = in.nextInt();int c = in.nextInt();
            map.computeIfAbsent(a, k -> new ArrayList<>()).add(new int[]{b, c});
        }

        // 病毒机编号
        int beginNum = in.nextInt();

        // 利用小根堆存储病毒机感染目标主机所需的最少时间
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        boolean[] visited = new boolean[computerNum + 1];

        minHeap.offer(new int[]{beginNum, 0});
        int infectedComputerCount = 0;
        // 利用Dijkstra算法求解最少需要的时间
        while (!minHeap.isEmpty()) {
            int[] beginPoint = minHeap.poll();
            int num = beginPoint[0];
            int time = beginPoint[1];

            // 已经求出最短时间的点标记为已经访问, 感染电脑数目+1
            visited[num - 1] = true;
            infectedComputerCount++;

            if (infectedComputerCount == computerNum) {
                // 所有电脑均已经被感染
                System.out.println(time);
                return;
            }

            // 从当前结点出发, 考察当前结点的所有邻接结点
            for (int[] adjacency : map.getOrDefault(num, Collections.emptyList())) {
                int adjacencyNum = adjacency[0];
                int costTime = adjacency[1];
                if (!visited[adjacencyNum - 1]) {
                    minHeap.add(new int[]{adjacencyNum, time + costTime});
                }
            }
        }

        // 仍有电脑未被感染
        System.out.println(-1);
    }
}
