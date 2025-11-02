package com.example.tree;

/**
 * <p>L1145:二叉树着色游戏</p>
 * @author zhenwu
 * @date 2025/11/2 15:29
 */
public class L1145_BtreeGameWinningMove {
    public static void main(String[] args) {

    }

    /**
     * dfs + 贪心
     * 设 m 为二号玩家可以染色的节点数，lsz 为 x 节点的左子树节点数，rsz 为 x 节点的右子树节点数，则 x 的父节点子树节点数为 n - 1 - lsz - rsz
     * m = max(lsz, rsz, n - 1 - lsz - rsz)
     * 一号玩家染色节点个数为 n - m, 二号玩家获胜条件为 m > n - m， 即 2 * m > n
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        dfs(root, x);
        // n - 1 - lsz - rsz 父节点子树节点数
        return Math.max(Math.max(lsz, rsz), n - 1 - lsz - rsz) * 2 > n;
    }

    private static int dfs(TreeNode root, int x) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left, x);
        int r = dfs(root.right, x);
        if (root.val == x) {
            lsz = l;
            rsz = r;
        }
        return l + r + 1;
    }

    /**
     * lsz:左子树节点数
     * rsz:右子树节点数
     */
    private static int lsz, rsz;
}
