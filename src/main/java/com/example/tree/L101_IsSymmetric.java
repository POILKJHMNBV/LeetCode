package com.example.tree;

/**
 * <p>L101:对称二叉树</p>
 * <p>给你一个二叉树的根节点 root ， 检查它是否轴对称。</p>
 */
public class L101_IsSymmetric {
    public static void main(String[] args) {

    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private static boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == root2) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
    }
}
