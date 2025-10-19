package com.example.tree;

import java.util.List;

/**
 * <p>L1026:节点与其祖先之间的最大差值</p>
 * @author zhenwu
 * @date 2025/10/19 14:52
 */
public class L1026_MaxAncestorDiff {
    public static void main(String[] args) {

    }

    private static int maxAncestorDiff(TreeNode root) {
        dfs(new java.util.ArrayList<>(), root);
        return res;
    }

    private static int res = 0;

    /**
     * 递归解法
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static void dfs(List<Integer> ancestors, TreeNode node) {
        if (node == null) {
            return;
        }
        for (int ancestor : ancestors) {
            res = Math.max(res, Math.abs(node.val - ancestor));
        }
        ancestors.add(node.val);
        dfs(ancestors, node.left);
        dfs(ancestors, node.right);
        ancestors.remove(ancestors.size() - 1);
    }

    /**
     * 进阶做法：本质是寻找根节点到叶子节点之间最大的差值
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static void dfs(TreeNode node, int min, int max) {
        if (node == null) {
            res = Math.max(res, max - min);
            return;
        }
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);
        dfs(node.left, min,  max);
        dfs(node.right, min, max);
    }
}
