package com.example.tree;

/**
 * L105:从前序与中序遍历序列构造二叉树
 */
public class L105_BuildTree {
    public static void main(String[] args) {

    }

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            throw new IllegalArgumentException();
        }
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength != inLength) {
            throw new IllegalArgumentException();
        }
        return buildTree(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }

    private static TreeNode buildTree(int[] preorder, int preLeft, int preRight,
                                      int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pivot = inLeft;
        while (inorder[pivot] != preorder[preLeft]) {
            pivot++;
        }
        root.left = buildTree(preorder, preLeft + 1, preLeft + pivot - inLeft,
                            inorder, inLeft, pivot - 1);
        root.right = buildTree(preorder, preLeft + pivot - inLeft + 1, preRight,
                                inorder, pivot + 1, inRight);
        return root;
    }
}
