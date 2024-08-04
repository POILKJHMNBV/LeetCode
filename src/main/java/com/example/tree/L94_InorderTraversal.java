package com.example.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class L94_InorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(inorderTraversalPlus(root));
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    private static List<Integer> inorderTraversalPlus(TreeNode root) {
        return BinaryTreeUtil.lvrStack(root);
    }
}