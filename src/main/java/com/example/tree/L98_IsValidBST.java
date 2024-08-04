package com.example.tree;

/**
 * L98：验证二叉搜索树
 */
public class L98_IsValidBST {
    public static void main(String[] args) {

    }

    private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root) &&
               isValidBST(root.right, root, max);
    }
}