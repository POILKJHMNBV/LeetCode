package com.example.tree;

/**
 * <p>L1457:二叉树中的伪回文路径</p>
 * @author zhenwu
 * @date 2025/10/16 21:29
 */
public class L1457_PseudoPalindromicPaths {
    public static void main(String[] args) {

    }

    /**
     * 思路：
     * 1. 利用mask记录根节点到叶子节点的路径中，某个数字出现偶数次，则该数字的mask位为0，奇数次则该数字的mask位为1
     * 2. 若最终的 mask 中 含有1的个数小于 <= 1，则该路径为伪回文路径
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int mask) {
        if (root == null) {
            return 0;
        }
        // 改变该数字出现的次数
        mask ^= 1 << root.val;
        if (root.left == null && root.right == null) {
            // 到达叶子节点
            return (mask & (mask - 1)) == 0 ? 1 : 0;
        }
        return dfs(root.left, mask) + dfs(root.right, mask);
    }
}
