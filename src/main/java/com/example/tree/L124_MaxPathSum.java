package com.example.tree;

/**
 * <p>L124:二叉树中的最大路径和</p>
 * <p>二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。</p>
 */
public class L124_MaxPathSum {
    public static void main(String[] args) {

    }

    private static int maxPathSum = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        process(root);
        return maxPathSum;
    }

    private static int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxPathSum = process(root.left);
        int rightMaxPathSum = process(root.right);
        maxPathSum = Math.max(maxPathSum, leftMaxPathSum + rightMaxPathSum + root.val);
        return Math.max(0, Math.max(leftMaxPathSum, Math.max(0, rightMaxPathSum)) + root.val);
    }
}
