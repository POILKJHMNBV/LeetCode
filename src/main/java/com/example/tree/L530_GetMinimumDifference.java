package com.example.tree;

/**
 * <p>L530:二叉搜索树的最小绝对差</p>
 * <p>
 *     给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * </p>
 * @author zhenwu
 * @date 2024/8/25 15:20
 */
public class L530_GetMinimumDifference {
    public static void main(String[] args) {

    }

    private static TreeNode pre;

    private static int minDiff = Integer.MAX_VALUE;

    private static int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        traversal(root);
        return minDiff;
    }

    private static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
