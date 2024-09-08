package com.example.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L1161:最大层内元素和</p>
 * @author zhenwu
 * @date 2024/9/8 15:33
 */
public class L1161_MaxLevelSum {
    public static void main(String[] args) {

    }

    private static int maxLevelSum(TreeNode root) {
        int maxSum = root.val, maxLevelSum = 1, level = 1;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    sum += treeNode.left.val;
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    sum += treeNode.right.val;
                    queue.offer(treeNode.right);
                }
            }
            if (sum > maxSum) {
                maxLevelSum = level;
                maxSum = sum;
            }
        }
        return maxLevelSum == level ? maxLevelSum - 1 : maxLevelSum;
    }
}
