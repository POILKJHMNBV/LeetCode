package com.example.graph;

import java.util.*;

/**<p>L133:克隆图</p>
 * @author zhenwu
 * @date 2024/10/14 21:25
 */
public class L133_CloneGraph {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        Node cloneNode = cloneGraph(node1);
        System.out.println(cloneNode);
    }

    /**
     * 广度优先遍历
     * 时间：O(n) n为节点数
     * 空间：O(n) n为节点数
     */
    private static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node beginNode = new Node(node.val);

        // 创建一个哈希表，用于存储原始节点和克隆节点的映射关系
        Map<Integer, Node> cloneMap = new HashMap<>();
        cloneMap.put(node.val, beginNode);


        // 遍历原始图的每个节点，将其克隆并添加到克隆图中
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.poll();
                Node cloneNode = cloneMap.get(curNode.val);
                for (Node neighbor : curNode.neighbors) {
                    if (!cloneMap.containsKey(neighbor.val)) {
                        Node cloneNeighbor = new Node(neighbor.val);

                        // 将邻居节点添加到克隆节点的邻居列表中
                        cloneNode.neighbors.add(cloneNeighbor);
                        cloneNeighbor.neighbors.add(cloneNode);

                        cloneMap.put(neighbor.val, cloneNeighbor);
                        queue.offer(neighbor);
                    } else {
                        if (!cloneNode.neighbors.contains(cloneMap.get(neighbor.val))) {
                            // 将邻居节点添加到克隆节点的邻居列表中
                            cloneNode.neighbors.add(cloneMap.get(neighbor.val));
                        }
                    }
                }
            }
        }
        return beginNode;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }
}
