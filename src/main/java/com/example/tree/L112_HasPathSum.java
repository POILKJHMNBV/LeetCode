package com.example.tree;

/**
 * <p>L112:路径总和</p>
 * <p>给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。</p>
 */
public class L112_HasPathSum {
    public static void main(String[] args) {

    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return traversal(root, targetSum - root.val);
    }

    private static boolean traversal(TreeNode root, int count) {

        // 到达叶子结点，找到满足条件的路径
        if (root.left == null && root.right == null) {
            return count == 0;
        }

        // 向左递归
        if (root.left != null) {
            if (traversal(root.left, count - root.left.val)) {
                // 左子树找到符合条件的值
                return true;
            }
        }

        // 向右递归
        if (root.right != null) {
            // 右子树找到符合条件的值
            return traversal(root.right, count - root.right.val);
        }
        return false;
    }
}
