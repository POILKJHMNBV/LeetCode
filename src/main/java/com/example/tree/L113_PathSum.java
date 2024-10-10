package com.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>L113:路径总和 II</p>
 * @author zhenwu
 * @date 2024/10/10 20:26
 */
public class L113_PathSum {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(h)
     */
    private static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Integer> path = new LinkedList<>();
        path.add(root.val);
        dfs(root, targetSum - root.val, res, path);
        return res;
    }

    private static void dfs(TreeNode root,
                            int targetSum,
                            List<List<Integer>> res,
                            LinkedList<Integer> path) {
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        if (root.left != null) {
            path.add(root.left.val);
            dfs(root.left, targetSum - root.left.val, res, path);
            path.removeLast();
        }

        if (root.right != null) {
            path.add(root.right.val);
            dfs(root.right, targetSum - root.right.val, res, path);
            path.removeLast();
        }
    }
}
