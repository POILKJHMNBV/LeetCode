package com.example.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 */
public class L145_PostorderTraversal {
    public static void main(String[] args) {

    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        TreeNode current = root;
        TreeNode r = null;
        while (current != null || !arrayDeque.isEmpty()) {
            if (current != null) {
                arrayDeque.push(current);
                current = current.left;
            } else {
                TreeNode treeNode = arrayDeque.peek();
                if (treeNode.right != null && treeNode.right != r) {
                    current = treeNode.right;
                } else {
                    TreeNode node = arrayDeque.pop();
                    result.add(node.val);
                    r = node;
                }
            }
        }
        return result;
    }
}
