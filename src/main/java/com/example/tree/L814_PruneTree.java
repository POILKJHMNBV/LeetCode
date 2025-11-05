package com.example.tree;

/**
 * <p>L814:二叉树剪枝</p>
 * @author zhenwu
 * @date 2025/11/5 21:29
 */
public class L814_PruneTree {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static TreeNode pruneTree(TreeNode root) {
        boolean needPrune = dfs(root);
        return needPrune ? null : root;
    }

    private static boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left) {
            // 左子树全为0
            root.left = null;
        }
        if (right) {
            // 右子树全为0
            root.right = null;
        }
        // 返回结果
        return left && right && root.val == 0;
    }
}
