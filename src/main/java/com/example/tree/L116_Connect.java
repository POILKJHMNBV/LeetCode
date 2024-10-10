package com.example.tree;

import java.util.ArrayDeque;

/**
 * <p>L116:填充每个节点的下一个右侧节点指针</p>
 * @author zhenwu
 * @date 2024/10/10 20:37
 */
public class L116_Connect {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(n)
     */
    private static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (pre != null) {
                    node.next = pre;
                }
                pre = node;
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return root;
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
