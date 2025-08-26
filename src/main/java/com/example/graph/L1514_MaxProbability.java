package com.example.graph;

import java.util.*;

/**
 * <p>L1514:概率最大的路径</p>
 * @author zhenwu
 * @date 2025/8/26 22:03
 */
public class L1514_MaxProbability {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0, end_node = 2;
        System.out.println(maxProbability(n, edges, succProb, start_node, end_node));
    }

    /**
     * Dijkstra算法
     * 时间复杂度：O(n + m * log m), 其中 n 为节点数，m 为边数
     * 空间复杂度：O(n + m)
     */
    private static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0], y = edges[i][1];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new Node(y, succProb[i]));
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new Node(x, succProb[i]));
        }

        double[] dist = new double[n];
        // 创建一个优先级队列，用于存储当前节点的概率
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            // 概率大的优先级高
            if (o1.prob == o2.prob) {
                return 0;
            }
            return o2.prob - o1.prob > 0 ? 1 : -1;
        });
        queue.offer(new Node(start_node, 1.0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (dist[node.id] > node.prob) {
                // 节点重复入队，跳过
                continue;
            }
            for (Node next : graph.getOrDefault(node.id, new ArrayList<>())) {
                if (dist[next.id] < node.prob * next.prob) {
                    // 满足概率要求且概率更大
                    dist[next.id] = node.prob * next.prob;
                    queue.offer(new Node(next.id, dist[next.id]));
                }
            }
        }
        return dist[end_node];
    }

    private record Node(int id, double prob) {
    }
}
