package com.example.dp;

import com.example.tree.TreeNode;

/**
 * <p>L687:最长同值路径</p>
 * <p>给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * 两个节点之间的路径长度 由它们之间的边数表示。</p>
 */
public class L687_LongestUnivaluePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;

        TreeNode leaf1 = new TreeNode(1);
        TreeNode leaf2 = new TreeNode(1);
        TreeNode leaf3 = new TreeNode(5);
        left.left = leaf1;
        left.right = leaf2;
        right.right = leaf3;
        System.out.println(longestUnivaluePath(root));
    }

    private static int res;

    private static int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left), right = dfs(root.right);
        int left1 = 0, right1 = 0;
        if (root.left != null && root.left.val == root.val) {
            left1 = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            right1 = right + 1;
        }
        res = Math.max(res, left1 + right1);
        return Math.max(left1, right1);
    }
}
