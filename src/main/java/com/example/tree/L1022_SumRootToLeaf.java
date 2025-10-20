package com.example.tree;

/**
 * <p>L1022:从根到叶的二进制数之和</p>
 * @author zhenwu
 * @date 2025/10/20 21:30
 */
public class L1022_SumRootToLeaf {
    public static void main(String[] args) {

    }

    private static int sumRootToLeaf(TreeNode root) {
        dfs(root, "");
        return ans;
    }

    /**
     * 递归解法
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static int dfs(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        cur = (cur << 1) | root.val;
        return root.left == null && root.right == null ? cur :
                dfs(root.left, cur) + dfs(root.right, cur);
    }

    private static void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s += root.val;
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(s, 2);
            return;
        }
        dfs(root.left, s);
        dfs(root.right, s);
    }

    private static int ans = 0;
}
