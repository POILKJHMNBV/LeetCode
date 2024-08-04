package com.example.tree;

import java.util.*;

/**
 * <p>L199:二叉树的右视图</p>
 * <p>给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。</p>
 */
public class L199_RightSideView {
    public static void main(String[] args) {

    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            res.add(deque.peekLast().val);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.poll();
                if (treeNode.left != null){
                    deque.offer(treeNode.left);
                }
                if (treeNode.right != null){
                    deque.offer(treeNode.right);
                }
            }
        }
        return res;
    }
}
