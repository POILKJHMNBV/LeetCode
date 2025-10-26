package com.example.tree;

/**
 * <p>L2331:计算布尔二叉树的值</p>
 * @author zhenwu
 * @date 2025/10/26 14:46
 */
public class L2331_EvaluateTree {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val == 1;
        }
        if (root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
