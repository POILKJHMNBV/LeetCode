package com.example.dp;

import com.example.tree.TreeNode;

/**
 * <p>L1372:二叉树中的最长交错路径</p>
 * <p>
 * 给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：
 *      选择二叉树中 任意 节点和一个方向（左或者右）。
 *      如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
 *      改变前进方向：左变右或者右变左。
 *      重复第二步和第三步，直到你在树中无法继续移动。
 *      交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。
 * 请你返回给定树中最长 交错路径 的长度。
 * </p>
 */
public class L1372_LongestZigZag {
    public static void main(String[] args) {

    }

    private static int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, 1, 0), dfs(root.right, -1, 0));
    }

    private static int dfs(TreeNode root, int orient, int len) {
        if (root == null) {
            return len;
        }
        if (orient == 1) {
            return Math.max(dfs(root.right, -1, len + 1), dfs(root.left, 1, 0));
        } else {
            return Math.max(dfs(root.left, 1, len + 1), dfs(root.right, -1, 0));
        }
    }
}
