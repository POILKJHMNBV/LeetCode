package com.example.tree;

/**
 * <p>L701:二叉搜索树中的插入操作</p>
 * @author zhenwu
 * @date 2024/8/26 19:50
 */
public class L701_InsertIntoBST {
    public static void main(String[] args) {

    }

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}