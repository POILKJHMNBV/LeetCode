package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L95:不同的二叉搜索树 II</p>
 * @author zhenwu
 * @date 2024/8/22 21:08
 */
public class L95_GenerateTrees {
    public static void main(String[] args) {

    }

    private static List<TreeNode> generateTrees(int n) {
        return dfs(1, n);
    }

    private static List<TreeNode> dfs(int l, int r) {
        if (l > r) {
            List<TreeNode> list = new ArrayList<>();
            list.add(null);
            return list;
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            for (TreeNode left : dfs(l, i - 1)) {
                for (TreeNode right : dfs(i + 1, r)) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
