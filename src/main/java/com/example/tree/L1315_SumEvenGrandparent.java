package com.example.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>L1315:祖父节点值为偶数的节点和</p>
 * @author zhenwu
 * @date 2025/10/17 20:56
 */
public class L1315_SumEvenGrandparent {
    public static void main(String[] args) {

    }

    /**
     * 广度优先遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.val % 2 != 0) {
                continue;
            }
            if (node.left != null) {
                if (node.left.left != null) {
                    res += node.left.left.val;
                }
                if (node.left.right != null) {
                    res += node.left.right.val;
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    res += node.right.left.val;
                }
                if (node.right.right != null) {
                    res += node.right.right.val;
                }
            }
        }
        return res;
    }
}
