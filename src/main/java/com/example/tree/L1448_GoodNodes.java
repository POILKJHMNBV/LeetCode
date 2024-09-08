package com.example.tree;

/**
 * <p>L1448:统计二叉树中好节点的数目</p>
 * @author zhenwu
 * @date 2024/9/8 15:01
 */
public class L1448_GoodNodes {
    public static void main(String[] args) {

    }

    private static int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private static int dfs(TreeNode root, int pathMax) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        if (root.val >= pathMax) {
            res++;
            pathMax = root.val;
        }
        res += dfs(root.left, pathMax) + dfs(root.right, pathMax);
        return res;
    }
}