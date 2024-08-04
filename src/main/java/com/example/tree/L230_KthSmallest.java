package com.example.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * L230:二叉搜索树中第K小的元素
 */
public class L230_KthSmallest {
    public static void main(String[] args) {

    }

    private static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int count = 0;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode treeNode = stack.pop();
                count++;
                if (count == k) {
                    return treeNode.val;
                }
                cur = treeNode.right;
            }
        }
        throw new IllegalArgumentException();
    }
}
