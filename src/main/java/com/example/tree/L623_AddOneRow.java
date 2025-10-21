package com.example.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>L623:在二叉树中增加一行</p>
 * @author zhenwu
 * @date 2025/10/21 22:02
 */
public class L623_AddOneRow {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int val = 1, depth = 1;
        TreeNode ans = addOneRow(root, val, depth);
        System.out.println(ans);
    }

    /**
     * 层次遍历
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            depth--;
            if (depth == 1) {
                break;
            }
            for (int i = 0, n = queue.size(); i < n; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            node.left.left = left;
            node.right.right = right;
        }
        return root;
    }
}
