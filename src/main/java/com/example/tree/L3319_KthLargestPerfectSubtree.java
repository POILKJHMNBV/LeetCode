package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L3319:第 K 大的完美二叉子树的大小</p>
 * @author zhenwu
 * @date 2025/10/31 21:02
 */
public class L3319_KthLargestPerfectSubtree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(6);

        root.left = treeNode;
        root.right = treeNode1;
        int k = 1;
        System.out.println(kthLargestPerfectSubtree(root, k));
    }

    /**
     * dfs
     * 时间复杂度: O(n log n)
     * 空间复杂度: O(n)
     */
    private static int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, nums);
        nums.sort((a, b) -> b - a);
        return k > nums.size() ? -1 : nums.get(k - 1);
    }

    private static item dfs(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return new item(0, 0);
        }
        item left = dfs(root.left, nums);
        item right = dfs(root.right, nums);
        if (left.equals(right) && Math.pow(2, left.level) - 1 == left.count) {
            nums.add(left.count * 2 + 1);
        }
        return new item(Math.max(left.level, right.level) + 1, left.count + right.count + 1);
    }

    private record item(int level, int count){
    }
}
