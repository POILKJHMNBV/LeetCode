package com.example.tree;

/**
 * <p>L572:另一棵树的子树</p>
 * @author zhenwu
 * @date 2025/11/3 21:32
 */
public class L572_IsSubtree {
    public static void main(String[] args) {

    }

    /**
     * 判断root树是否包含subRoot树
     * 时间复杂度：O(n * min(m, n))
     * 空间复杂度：O(n)
     */
    private static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
