package com.example.graph;

import java.util.*;

/**
 * <p>图的基本数据结构</p>
 */
public class Graph<N, E> {
    /**
     * key代表结点的编号，value代表结点
     */
    public HashMap<N, Node<E>> nodes;

    public HashSet<Edge<E>> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    /**
     * 图的宽度优先遍历
     * @param node 宽度优先遍历起始结点
     * @return 宽度优先遍历结果
     */
    public List<Node<E>> bfs(Node<E> node) {
        List<Node<E>> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Queue<Node<E>> queue = new LinkedList<>();

        // 存储访问过的结点
        Set<Node<E>> visitedSet = new HashSet<>();
        queue.offer(node);
        visitedSet.add(node);
        while (!queue.isEmpty()) {
            Node<E> curNode = queue.poll();
            res.add(curNode);
            for (Node<E> next : curNode.adjacentList) {
                // 遍历当前结点未访问过的邻接结点
                if (!visitedSet.contains(next)) {
                    visitedSet.add(next);
                    queue.add(next);
                }
            }
        }
        return res;
    }

    /**
     * 图的深度优先遍历
     * @param node 深度优先遍历起始结点
     * @return 深度优先遍历结果
     */
    public List<Node<E>> dfs(Node<E> node) {
        List<Node<E>> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<Node<E>> stack = new Stack<>();

        // 存储访问过的结点
        Set<Node<E>> visitedSet = new HashSet<>();
        stack.push(node);
        visitedSet.add(node);
        res.add(node);
        while (!stack.isEmpty()) {
            Node<E> curNode = stack.pop();
            for (Node<E> next : curNode.adjacentList) {

                // 找到一个未访问过的结点就结束循环
                if (!visitedSet.contains(next)) {
                    stack.push(curNode);
                    stack.push(next);
                    visitedSet.add(next);
                    res.add(next);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 图的拓扑排序，仅适用于有向无环图，且图中只有一个入度为0的结点
     * @return 图的拓扑排序结果
     */
    public List<Node<E>> topologySort() {
        List<Node<E>> res = new ArrayList<>();
        if (this.nodes == null || this.nodes.isEmpty()) {
            return res;
        }

        // 剩余结点入度map
        Map<Node<E>, Integer> residualInDegreeMap = new HashMap<>();

        // 入度为0的结点队列
        Queue<Node<E>> zeroInDegreeQueue = new LinkedList<>();
        for (Node<E> node : this.nodes.values()) {
            residualInDegreeMap.put(node, node.in);
            if (node.in == 0) {
                zeroInDegreeQueue.offer(node);
            }
        }

        // 开始拓扑排序
        while (!zeroInDegreeQueue.isEmpty()) {
            Node<E> curNode = zeroInDegreeQueue.poll();
            res.add(curNode);
            for (Node<E> next : curNode.adjacentList) {
                residualInDegreeMap.put(next, residualInDegreeMap.get(next) - 1);

                // 入度为0的结点进入队列
                if (residualInDegreeMap.get(next) == 0) {
                    zeroInDegreeQueue.offer(next);
                }
            }
        }
        return res;
    }

    /**
     * 普利姆算法，在加权连通图中寻找最小生成树
     * @return 最小生成树
     */
    public List<Edge<E>> prim() {
        List<Edge<E>> res = new ArrayList<>();
        if (this.nodes == null || this.nodes.isEmpty()) {
            return res;
        }
        if (this.edges == null || this.edges.isEmpty()) {
            return res;
        }

        // 存储访问过的结点
        Set<Node<E>> visitedSet = new HashSet<>();

        // 初始结点
        Node<E> node = this.nodes.values().iterator().next();
        visitedSet.add(node);

        // 利用小根堆维护每次的最小权值边
        PriorityQueue<Edge<E>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        for (Edge<E> edge : node.edges) {
            priorityQueue.offer(edge);
        }

        while (!priorityQueue.isEmpty()) {
            // 取最小边
            Edge<E> edge = priorityQueue.poll();
            Node<E> toNode = edge.to;

            // 结点未访问过
            if (!visitedSet.contains(toNode)) {
                visitedSet.add(toNode);
                res.add(edge);
                for (Edge<E> nextEdge : toNode.edges) {
                    priorityQueue.offer(nextEdge);
                }
            }
        }
        return res;
    }

    /**
     * Dijkstra算法求解单源最短路径：图必须为加权图，且图的权值不能未负值
     * @param node 出发点
     * @return 出发点到每个结点的最短路径
     */
    public Map<Node<E>, Integer> dijkstra(Node<E> node) {
        
        /*
            key：从node出发到达的结点
            value：从node出发到结点的最小距离
            如果在Map中没有结点的距离记录，则从当前结点到该结点的距离为正无穷
        */
        Map<Node<E>, Integer> distanceMap = new HashMap<>();
        if (this.nodes == null || this.nodes.isEmpty()) {
            return distanceMap;
        }
        if (this.edges == null || this.edges.isEmpty()) {
            return distanceMap;
        }

        distanceMap.put(node, 0);

        // 已经求解过距离的结点
        Set<Node<E>> selectedNodes = new HashSet<>();
        Node<E> minDistanceNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
        while (minDistanceNode != null) {
            int distance = distanceMap.get(minDistanceNode);
            for (Edge<E> edge : minDistanceNode.edges) {
                Node<E> toNode = edge.to;
                if (!distanceMap.containsKey(toNode)) {
                    // 更新出发点到此结点的最短距离
                    distanceMap.put(toNode, distance + edge.weight);
                }
                distanceMap.put(edge.to, Math.min(distanceMap.get(toNode), distance + edge.weight));
                minDistanceNode = getMinDistanceAndUnselectedNode(distanceMap, selectedNodes);
            }
        }
        return distanceMap;
    }

    /**
     * 选取未被访问过距离最小的结点
     */
    private Node<E> getMinDistanceAndUnselectedNode(Map<Node<E>, Integer> distanceMap, Set<Node<E>> selectedNodes) {
        int minDistance = Integer.MAX_VALUE;
        Node<E> minDistanceNode = null;
        for (Map.Entry<Node<E>, Integer> entry : distanceMap.entrySet()) {
            Node<E> node = entry.getKey();
            Integer distance = entry.getValue();
            if (!selectedNodes.contains(node) && distance < minDistance) {
                minDistanceNode = node;
                minDistance = distance;
            }
        }
        return minDistanceNode;
    }
}