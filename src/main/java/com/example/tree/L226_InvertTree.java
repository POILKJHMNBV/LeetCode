package com.example.tree;

/**
 * <p>L226:翻转二叉树</p>
 * <p>给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。</p>
 */
public class L226_InvertTree {
    public static void main(String[] args) {

    }

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
