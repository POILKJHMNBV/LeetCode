package com.example.dp;

import com.example.tree.TreeNode;

/**
 * <p>L865:具有所有最深节点的最小子树</p>
 * <p>
 *      给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 *      返回包含原始树中所有 最深节点 的 最小子树 。
 *      如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 *      一个节点的 子树 是该节点加上它的所有后代的集合。
 * </p>
 */
public class L865_SubtreeWithAllDeepest {
    public static void main(String[] args) {

    }

    private static TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).treeNode;
    }

    private static Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        Pair leftPair = dfs(root.left);
        Pair rightPair = dfs(root.right);
        if (leftPair.height > rightPair.height) {
            return new Pair(leftPair.treeNode, leftPair.height + 1);
        }
        if (leftPair.height < rightPair.height) {
            return new Pair(rightPair.treeNode, rightPair.height + 1);
        }
        return new Pair(root, leftPair.height + 1);
    }

    static class Pair {
        private final TreeNode treeNode;
        private final int height;

        public Pair(TreeNode treeNode, int height) {
            this.treeNode = treeNode;
            this.height = height;
        }
    }
}
