package com.example.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L111:二叉树的最小深度</p>
 * @author zhenwu
 * @date 2024/8/22 21:31
 */
public class L111_MinDepth {
    public static void main(String[] args) {

    }

    private static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        int minDepth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            minDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return minDepth;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return minDepth;
    }
}
