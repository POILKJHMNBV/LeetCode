package com.example.tree;

/**
 * <p>L1372:二叉树中的最长交错路径</p>
 * @author zhenwu
 * @date 2025/10/22 21:58
 */
public class L1372_LongestZigZag {
    public static void main(String[] args) {

    }

    private static int longestZigZag(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, 0, 0);
        return ans;
    }

    private static int ans = 0;

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static void dfs(TreeNode root, int leftLen, int rightLen) {
        ans = Math.max(ans, Math.max(leftLen, rightLen));
        if (root.left != null) {
            dfs(root.left, rightLen + 1, 0);
        }
        if (root.right != null) {
            dfs(root.right, 0, leftLen + 1);
        }
    }
}
