package com.example.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>L103:叉树的锯齿形层序遍历</p>
 * @author zhenwu
 * @date 2024/10/9 21:35
 */
public class L103_ZigzagLevelOrder {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(1)
     */
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (height % 2 == 1) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            height++;
            res.add(list);
        }
        return res;
    }
}
