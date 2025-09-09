package com.example.graph;

import java.util.*;

/**
 * <p>L818:赛车</p>
 * @author zhenwu
 * @date 2025/9/9 21:52
 */
public class L818_Racecar {
    public static void main(String[] args) {

    }

    /**
     * dijkstra
     * 时间复杂度: O(T * log T), 其中 T 表示 barrier 的数量级
     * 空间复杂度: O(T)
     */
    private static int racecar(int target) {
        int K = 33 - Integer.numberOfLeadingZeros(target - 1);
        int barrier = 1 << K;
        int[] dist = new int[2 * barrier + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[target] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.steps - b.steps);
        pq.offer(new Node(0, target));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int steps = node.steps, targ1 = node.target;
            if (dist[Math.floorMod(targ1, dist.length)] > steps) continue;

            for (int k = 0; k <= K; ++k) {
                int walk = (1 << k) - 1;
                int targ2 = walk - targ1;
                int steps2 = steps + k + (targ2 != 0 ? 1 : 0);

                int i = Math.floorMod(targ2, dist.length);
                if (Math.abs(targ2) <= barrier && steps2 < dist[i]) {
                    pq.offer(new Node(steps2, targ2));
                    dist[i] = steps2;
                }
            }
        }

        return dist[0];
    }

    private record Node(int steps, int target) {
    }
}
