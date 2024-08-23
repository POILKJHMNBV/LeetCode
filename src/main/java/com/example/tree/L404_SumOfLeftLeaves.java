package com.example.tree;

/**
 * <p>L404:左叶子之和</p>
 * @author zhenwu
 * @date 2024/8/23 21:47
 */
public class L404_SumOfLeftLeaves {
    public static void main(String[] args) {

    }

    private static int sumOfLeftLeaves(TreeNode root) {
        return dfs(root.left, true) + dfs(root.right, false);
    }

    private static int dfs(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null && left) {
            return root.val;
        }
        return dfs(root.left, true) + dfs(root.right, false);
    }
}
