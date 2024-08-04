package com.example.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L437:路径总和 III</p>
 * <p>给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。</p>
 */
public class L437_PathSum {
    public static void main(String[] args) {

    }

    private static int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        Map<Long, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0L, 1);
        return process(root, prefixCountMap, targetSum, 0L);
    }


    private static int process(TreeNode treeNode, Map<Long, Integer> prefixCountMap, int targetSum, long curSum) {
        if (treeNode == null) {
            return 0;
        }
        int res = 0;
        curSum += treeNode.val;

        res += prefixCountMap.getOrDefault(curSum - targetSum, 0);
        prefixCountMap.put(curSum, prefixCountMap.getOrDefault(curSum, 0) + 1);

        res += process(treeNode.left, prefixCountMap, targetSum, curSum);
        res += process(treeNode.right, prefixCountMap, targetSum, curSum);

        prefixCountMap.put(curSum, prefixCountMap.get(curSum) - 1);
        return res;
    }
}
