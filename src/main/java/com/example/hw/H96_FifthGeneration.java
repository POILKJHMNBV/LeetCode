package com.example.hw;

import com.example.graph.UnionFind;

import java.util.*;

/**
 * <p>5G网络建设</p>
 * <p>
 *     现需要在某城市进行5G网络建设，已经选取N个地点设置5G基站，编号固定为1到N，
 *     接下来需要各个基站之间使用光纤进行连接以确保基站能互联互通，不同基站之间架设光纤的成本各不相同，且有些节点之间已经存在光纤相连
 *     请你设计算法，计算出能联通这些基站的最小成本是多少。
 *     注意，基站的联通具有传递性，入基站A与基站B架设了光纤基站B与基站C也架设了光纤，则基站A与基站C视为可以互相联通
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入表示基站的个数N，其中0 < N <= 20
 *          第二行输入表示具备光纤直连条件的基站对的数目M,其中0 < M < N * (N - 1) / 2
 *          从第三行开始连域输入M行数据，将式为：X Y Z P，
 *              1.其中X Y表示基能的编号，0 < X <= N， 0 < Y <= N 且x不等于y，
 *              2.Z表示在X Y之间架设光纤的成本，其中0 < Z < 100，
 *              3.P表示是否已存在光纤连接，0表示未连接1 表示已连接.
 * </p>
 * <p>
 *     输出描述：
 *          如果给定条件，可以建设成功互联与通的5G网络，则输出最小的建设成本， 如果给定条件，无法建设成功互联与通的5G网络，则输出-1
 * </p>
 * @author zhenwu
 * @date 2024/7/23 21:09
 */
public class H96_FifthGeneration {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        // 访问过的点集
        Set<Node> visitedNode = new HashSet<>();

        // 结点map
        Map<Integer, Node> nodeMap = new HashMap<>();

        // 并查集
        UnionFind unionFind = new UnionFind(n);

        // 小根堆存储边集
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        for (int i = 0; i < m; i++) {
            int no1 = in.nextInt(), no2 = in.nextInt();
            Node node1 = nodeMap.getOrDefault(no1, new Node(no1));
            Node node2 = nodeMap.getOrDefault(no2, new Node(no2));
            nodeMap.put(no1, node1);
            nodeMap.put(no2, node2);
            int cost = in.nextInt();
            boolean connected = in.nextInt() == 1;
            Edge edge = new Edge(cost, node1, node2, connected);
            node1.edges.add(edge);
            node2.edges.add(edge);
            if (connected) {
                // 结点已经连接，加入并查集，加入访问过的点集
                unionFind.union(no1, no2);
                visitedNode.add(node1);
                visitedNode.add(node2);
            } else {
                // 结点未连接，加入小根堆
                minHeap.offer(edge);
            }
        }

        if (m < n - 1) {
            // n个结点之间要连通，至少需要n-1条线
            System.out.println(-1);
            return;
        }

        if (visitedNode.size() == n) {
            // 所有结点之间已经连通
            System.out.println(0);
            return;
        }

        Node beginNode = null;
        int cost = 100;

        // 从连通图中寻找权值最小的边的起始结点作为Prim算法的起始结点
        for (Node node : visitedNode) {
            for (Edge edge : node.edges) {
                Node fromNode = edge.from;
                Node toNode = edge.to;
                if (!visitedNode.contains(fromNode) || !visitedNode.contains(toNode)) {
                    if (edge.cost < cost) {
                        cost = edge.cost;
                        beginNode = node;
                    }
                }
            }
        }

        // 没有结点连通，任意选取一个结点作为起始结点
        if (beginNode == null) {
            beginNode = nodeMap.values().iterator().next();
            visitedNode.add(beginNode);
        }
        System.out.println("prim ==> ");
        minimumSpanningTreeBasedPrim(n, beginNode, visitedNode);
        System.out.println("Kruskal ==> ");
        minimumSpanningTreeBasedKruskal(unionFind, minHeap);
    }

    /**
     * 利用Kruskal算法生成最小生成树，求取最小的建设成本
     * @param unionFind 并查集
     * @param minHeap 小根堆存储边集
     */
    private static void minimumSpanningTreeBasedKruskal(UnionFind unionFind, PriorityQueue<Edge> minHeap) {
        int minCost = 0;
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int no1 = edge.from.no;
            int no2 = edge.to.no;
            if (!unionFind.inSameTeam(no1, no2)) {
                unionFind.union(no1, no2);
                minCost += edge.cost;
            }
        }
        if (unionFind.getCount() == 1) {
            // 整个图完全连通
            System.out.println(minCost);
        } else {
            System.out.println(-1);
        }
    }

    /**
     * 利用Prim算法生成最小生成树，求取最小的建设成本
     * @param n 基站个数
     * @param beginNode 起始基站
     * @param visitedNode 访问过的点集
     */
    private static void minimumSpanningTreeBasedPrim(int n,
                                                     Node beginNode,
                                                     Set<Node> visitedNode) {

        // 利用小根堆每次从所有边中选取权值最小的边加入最小生成树
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));

        for (Edge edge : beginNode.edges) {
            minHeap.offer(edge);
        }

        int minCost = 0;
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            Node fromNode = edge.from;
            Node toNode = edge.to;
            if ((visitNode(visitedNode, fromNode, minHeap) || visitNode(visitedNode, toNode, minHeap))) {
                minCost += edge.cost;;
                if (visitedNode.size() == n) {
                    // 所有结点均已经被访问
                    System.out.println(minCost);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    private static boolean visitNode(Set<Node> visitedNode,
                                 Node node,
                                 PriorityQueue<Edge> minHeap) {
        if (!visitedNode.contains(node)) {
            visitedNode.add(node);
            for (Edge e : node.edges) {
                minHeap.offer(e);
            }
            return true;
        }
        return false;
    }

    private static class Node {
        final int no;
        final List<Edge> edges;

        public Node(int no) {
            this.no = no;
            edges = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return this.no == node.no;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.no);
        }
    }

    private static class Edge {
        final int cost;
        final Node from;
        final Node to;
        final boolean connected;

        public Edge(int cost, Node from, Node to, boolean connected) {
            this.cost = cost;
            this.from = from;
            this.to = to;
            this.connected = connected;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return this.cost == edge.cost && this.connected == edge.connected
                    && Objects.equals(this.from, edge.from) && Objects.equals(this.to, edge.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.cost, this.from, this.to, this.connected);
        }
    }
}
