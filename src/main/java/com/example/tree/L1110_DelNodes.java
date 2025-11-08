package com.example.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>L1110:删点成林</p>
 * @author zhenwu
 * @date 2025/11/7 21:35
 */
public class L1110_DelNodes {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> res = new ArrayList<>();
        dfs(root, set, res);
        if (!set.contains(root.val)) {
            res.add(root);
        }
        return res;
    }

    private static boolean dfs(TreeNode root,
                            Set<Integer> set,
                            List<TreeNode> res) {
        if (root == null) {
            return true;
        }
        boolean leftNeedDelete = dfs(root.left, set, res);
        boolean rightNeedDelete = dfs(root.right, set, res);
        if (leftNeedDelete) {
            root.left = null;
        } else if (set.contains(root.val)) {
            res.add(root.left);
        }
        if (rightNeedDelete) {
            root.right = null;
        } else if (set.contains(root.val)) {
            res.add(root.right);
        }
        return set.contains(root.val);
    }
}
