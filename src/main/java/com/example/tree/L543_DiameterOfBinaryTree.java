package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * L543:二叉树的直径
 * <p>
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * </p>
 */
public class L543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node = new TreeNode(1);
        root.right = node;
        node.left = new TreeNode(2);
        System.out.println(diameterOfBinaryTree(root));
    }

    private static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameter = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            diameter = Math.max(height(treeNode.left) + height(treeNode.right), diameter);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
        return diameter;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
