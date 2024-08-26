package com.example.tree;

/**
 * <p>L538:把二叉搜索树转换为累加树</p>
 * @author zhenwu
 * @date 2024/8/26 20:43
 */
public class L538_ConvertBST {
    public static void main(String[] args) {

    }

    private static int sum = 0;

    private static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
