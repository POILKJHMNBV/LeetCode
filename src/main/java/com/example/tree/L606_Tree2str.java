package com.example.tree;

/**
 * <p>L606:根据二叉树创建字符串</p>
 * @author zhenwu
 * @date 2025/10/29 22:04
 */
public class L606_Tree2str {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1, sb.length() - 1);
    }

    private static void dfs(TreeNode root) {
        sb.append("(");
        sb.append(root.val);
        if (root.left != null) dfs(root.left);
        else if (root.right != null) sb.append("()");
        if (root.right != null) dfs(root.right);
        sb.append(")");
    }

    private static final StringBuilder sb = new StringBuilder();

}
