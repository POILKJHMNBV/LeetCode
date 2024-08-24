package com.example.tree;

/**
 * <p>L106:从中序与后序遍历序列构造二叉树</p>
 * @author zhenwu
 * @date 2024/8/24 15:17
 */
public class L106_BuildTree {
    public static void main(String[] args) {

    }

    private static TreeNode buildTree(int[] inorder, int[] postorder) {
        return BinaryTreeUtil.buildTreeIP(inorder, postorder);
    }
}
