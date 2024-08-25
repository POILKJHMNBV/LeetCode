package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L501:二叉搜索树中的众数</p>
 * @author zhenwu
 * @date 2024/8/25 15:44
 */
public class L501_FindMode {
    public static void main(String[] args) {

    }

    private static int[] findMode(TreeNode root) {
        res = new ArrayList<>();
        traversal(root);
        return res.stream().mapToInt(num -> num).toArray();
    }


    private static List<Integer> res;
    private static int maxCount;
    private static int count;
    private static TreeNode pre;

    private static void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        count = pre != null && root.val == pre.val ? count + 1 : 1;
        pre = root;
        if (count == maxCount) {
            res.add(root.val);
        }

        if (count > maxCount) {
            // 找到了新的众数
            maxCount = count;
            res.clear();
            res.add(root.val);
        }
        traversal(root.right);
    }
}
