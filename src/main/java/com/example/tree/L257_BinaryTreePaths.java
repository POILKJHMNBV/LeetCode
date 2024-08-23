package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L257:二叉树的所有路径</p>
 * <p>
 *     给你一个二叉树的根节点 root，按任意顺序，返回所有从根节点到叶子节点的路径。
 * </p>
 * @author zhenwu
 * @date 2024/8/23 21:36
 */
public class L257_BinaryTreePaths {
    public static void main(String[] args) {

    }

    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, res, "");
        return res;
    }

    private static void dfs(TreeNode root, List<String> res, String path) {
        if (root.left == null && root.right == null) {
            path += root.val;
            res.add(path);
            return;
        }
        path = path + root.val + "->";
        if (root.left != null) {
            dfs(root.left, res, path);
        }
        if (root.right != null) {
            dfs(root.right, res, path);
        }
    }
}
