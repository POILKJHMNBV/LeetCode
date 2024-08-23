package com.example.tree;

/**
 * <p>L110:平衡二叉树</p>
 * <p>
 *     给定一个二叉树，判断它是否是平衡二叉树
 * </p>
 * @author zhenwu
 * @date 2024/8/23 21:24
 */
public class L110_IsBalanced {
    public static void main(String[] args) {

    }

    private static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        if (leftHeight == -1) {
            // 左子树不是平衡二叉树，直接返回
            return -1;
        }
        int rightHeight = height(root.right);
        if (rightHeight == -1) {
            // 右子树不是平衡二叉树，直接返回
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }
}
