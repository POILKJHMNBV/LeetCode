package com.example.tree;

/**
 * <p>L1038:从二叉搜索树到更大和树</p>
 *
 * @author zhenwu
 * @date 2025/11/8 18:26
 */
public class L1038_BstToGst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        bstToGst(root);
        System.out.println("Hello World!");
    }

    private static TreeNode bstToGst(TreeNode root) {
        return dfs(root);
    }

    private static int sum = 0;

    private static TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root.right);
        sum += root.val;
        root.val = sum;
        dfs(root.left);
        return root;
    }
}
