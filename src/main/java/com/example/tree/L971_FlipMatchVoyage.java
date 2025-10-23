package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L971:翻转二叉树以匹配先序遍历</p>
 * @author zhenwu
 * @date 2025/10/23 22:04
 */
public class L971_FlipMatchVoyage {
    public static void main(String[] args) {

    }

    private static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? ans : List.of(-1);
    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static boolean dfs(TreeNode node, int[] voyage) {
        if (node == null) {
            return true;
        }
        if (node.val != voyage[idx]) {
            // 不符合先序遍历预期
            return false;
        }
        idx++;
        if (node.left != null && node.left.val != voyage[idx]) {
            // 左子树不符合先序遍历预期，先遍历右子树，再遍历左子树
            ans.add(node.val);
            return dfs(node.right, voyage) && dfs(node.left, voyage);
        }
        return dfs(node.left, voyage) && dfs(node.right, voyage);
    }

    private static int idx = 0;
    private static final List<Integer> ans = new ArrayList<>();
}
