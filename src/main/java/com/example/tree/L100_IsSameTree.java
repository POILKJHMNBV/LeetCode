package com.example.tree;

/**
 * <p>L100:相同的树</p>
 * @author zhenwu
 * @date 2024/10/7 20:42
 */
public class L100_IsSameTree {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(min(m,n))   空间：O(min(m,n))
     */
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        // 递归比较左右子树
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}