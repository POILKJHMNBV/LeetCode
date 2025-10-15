package com.example.tree;

/**
 * <p>L671:二叉树中第二小的节点</p>
 * @author zhenwu
 * @date 2025/10/15 21:49
 */
public class L671_FindSecondMinimumValue {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8, new TreeNode(5), new TreeNode(5));
        System.out.println(findSecondMinimumValue(root));
    }

    private static int res = -1;
    private static int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static void dfs(TreeNode root, int min) {
        if (root == null) {
            return;
        }
        if (root.val > min && (res == -1 || root.val < res)) {
            res = root.val;
        }
        dfs(root.left, min);
        dfs(root.right, min);
    }

}
