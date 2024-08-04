package com.example.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * L589:N 叉树的前序遍历
 */
public class L589_NPreorder {
    public static void main(String[] args) {

    }
    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<Node> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            if (node.children != null && !node.children.isEmpty()) {
                int size = node.children.size();
                for (int i = size - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return ans;
    }
}
