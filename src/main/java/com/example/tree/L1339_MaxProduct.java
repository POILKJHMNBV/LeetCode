package com.example.tree;

/**
 * <p>L1339:分裂二叉树的最大乘积</p>
 * @author zhenwu
 * @date 2025/11/1 15:33
 */
public class L1339_MaxProduct {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(5);
        treeNode1.right = new TreeNode(6);

        root.left = treeNode;
        root.right = treeNode1;
        System.out.println(maxProduct(root));
    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static int maxProduct(TreeNode root) {
        sum = dfs(root);
        dfs(root);
        long prod = (long) (sum - bestSplitSum) * bestSplitSum;
        return (int) (prod % 1000000007);
    }
    private static int sum = 0, bestSplitSum = 0;
    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curSum = root.val + dfs(root.left) + dfs(root.right);
        if (sum > 0 && Math.abs(sum - 2 * curSum) < Math.abs(sum - 2 * bestSplitSum)) {
            bestSplitSum = curSum;
        }
        return curSum;
    }
}
