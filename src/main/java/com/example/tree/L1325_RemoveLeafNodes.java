package com.example.tree;

/**
 * <p>L1325:删除给定值的叶子节点</p>
 * @author zhenwu
 * @date 2025/11/6 22:01
 */
public class L1325_RemoveLeafNodes {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static TreeNode removeLeafNodes(TreeNode root, int target) {
        dfs(root, target);
        return root.val == target && root.left == null && root.right == null ? null : root;
    }

    private static boolean dfs(TreeNode root, int target) {
        if (root == null) {
            return true;
        }
        boolean leftEqualsTarget = dfs(root.left, target);
        boolean rightEqualsTarget = dfs(root.right, target);
        if (leftEqualsTarget) {
            root.left = null;
        }
        if (rightEqualsTarget) {
            root.right = null;
        }
        return root.val == target && leftEqualsTarget && rightEqualsTarget;
    }
}
