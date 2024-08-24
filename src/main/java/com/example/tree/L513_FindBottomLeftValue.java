package com.example.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L513:找树左下角的值</p>
 * <p>
 *     给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 *     假设二叉树中至少有一个节点。
 * </p>
 * @author zhenwu
 * @date 2024/8/24 14:52
 */
public class L513_FindBottomLeftValue {
    public static void main(String[] args) {

    }

    private static int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (i == 0 && treeNode.left == null && treeNode.right == null) {
                    res = treeNode.val;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return res;
    }
}
