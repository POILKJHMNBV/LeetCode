package com.example.tree;

/**
 * <p>L654:最大二叉树</p>
 * <p>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * 1.创建一个根节点，其值为 nums 中的最大值。
 * 2.递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 3.递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * </p>
 *
 * @author zhenwu
 * @date 2024/8/24 15:28
 */
public class L654_ConstructMaximumBinaryTree {
    public static void main(String[] args) {

    }

    private static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int maxIndex = max(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, left, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, right);
        return root;
    }

    private static int max(int[] nums, int left, int right) {
        int maxIndex = left, maxValue = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
