package com.example.tree;

/**
 * <p>L129:求根节点到叶节点数字之和</p>
 * @author zhenwu
 * @date 2024/10/12 21:21
 */
public class L129_SumNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    /**
     * 时间：O(n)   空间：O(h)
     */
    private static int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    static int sum = 0;

    private static void dfs(TreeNode root, int prevSum) {
        if (root.left == null && root.right == null) {
            sum += (prevSum * 10 + root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, prevSum * 10 + root.val);
        }
        if (root.right != null) {
            dfs(root.right, prevSum * 10 + root.val);
        }
    }
}
