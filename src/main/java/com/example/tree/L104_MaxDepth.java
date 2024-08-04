package com.example.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L104:二叉树的最大深度</p>
 * <p>给定一个二叉树 root ，返回其最大深度</p>
 */
public class L104_MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(-1);
        TreeNode treeNode6 = new TreeNode(5);
        TreeNode treeNode7 = new TreeNode(1);
        TreeNode treeNode8 = new TreeNode(6);
        TreeNode treeNode9 = new TreeNode(8);

        root.left = treeNode1;
        root.right = treeNode2;

        treeNode1.left = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode4.right = treeNode8;
        treeNode5.right = treeNode9;

        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}