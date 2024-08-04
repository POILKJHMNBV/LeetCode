package com.example.dp;

import com.example.tree.TreeNode;

/**
 * <p>L337:小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。</p>
 * <p>除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。</p>
 * <p>给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。</p>
 */
public class L337_Rob {
    public static void main(String[] args) {

    }

    private static int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] dp = new int[2];

        // dp[0]表示不偷当前节点所能获取的最大金额
        // dp[1]表示偷当前节点所能获取的最大金额
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}
