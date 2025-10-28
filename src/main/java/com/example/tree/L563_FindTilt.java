package com.example.tree;

/**
 * <p>L563:二叉树的坡度</p>
 * @author zhenwu
 * @date 2025/10/28 21:42
 */
public class L563_FindTilt {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    private static int tilt = 0;

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
