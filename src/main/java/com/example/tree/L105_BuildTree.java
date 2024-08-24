package com.example.tree;

/**
 * L105:从前序与中序遍历序列构造二叉树
 */
public class L105_BuildTree {
    public static void main(String[] args) {

    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        return BinaryTreeUtil.buildTreePI(preorder, inorder);
    }
}
