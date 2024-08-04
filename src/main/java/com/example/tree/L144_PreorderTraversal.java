package com.example.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的先序遍历
 */
public class L144_PreorderTraversal {
    public static void main(String[] args) {

    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        return BinaryTreeUtil.vlrStack(root);
    }
}
