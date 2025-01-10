package com.example.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L993:二叉树的堂兄弟节点</p>
 * @author zhenwu
 * @date 2025/1/10 21:29
 */
public class L993_IsCousins {
    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 3, 5};
        int[] inorder = {2, 4, 1, 3, 5};
        TreeNode treeNode = BinaryTreeUtil.buildTreePI(preorder, inorder);
        System.out.println(isCousins(treeNode, 5, 4));
    }

    private static boolean isCousins(TreeNode root, int x, int y) {
        if (x == root.val || y == root.val) {
            return false;
        }
        int height = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int xParent = -1, yParent = -1, xHeight = 0, yHeight = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (treeNode.val == x) {
                    xHeight = height;
                }
                if (treeNode.val == y) {
                    yHeight = height;
                }
                if (xParent == -1) {
                    xParent = getParent(x, treeNode);
                }
                if (yParent == -1) {
                    yParent = getParent(y, treeNode);
                }
            }
            if (xHeight != 0 && xHeight == yHeight) {
                break;
            }
        }
        return xHeight == yHeight && xParent != yParent;
    }

    private static int getParent(int num, TreeNode treeNode) {
        int parent = -1;
        if (treeNode.left != null && treeNode.left.val == num) {
            parent = treeNode.val;
        }
        if (treeNode.right != null && treeNode.right.val == num) {
            parent = treeNode.val;
        }
        return parent;
    }
}
